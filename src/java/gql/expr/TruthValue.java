package src.java.gql.expr;

import gql.enums.TruthValueEnum;

public class TruthValue extends Value {
    TruthValueEnum truthValue;

    public TruthValue(Boolean truthValue) {
        if (truthValue == true) {
            this.truthValue = TruthValueEnum.TRUE;
        } else if (truthValue == false) {
            this.truthValue = TruthValueEnum.FALSE;
        } else if (truthValue == null) {
            this.truthValue = TruthValueEnum.NULL;
        }
    }

    @Override
    public String toString() {
        return truthValue.name();
    }
}
