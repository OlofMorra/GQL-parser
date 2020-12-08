package expression;

import antlr.ExprBaseVisitor;
import antlr.ExprParser.ProgramContext;

public class AntlrToProgram extends ExprBaseVisitor<Program> {
    @Override
    public Program visitProgram(ProgramContext ctx) {
        return super.visitProgram(ctx);
    }
}
