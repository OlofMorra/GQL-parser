package gql.enums;

public enum ValueComparator {
    EQ {
        @Override
        public String toString() {
            return "=";
        }
    },
    NEQ {
        @Override
        public String toString() {
            return "<>";
        }
    },
    LT {
        @Override
        public String toString() {
            return "<";
        }
    },
    GT {
        @Override
        public String toString() {
            return ">";
        }
    },
    LEQ {
        @Override
        public String toString() {
            return "<=";
        }
    },
    GEQ {
        @Override
        public String toString() {
            return ">=";
        }
    }
}
