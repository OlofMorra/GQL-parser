package gql.returns;

import gql.enums.SetQuantifier;

import java.util.List;

public class ReturnStatement {
    SetQuantifier setQuantifier;
    List<ReturnItem> returnItemList;

    public ReturnStatement(SetQuantifier setQuantifier,
                           List<ReturnItem> returnItemList) {
        this.setQuantifier = setQuantifier;
        this.returnItemList = returnItemList;
    }

    @Override
    public String toString() {
        return " RETURN " + setQuantifier.toString() + returnItemList.toString();
    }
}
