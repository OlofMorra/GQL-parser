package gql.tables;

import gql.expressions.values.Value;
import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class BindingTableConjuctor {
    public BindingTable unionDistinct(BindingTable left, BindingTable right) {

        return new BindingTable(false, false, new String[]{});
    }

    public BindingTable unionAll(BindingTable left, BindingTable right) {

        return new BindingTable(false, false, new String[]{});
    }

    public BindingTable unionMax(BindingTable left, BindingTable right) {

        return new BindingTable(false, false, new String[]{});
    }

    public BindingTable exceptDistinct(BindingTable left, BindingTable right) {

        return new BindingTable(false, false, new String[]{});
    }

    public BindingTable exceptAll(BindingTable left, BindingTable right) {

        return new BindingTable(false, false, new String[]{});
    }

    public BindingTable intersectDistinct(BindingTable left, BindingTable right) {

        return new BindingTable(false, false, new String[]{});
    }

    public BindingTable intersectAll(BindingTable left, BindingTable right) {

        return new BindingTable(false, false, new String[]{});
    }

    public BindingTable otherwise(BindingTable left, BindingTable right) {

        return new BindingTable(false, false, new String[]{});
    }

    public BindingTable crossProduct(BindingTable left, BindingTable right) {
        String[] intersectingColumnNames = getIntersectingColumnNames(left.getColumnNames(), right.getColumnNames());
        String[] distinctColumnNames = getDistinctColumnNames(left.getColumnNames(), right.getColumnNames());
        String[] resultColumnNames = (String[]) ArrayUtils.addAll(intersectingColumnNames, distinctColumnNames);
        BindingTable crossProduct = new BindingTable(false, false, resultColumnNames);

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
