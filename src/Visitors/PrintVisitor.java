package Visitors;

import Expressions.Expression;
import models.Operation;
import models.Value;

import java.util.Stack;

public class PrintVisitor implements ExpressionVisitor {

    private String stringExpression = "";

    public PrintVisitor() {
    }


    //for verifying tests output
    @Override
    public String toString() {
        return stringExpression;
    }

    @Override
    public void visit(Value v) {
        this.stringExpression = v.toString();
    }

    @Override
    public void visit(Operation operation) {
        stringExpression = operation.toString();
    }
}
