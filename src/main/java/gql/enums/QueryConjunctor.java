package gql.enums;

public enum QueryConjunctor {
    UNION_ALL {
        @Override
        public String toString() {
            return "UNION ALL";
        }
    },
    UNION_DISTINCT {
        @Override
        public String toString() {
            return "UNION DISTINCT";
        }
    },
    UNION_MAX {
        @Override
        public String toString() {
            return "UNION MAX";
        }
    },
    INTERSECT_ALL {
        @Override
        public String toString() {
            return "INTERSECT ALL";
        }
    },
    INTERSECT_DISTINCT {
        @Override
        public String toString() {
            return "INTERSECT DISTINCT";
        }
    },
    EXCEPT_ALL {
        @Override
        public String toString() {
            return "EXCEPT ALL";
        }
    },
    EXCEPT_DISTINCT {
        @Override
        public String toString() {
            return "EXCEPT DISTINCT";
        }
    },
    OTHERWISE
}
