package gql.tables;

import gql.expressions.Value;

import java.util.Arrays;

public class Record {
    String[] columnNames;
    Value[] values;

    public Record(String[] columnNames, Value[] values) {
        if (columnNames.length != values.length) {
            throw new IllegalArgumentException("A record should be initialized with the same number of values as records");
        }

        this.columnNames = columnNames;
        this.values = values;
    }

    public int[] getNrOfCharactersPerValue() {
        int[] columnWidths = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            columnWidths[i] = values[i].length();
        }

        return columnWidths;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Record)) {
            return false;
        }

        Record recordToCompareTo = (Record) obj;

        if(isOfUnequalWidth(recordToCompareTo)) {
            return false;
        }

        return hasEqualColumns(recordToCompareTo) && hasEqualValues(recordToCompareTo);
    }

    private boolean isOfUnequalWidth(Record recordToCompareTo) {
        return columnNames.length != recordToCompareTo.columnNames.length || values.length != recordToCompareTo.values.length;
    }

    private boolean hasEqualColumns(Record recordToCompareTo) {
        return Arrays.equals(columnNames, recordToCompareTo.columnNames);
    }

    private boolean hasEqualValues(Record recordToCompareTo) {
        return Arrays.equals(values, recordToCompareTo.values);
    }
}
