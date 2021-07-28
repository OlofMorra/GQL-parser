package gql.tables;

import com.google.common.collect.HashMultiset;
import exceptions.SemanticErrorException;
import gql.expressions.Expression;
import gql.expressions.filters.ComparisonExpression;
import gql.expressions.references.PropertyReference;
import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.TruthValue;
import gql.expressions.values.Value;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

public class BindingTable {
    private boolean hasDuplicates;
    private String[] columnNames;
    private HashMultiset<Record> records;

    public BindingTable(boolean hasDuplicates, String[] columnNames) {
        this.hasDuplicates = hasDuplicates;
        this.columnNames = columnNames;
        this.records = HashMultiset.create();
    }

    public BindingTable clone() {
        BindingTable clone = new BindingTable(hasDuplicates, columnNames);
        clone.setRecords(getRecords());
        return clone;
    }

    public void isOptional() {
        if (this.records.size() > 0) return;

        Value[] nullValues = new Value[this.columnNames.length];
        Arrays.fill(nullValues, new TruthValue(null));
        this.addRecord(new Record(this.columnNames, nullValues));
    }

    public void isMandatory() {
        if (this.records.size() < 1) throw new IllegalStateException("Illegal state: There is no record matching to the mandatory path pattern list.");
    }

    public void makeDistinct() {
        if (!this.hasDuplicates) return;

        this.hasDuplicates = false;
        HashMultiset<Record> newRecords = HashMultiset.create();

        for (Record record: this.records) {
            if (!newRecords.contains(record)) {
                newRecords.add(record);
            }
        }

        this.records = newRecords;
    }

    public void filter(Expression expression) {
        if (expression instanceof TruthValue) {
            filterWithTruthValue((TruthValue) expression);
            return;
        } else if (expression instanceof ComparisonExpression) {
            filterWithComparison((ComparisonExpression) expression);
            return;
        } else if (expression instanceof PropertyReference) {
            filterWithPropertyReference((PropertyReference) expression);
            return;
        }

        throw new SemanticErrorException("Expression is not valid");
    }

    private void filterWithTruthValue(TruthValue expression) {
        if (!expression.equals(new TruthValue(true))) {
            this.records = HashMultiset.create();
        }
    }

    private void filterWithPropertyReference(PropertyReference expression) {
        HashMultiset<Record> newRecords = HashMultiset.create();

        for (Record record: this.records) {
            if (propertyReferenceEvaluatesToTrue(expression, record)) {
                newRecords.add(record);
            }
        }

        this.records = newRecords;
    }

    private void filterWithComparison(ComparisonExpression expression) {
        HashMultiset<Record> newRecords = HashMultiset.create();
    
        for (Record record: this.records) {
            if (expressionEvaluatesToTrue(expression, record)) {
                newRecords.add(record);
            }
        }
    
        this.records = newRecords;
    }

    private boolean propertyReferenceEvaluatesToTrue(PropertyReference expression, Record record) {
        return expression.getValueFrom(record).equals(new TruthValue(true));
    }

