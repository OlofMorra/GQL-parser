package gql.enums;

public enum Direction {
    LEFT_TO_RIGHT {
        @Override
        public String toString() {
            return "->";
        }
    },
    RIGHT_TO_LEFT {
        @Override
        public String toString() {
            return "<-";
        }
    },
    UNDIRECTED {
        @Override
        public String toString() {
            return "-";
        }
    }
}
