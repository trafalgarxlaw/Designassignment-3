package Calculator;

import Expressions.Expression;
import Expressions.ExpressionBuilder;
import Visitors.CalculateVisitor;
import Visitors.ExpressionVisitor;
import Visitors.PrintVisitor;

public class Calculator {
    public int calculate(String input) {
        return calculate(ToExpression(input).create());
    }

    public int calculate(Expression expr) {
        CalculateVisitor visitor = new CalculateVisitor();
        visit(expr,visitor);

        return visitor.getResult();
    }

    public void visit(Expression expr, ExpressionVisitor visitor) {

        // the expression accepts visitor and will performe different types of calculation based on the type of visitor
        // passed.
        expr.accept(visitor);

    }

    private ExpressionBuilder ToExpression(String expr){

        String[] expression=expr.split(" ");
        ExpressionBuilder builder = new ExpressionBuilder(Integer.parseInt(expression[0]));

        for (int i = 1; i <expression.length ; i++) {

            if (expression[i].equals("+")){

                builder.add(Integer.parseInt(expression[i+1]));
                i++;


            }else if (expression[i].equals("-")){

                builder.subtract(Integer.parseInt(expression[i+1]));
                i++;


            }
            else if (expression[i].equals("*")){
                builder.multiply(Integer.parseInt(expression[i+1]));
                i++;


            }
            else if (expression[i].equals("/")){
                builder.divide(Integer.parseInt(expression[i+1]));
                i++;


            }

        }

        return builder;

    }
}
