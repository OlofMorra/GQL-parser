package gql.expressions;

import java.text.Normalizer;
import java.util.Objects;

public class GqlId {
    private String id;

    public GqlId(String id) {
        this.id = Normalizer.normalize(id, Normalizer.Form.NFKC);
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GqlId gqlId = (GqlId) o;
        return id.equals(gqlId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
