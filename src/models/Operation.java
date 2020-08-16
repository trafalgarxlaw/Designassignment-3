package models;

import Expressions.Expression;
import Visitors.ExpressionVisitor;

public class Operation implements Expression {
    // an operation have 2 expressions/value as childs can be for example 3+(2-1)

    private ArithmeticSign.sign sign;
    private Expression firstExpression;
    private Expression secondExpression;

    public Operation(Expression firstExpression,Expression secondExpression,ArithmeticSign.sign operationSign){
        this.firstExpression=firstExpression;
        this.secondExpression=secondExpression;
        this.sign=operationSign;
    }

    public String toString(){
        if (secondExpression.isOperation()){
            return firstExpression.toString() + " " +  getSign() + " " + "("+ secondExpression.toString() +")";

        }else
            return firstExpression.toString() + " " +  getSign() + " " + secondExpression.toString();

    }

    @Override
    public int calculate(){
        int result=0;
        if (getSign().equals("+")){
            result=firstExpression.calculate()+secondExpression.calculate();
        }else if (getSign().equals("-")){
            result=firstExpression.calculate()-secondExpression.calculate();

        }
        else if (getSign().equals("*")){
            result=firstExpression.calculate()*secondExpression.calculate();

        }  else if (getSign().equals("/")){
            result=firstExpression.calculate()/secondExpression.calculate();

        }

        return result;
    }


    public Expression getFirstExpression() {
        return firstExpression;
    }

    public Expression getSecondExpression() {
        return secondExpression;
    }

    public String getSign() {
        switch (sign){
            case addition:
                return "+";

            case divition:
                return "/";

            case substraction:
                return "-";

            case multiplication:
                return "*";
        }

        return "";
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isOperation() {
        return true;
    }

    @Override
    public boolean isValue() {
        return false;
    }
}
