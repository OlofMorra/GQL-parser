package gql.tables;

import exceptions.SemanticErrorException;
import gql.enums.EvaluationMode;
import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.Value;
import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Record {
    String[] columnNames;
    Value[] values;

    public Record(String[] columnNames, Value[] values) {
        if (columnNames.length != values.length) {
            throw new SemanticErrorException("A record should be initialized with the same number of values as records");
        }

        this.columnNames = columnNames;
        this.values = values;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public Value[] getValues() {
        return values;
    }

    public int[] getNrOfCharactersPerValue() {
        int[] columnWidths = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            columnWidths[i] = values[i].length();
        }

        return columnWidths;
    }

    public Value getValueFromColumn(String columnName) {
        int index = -1;

        for (int i = 0; i < this.columnNames.length; i++) {
            if (this.columnNames[i].equals(columnName)) {
                index = i;
                break;
            }
        }

        if (index < 0) throw new SemanticErrorException("Column name " + columnName + " does not exist in record with column names " + Arrays.toString(this.columnNames) + ".");

        return this.values[index];
    }

    public void updateColumnNames(String[] updatedColumnNames) {
        if (this.columnNames.length != updatedColumnNames.length) {
            throw new SemanticErrorException("There are " + this.columnNames.length + " in this record, hence, updatedColumnNames should have exactly that amount of new column names.");
        }

        this.columnNames = updatedColumnNames;
    }

    public void removeColumns(ArrayList<Integer> unmappedColumnIndices) {
        for (int idx: unmappedColumnIndices) {
            columnNames = (String[]) ArrayUtils.remove(columnNames, idx);
            values = (Value[]) ArrayUtils.remove(values, idx);
        }
    }

    public boolean intersectsWith(Record right, String[] intersectingColumnNames) {
        for (String columnName: intersectingColumnNames) {
            if (!this.getValueFromColumn(columnName).equals(right.getValueFromColumn(columnName))) {
                return false;
            }
        }

        return true;
    }

    public Record patternJoin(Record right) {
        String[] newColumnNames = (String[]) ArrayUtils.addAll(this.columnNames, right.getColumnNames());
        Value[] newValues = (Value[]) ArrayUtils.addAll(this.values, right.getValues());

        return new Record(newColumnNames, newValues);
    }

    public boolean isCorrectIn(EvaluationMode evaluationMode) {
        switch(evaluationMode) {
            case TRAIL:
                return noDuplicateEdges();
            case SIMPLE:
                return onlyFirstAndLastNodeDuplicate();
            case ACYCLIC:
                return noDuplicateNodes();
            case WALK:
                break;
        }

        return true;
    }

    private boolean noDuplicateEdges() {
        HashSet<GqlIdentifier> seenIds = new HashSet<GqlIdentifier>();
        for (int i = 0; i < values.length; i ++) {
            if (isEdgeIndex(i)) {
                if (seenIds.contains((GqlIdentifier) values[i])) {
                    return false;
                }
                seenIds.add((GqlIdentifier) values[i]);
            }
        }

        return true;
    }

    private boolean noDuplicateNodes() {
        HashSet<GqlIdentifier> seenIds = new HashSet<GqlIdentifier>();
        for (int i = 0; i < values.length; i ++) {
            if (isNodeIndex(i)) {
                if (seenIds.contains((GqlIdentifier) values[i])) {
                    return false;
                }
                seenIds.add((GqlIdentifier) values[i]);
            }
        }

        return true;
    }

    private boolean onlyFirstAndLastNodeDuplicate() {
        HashSet<GqlIdentifier> seenIds = new HashSet<GqlIdentifier>();
        for (int i = 0; i < values.length - 1; i ++) {
            if (isNodeIndex(i)) {
                if (seenIds.contains((GqlIdentifier) values[i])) {
                    return false;
                }
                seenIds.add((GqlIdentifier) values[i]);
            }
        }

        if (seenIds.contains((GqlIdentifier) values[values.length - 1]) && values[0] != values[values.length - 1]) {
            return false;
        }

        return true;
    }

    private boolean isNodeIndex(int i) {
        return i % 2 == 0;
    }

    private boolean isEdgeIndex(int i) {
        return i % 2 == 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Arrays.equals(columnNames, record.columnNames) && Arrays.equals(values, record.values);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(columnNames);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }
}
