package gql.expressions.references;

import gql.expressions.Expression;
import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.TruthValue;
import gql.expressions.values.Value;
import gql.graphs.GqlGraphElement;
import gql.tables.Record;

public class PropertyReference extends Expression {
    NameExpression name;
    GqlIdentifier key;

    public PropertyReference(String name, String key) {
        this.name = new NameExpression(name);
        this.key = new GqlIdentifier(key);
    }

    public Value getValueFrom(Record record) {
        GqlGraphElement referent = name.getGraphElementFrom(record);
        return getPropertyFrom(referent);
    }

    private Value getPropertyFrom(GqlGraphElement referent) {
        if (referent == null) return new TruthValue(null);
        if (referent.getProperties().containsKey(key)) return referent.getProperties().get(key);
        if (key.equals(new GqlIdentifier("id"))) return referent.getId();
        return new TruthValue(null);
    }

    @Override
    public String toString() {
        return name.toString() + "." + key.toString();
    }
}
