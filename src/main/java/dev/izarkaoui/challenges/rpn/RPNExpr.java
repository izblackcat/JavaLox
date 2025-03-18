package dev.izarkaoui.challenges.rpn;

public abstract class RPNExpr {

    interface RPNVisitor {
        String visitBinaryExpr(Binary expr);
        String visitGroupingExpr(Grouping expr);
        String visitUnaryExpr(Unary expr);
        String visitLiteralExpr(Literal expr);
    }

    static class Binary extends RPNExpr {
        Binary(RPNExpr left, Token operator, RPNExpr right) {
            this.left = left;
            this.operator = operator;
            this.right = right;
        }

        final RPNExpr left;
        final Token operator;
        final RPNExpr right;

        @Override
        String accept(RPNVisitor visitor) {
            return visitor.visitBinaryExpr(this);
        }
    }

    static class Grouping extends RPNExpr {
        Grouping(RPNExpr expression) {
            this.expression = expression;
        }

        final RPNExpr expression;

        @Override
        String accept(RPNVisitor visitor) {
            return visitor.visitGroupingExpr(this);
        }
    }

    static class Literal extends RPNExpr {
        Literal(Object value) {
            this.value = value;
        }


        final Object value;

        @Override
        String accept(RPNVisitor visitor) {
            return visitor.visitLiteralExpr(this);
        }
    }

    static class Unary extends RPNExpr {
        Unary(Token operator, RPNExpr right) {
            this.operator = operator;
            this.right = right;
        }

        final Token operator;
        final RPNExpr right;

        @Override
        String accept(RPNVisitor visitor) {
            return visitor.visitUnaryExpr(this);
        }
    }

    abstract String accept(RPNVisitor visitor);
}
