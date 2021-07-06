package gql.enums;

public enum ValueComparator {
    EQ {
        public String toString() {
            return "=";
        }
    },
    NEQ {
        public String toString() {
            return "<>";
        }
    },
    LT {
        public String toString() {
            return "<";
        }
    },
    GT {
        public String toString() {
            return ">";
        }
    },
    LEQ {
        public String toString() {
            return "<=";
        }
    },
    GEQ {
        public String toString() {
            return ">=";
        }
    }
}