    private boolean expressionEvaluatesToTrue(ComparisonExpression expression, Record record) {
        TruthValue evaluationResult = expression.evaluateOn(record);
        return evaluationResult.equals(new TruthValue(true));
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public void updateDomain(HashMap<Integer, GqlIdentifier> domain) {
        ArrayList<Integer> unmappedColumnIndices = new ArrayList<>();

        for (int i = 0; i < columnNames.length; i ++) {
            if (domain.containsKey(Integer.parseInt(columnNames[i]))) {
                columnNames[i] = domain.get(Integer.parseInt(columnNames[i])).getId();
            } else {
                unmappedColumnIndices.add(i);
            }
        }

        unmappedColumnIndices.sort(Collections.reverseOrder());

        for (Record record: records) {
            record.updateColumnNames(columnNames);
            record.removeColumns(unmappedColumnIndices);
        }

        removeColumnNames(unmappedColumnIndices);
    }

    private void removeColumnNames(ArrayList<Integer> unmappedColumnIndices) {
        for (int idx: unmappedColumnIndices) {
            columnNames = (String[]) ArrayUtils.remove(columnNames, idx);
        }
    }

    public void setRecords(HashMultiset<Record> records) {
        this.records = records;
    }

    public HashMultiset<Record> getRecords() {
        return HashMultiset.create(records);
    }

    public boolean hasDuplicates() {
        return hasDuplicates;
    }

    public boolean hasRecords() {
        return !this.records.isEmpty();
    }

    private void removeRecords(ArrayList<Record> recordsToRemove) {
        records.removeAll(recordsToRemove);
    }

    public void removeRecord(Record record) {
        records.remove(record);
    }

    public void addRecord(Record record) {
        if (record.values.length != columnNames.length) {
            throw new SemanticErrorException("Record does not have the same amount of values as there are column names.");
        } else if (!Arrays.equals(record.columnNames, this.columnNames)) {
            throw new SemanticErrorException("Record does not have the same column names as the the binding table.");
        }

        this.records.add(record);
    }

    public void addRecordMultipleTimes(Record record, int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            addRecord(record);
        }
    }

    public void addRecords(ArrayList<Record> records) {
        for (Record record: records) {
            addRecord(record);
        }
    }

    public void addRecords(HashMultiset<Record> records) {
        for (Record record: records) {
            addRecord(record);
        }
    }

    public void printToConsole() {
        if (hasColumns()) {
            printBindingTable();
        } else {
            System.out.println("The current output table is empty.");
        }
    }

    private void printBindingTable() {
        int[] columnWidths = getMaxColumnWidths();
        String stringFormat = getStringFormat(columnWidths);
        String separatorLine = getSeparatorLine(columnWidths);

        System.out.println(separatorLine);
        System.out.printf(stringFormat, this.columnNames);
        System.out.println(separatorLine);

        for (Record record: records) {
            System.out.printf(stringFormat, record.values);
        }

        System.out.println(separatorLine);
    }

    private boolean hasColumns() {
        return columnNames.length != 0;
    }

    private String getStringFormat(int[] columnWidths) {
        final StringBuilder stringFormat = new StringBuilder("");

        for (int columnWidth : columnWidths) {
            stringFormat.append("| %-").append(columnWidth + 1).append("s");
        }

        stringFormat.append("|\n");

        return stringFormat.toString();
    }

    private String getSeparatorLine(int[] columnWidths) {
        String separatorLine = "+";
        String elm = "-";

        for (int columWidth: columnWidths) {
            separatorLine = separatorLine + elm + StringUtils.repeat(elm, columWidth + 1) + "+";
        }

        return separatorLine;
    }

    private int[] getMaxColumnWidths() {
        int[] maxColumnWidths = new int[this.columnNames.length];

        for (int i = 0; i < columnNames.length; i++) {
            maxColumnWidths[i] = columnNames[i].length();
        }

        for (Record record: records) {
            setToMaxColumnWidths(maxColumnWidths, record.getNrOfCharactersPerValue());
        }

        return maxColumnWidths;
    }

    private void setToMaxColumnWidths(int [] maxColumnWidths, int[] columnWidths) {
        for (int i = 0; i < maxColumnWidths.length; i++) {
            if (maxColumnWidths[i] < columnWidths[i]) {
                maxColumnWidths[i] = columnWidths[i];
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BindingTable that = (BindingTable) o;
        Object[] thisRecords = records.toArray();
        Object[] thatRecords = records.toArray();

        return hasDuplicates == that.hasDuplicates && Arrays.equals(columnNames, that.columnNames)
                && Arrays.equals(thisRecords, thatRecords);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(hasDuplicates, records);
        result = 31 * result + Arrays.hashCode(columnNames);
        return result;
    }
}
