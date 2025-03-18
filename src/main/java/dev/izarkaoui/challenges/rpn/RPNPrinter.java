package dev.izarkaoui.challenges.rpn;


public class RPNPrinter implements RPNExpr.RPNVisitor {


    public static void main(String[] args) {
        RPNExpr firstExpr = new RPNExpr.Binary(
                new RPNExpr.Literal(1),
                new Token(TokenType.PLUS, "+", null, 1),
                new RPNExpr.Literal(2)
        );
        System.out.println("(1 + 2) becomes : " + new RPNPrinter().print(firstExpr));

        RPNExpr secondExpr = new RPNExpr.Binary(
                new RPNExpr.Binary(
                        new RPNExpr.Literal(1),
                        new Token(TokenType.PLUS, "+", null, 1),
                        new RPNExpr.Literal(2)
                ),
                new Token(TokenType.STAR, "*", null, 1),
                new RPNExpr.Binary(
                        new RPNExpr.Literal(4),
                        new Token(TokenType.MINUS, "-", null, 1),
                        new RPNExpr.Literal(3)
                )
        );
        System.out.println("(1 + 2) * (4 - 3) becomes : " + new RPNPrinter().print(secondExpr));
    }

    String print(RPNExpr expr) {
        return expr.accept(this);
    }

    String parenthesizeRPN(String name, RPNExpr... exprs) {
        StringBuilder builder = new StringBuilder();

        for(RPNExpr expr : exprs) {
            builder.append(expr.accept(this));
            builder.append(" ");
        }
        builder.append(name);

        return builder.toString();
    }


    @Override
    public String visitBinaryExpr(RPNExpr.Binary expr) {
        return parenthesizeRPN(expr.operator.lexeme, expr.left, expr.right);
    }

    @Override
    public String visitGroupingExpr(RPNExpr.Grouping expr) {
        return parenthesizeRPN("group", expr.expression);
    }

    @Override
    public String visitUnaryExpr(RPNExpr.Unary expr) {
        return parenthesizeRPN(expr.operator.lexeme, expr.right);
    }

    @Override
    public String visitLiteralExpr(RPNExpr.Literal expr) {
        if (expr.value == null) return "nil";
        return expr.value.toString();
    }
}
