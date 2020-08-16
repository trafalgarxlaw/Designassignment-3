package models;

import Expressions.Expression;
import Visitors.ExpressionVisitor;

public class Value implements Expression {
    private int value;

    public Value(int value){
        this.value=value;
    }
    public String toString(){
        return String.valueOf(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isOperation() {
        return false;
    }

    @Override
    public boolean isValue() {
        return true;
    }

    @Override
    public int calculate() {
        return value;
    }
}
