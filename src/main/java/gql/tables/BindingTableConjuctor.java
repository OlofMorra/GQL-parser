package gql.tables;

import com.google.common.collect.HashMultiset;
import exceptions.SemanticErrorException;
import gql.expressions.values.Value;
import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class BindingTableConjuctor {
    public BindingTable unionDistinct(BindingTable left, BindingTable right) {
        BindingTable conjunction = unionAll(left, right);
        conjunction.makeDistinct();
        return conjunction;
    }

    public BindingTable unionAll(BindingTable left, BindingTable right) {
        if (!haveEqualColumnNames(left.getColumnNames(), right.getColumnNames())) throw new SemanticErrorException("It is not possible to conjunct two tables with different sets of columnnames.");

        BindingTable output = left.clone();
        output.addRecords(right.getRecords());

        return output;
    }

    public BindingTable unionMax(BindingTable left, BindingTable right) {
        if (!haveEqualColumnNames(left.getColumnNames(), right.getColumnNames())) throw new SemanticErrorException("It is not possible to conjunct two tables with different sets of columnnames.");

        BindingTable unionAll = unionAll(left, right);
        BindingTable intersectAll = intersectAll(left, right);

        return bagDifference(unionAll, intersectAll);
    }

    public BindingTable exceptDistinct(BindingTable left, BindingTable right) {
        if (!haveEqualColumnNames(left.getColumnNames(), right.getColumnNames())) throw new SemanticErrorException("It is not possible to conjunct two tables with different sets of columnnames.");

        BindingTable output = left.clone();
        output.makeDistinct();
        return bagDifference(output, right);
    }

    public BindingTable exceptAll(BindingTable left, BindingTable right) {
        if (!haveEqualColumnNames(left.getColumnNames(), right.getColumnNames())) throw new SemanticErrorException("It is not possible to conjunct two tables with different sets of columnnames.");

        return bagDifference(left, right);
    }

    public BindingTable intersectDistinct(BindingTable left, BindingTable right) {
        BindingTable conjunction = intersectAll(left, right);
        conjunction.makeDistinct();
        return conjunction;
    }

    public BindingTable intersectAll(BindingTable left, BindingTable right) {
        if (!haveEqualColumnNames(left.getColumnNames(), right.getColumnNames())) throw new SemanticErrorException("It is not possible to conjunct two tables with different sets of columnnames.");

        BindingTable conjunction = new BindingTable(false, true, left.getColumnNames());
        HashMultiset<Record> newRecords = HashMultiset.create();
        HashMultiset<Record> rightRecords = right.getRecords();

        for (Record leftRecord: left.getRecords()) {
            if (rightRecords.contains(leftRecord)) {
                newRecords.add(leftRecord);
                rightRecords.remove(leftRecord);
            }
        }

        conjunction.setRecords(newRecords);

        return conjunction;
    }

    public BindingTable otherwise(BindingTable left, BindingTable right) {
        if (left.getRecords().size() > 0) return left;

        return right;
    }

    public BindingTable crossProduct(BindingTable left, BindingTable right) {
        String[] intersectingColumnNames = getIntersectingColumnNames(left.getColumnNames(), right.getColumnNames());
        String[] distinctColumnNames = getDistinctColumnNames(left.getColumnNames(), right.getColumnNames());
        String[] resultColumnNames = (String[]) ArrayUtils.addAll(intersectingColumnNames, distinctColumnNames);
        BindingTable crossProduct = new BindingTable(false, true, resultColumnNames);

        for (Record leftRecord: left.getRecords()) {
            for (Record rightRecord: right.getRecords()) {
                if (leftRecord.intersectsWith(rightRecord, intersectingColumnNames)) {
                    crossProduct.addRecord(getIntersectedRecord(leftRecord, rightRecord, intersectingColumnNames, resultColumnNames));
                }
            }
        }

        return crossProduct;
    }

    public boolean haveEqualColumnNames(String[] leftColumnNames, String[] rightColumnNames) {
        Arrays.sort(leftColumnNames);
        Arrays.sort(rightColumnNames);

        return Arrays.equals(leftColumnNames, rightColumnNames);
    }

    private BindingTable bagDifference(BindingTable left, BindingTable right) {
        BindingTable bagDifference = new BindingTable(false, left.hasDuplicates(), left.getColumnNames());
        HashMultiset<Record> newRecords = HashMultiset.create();
        HashMultiset<Record> rightRecords = right.getRecords();

        for (Record leftRecord: left.getRecords()) {
            if (rightRecords.contains(leftRecord)) {
                rightRecords.remove(leftRecord);
            } else {
                newRecords.add(leftRecord);
            }
        }

        bagDifference.setRecords(newRecords);

        return bagDifference;
    }

    private String[] getIntersectingColumnNames(String[] left, String[] right) {
        ArrayList<String> result = new ArrayList<String>(Arrays.asList(left));
        result.retainAll(new ArrayList<String>(Arrays.asList(right)));

        return fromArrayListToStringArray(result);
    }

    private String[] getDistinctColumnNames(String[] left, String[] right) {
        ArrayList<String> leftList = new ArrayList<>(Arrays.asList(left));
        ArrayList<String> rightList = new ArrayList<>(Arrays.asList(right));

        ArrayList<String> result = (ArrayList<String>) leftList.clone();
        result.addAll(rightList);
        leftList.retainAll(rightList);
        result.removeAll(leftList);

        return fromArrayListToStringArray(result);
    }

    private Record getIntersectedRecord(Record left, Record right, String[] intersectingColumnNames, String[] resultColumnNames) {
        ArrayList<Value> values = new ArrayList<Value>();

        for (String columnName: intersectingColumnNames) {
            values.add(left.getValueFromColumn(columnName));
        }

        addNotIntersectingValues(left, intersectingColumnNames, values);
        addNotIntersectingValues(right, intersectingColumnNames, values);

        Value[] result = new Value[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }

        return new Record(resultColumnNames, result);
    }

    private void addNotIntersectingValues(Record left, String[] intersectingColumnNames, ArrayList<Value> values) {
        for (String columnName : left.getColumnNames()) {
            if (!ArrayUtils.contains(intersectingColumnNames, columnName)) {
                values.add(left.getValueFromColumn(columnName));
            }
        }
    }

    private String[] fromArrayListToStringArray(ArrayList<String> temp) {
        String[] result = new String[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }

        return result;
    }
}
