package gql.tables;

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

    public boolean haveEqualColumnNames(String[] leftColumnNames, String[] rightColumnNames) {

        return true;
    }
}
