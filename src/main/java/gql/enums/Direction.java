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
    };

    public String toLatex() {
        switch (this) {
            case LEFT_TO_RIGHT:
                return "\\rightarrow";
            case RIGHT_TO_LEFT:
                return "\\leftarrow";
            case UNDIRECTED:
                return "-";
            default:
                return "";
        }
    }
}
