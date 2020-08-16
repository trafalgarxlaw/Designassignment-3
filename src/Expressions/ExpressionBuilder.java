package Expressions;

import models.ArithmeticSign;
import models.Operation;
import models.Value;

public class ExpressionBuilder {

    private Expression expression;

    public ExpressionBuilder(int initial) {
        this.expression= new Value(initial);
    }

    public Expression getExpression() {
        return expression;
    }

    public void add(int n) {
        ArithmeticSign.sign sign = ArithmeticSign.sign.addition;
        Value addedValue= new Value(n);

        //creating the new operation
        Operation newAddition = new Operation(expression,addedValue,sign);

        //setting it to the expression
        this.expression=newAddition;

    }
    public void add(ExpressionBuilder e) {
        ArithmeticSign.sign sign = ArithmeticSign.sign.addition;

        //creating the new operation
        Operation newAddition = new Operation(expression,e.getExpression(),sign);

        //setting it to the expression
        this.expression=newAddition;

    }

    public void subtract(int n) {
        ArithmeticSign.sign sign = ArithmeticSign.sign.substraction;
        Value substractedValue= new Value(n);

        //creating the new operation
        Operation newSubstraction = new Operation(expression,substractedValue,sign);

        //setting it to the expression
        this.expression=newSubstraction;
    }
    public void subtract(ExpressionBuilder e) {
        ArithmeticSign.sign sign = ArithmeticSign.sign.substraction;

        //creating the new operation
        Operation newSubstraction = new Operation(expression,e.getExpression(),sign);

        //setting it to the expression
        this.expression=newSubstraction;
    }

    public void multiply(int n) {
        ArithmeticSign.sign sign = ArithmeticSign.sign.multiplication;
        Value multValue= new Value(n);

        //creating the new operation
        Operation newMultiplication = new Operation(expression,multValue,sign);

        //setting it to the expression
        this.expression=newMultiplication;
    }
    public void multiply(ExpressionBuilder e) {
        ArithmeticSign.sign sign = ArithmeticSign.sign.multiplication;

        //creating the new operation
        Operation newMultiplication = new Operation(expression,e.getExpression(),sign);

        //setting it to the expression
        this.expression=newMultiplication;
    }

    public void divide(int n) {
        ArithmeticSign.sign sign = ArithmeticSign.sign.divition;
        Value divValue= new Value(n);

        //creating the new operation
        Operation newDivision = new Operation(expression,divValue,sign);

        //setting it to the expression
        this.expression=newDivision;
    }
    public void divide(ExpressionBuilder e) {
        ArithmeticSign.sign sign = ArithmeticSign.sign.divition;

        //creating the new operation
        Operation newDivision = new Operation(expression,e.getExpression(),sign);

        //setting it to the expression
        this.expression=newDivision;
    }

    public Expression create() {
        return expression;
    }
}
