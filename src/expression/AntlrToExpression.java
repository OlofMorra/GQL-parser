package expression;

import antlr.ExprBaseVisitor;
import antlr.ExprParser.*;

import java.util.List;

public class AntlrToExpression extends ExprBaseVisitor<Expression> {

    /**
     * Given that all visit_* methods are called in a top-down fashion,
     * we can bes rue that the order in which we add declared variabeles in the `vars`
     * identical to how they are declared in the input program.
     */
    private List<String> vars; // stores all variables declared in the program so far

    @Override
    public Expression visitDeclaration(DeclarationContext ctx) {
        return super.visitDeclaration(ctx);
    }

    @Override
    public Expression visitMultiplication(MultiplicationContext ctx) {
        return super.visitMultiplication(ctx);
    }

    @Override
    public Expression visitAddition(AdditionContext ctx) {
        return super.visitAddition(ctx);
    }

    @Override
    public Expression visitVariable(VariableContext ctx) {
        return super.visitVariable(ctx);
    }

    @Override
    public Expression visitNumber(NumberContext ctx) {
        String numText = ctx.getChild(0).getText();
        int num = Integer.parseInt(numText);
        return new Number(num);
    }
}
