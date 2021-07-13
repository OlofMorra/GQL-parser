package gql.enums;

public enum BooleanComparator {
    OR,
    XOR,
    AND,
    IS,
    IS_NOT {
        @Override
        public String toString() {
            return "IS NOT";
        }
    }
}
