package gql.enums;

public enum EvaluationMode {
    WALK,
    TRAIL,
    ACYCLIC,
    SIMPLE;

    public String toLatex() {
        switch(this) {
            case WALK:
                return "\\rel{W}";
            case TRAIL:
                return "\\rel{T}";
            case ACYCLIC:
                return "\\rel{A}";
            case SIMPLE:
                return "\\rel{S}";
        }

        return "";
    }
}
