package gql.tables;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class BindingTable {
    boolean isOrdered;
    boolean hasDuplicates;
    String[] columnNames;
    List<Record> records = new ArrayList<Record>();


    public BindingTable(boolean isOrdered, boolean hasDuplicates, String[] columnNames) {
        this.isOrdered = isOrdered;
        this.hasDuplicates = hasDuplicates;
        this.columnNames = columnNames;
    }

    public void addRecord(Record record) {
        if (record.values.length != columnNames.length) {
            throw new IllegalArgumentException("Record does not have the same amount of values as there are column names.");
        }

        records.add(record);
    }

    public void addRecordMultipleTimes(Record record, int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            addRecord(record);
        }
    }

    public void addRecords(Record[] records) {
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
}
