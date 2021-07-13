package gql.expressions.references;

import gql.expressions.Expression;
import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.Value;
import gql.graphs.GqlGraphElement;
import gql.graphs.WorkingGraph;
import gql.patterns.VariableName;
import gql.tables.Record;
import org.apache.commons.lang.ArrayUtils;

public class NameExpression extends Expression {
    private VariableName name;

    public NameExpression(String name) {
        this.name = new VariableName(name);
    }

    public GqlGraphElement getGraphElementFrom(Record record) {
        if (!ArrayUtils.contains(record.getColumnNames(), name.getId())) throw new IllegalArgumentException("Variable " + name.toString() + " is not defined in executed query.");
        Value reference = record.getValueFromColumn(name.getId());
        if (!(reference instanceof GqlIdentifier)) throw new IllegalArgumentException("Field does not contain a reference.");;
        return getReferent((GqlIdentifier) reference);
    }

    private GqlGraphElement getReferent(GqlIdentifier reference) {
        return WorkingGraph.getGraphElementById(reference);
    }

    public VariableName getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
