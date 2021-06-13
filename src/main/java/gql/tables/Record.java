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
