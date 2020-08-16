package Visitors;

import models.Operation;
import models.Value;

public class CalculateVisitor implements ExpressionVisitor {

    private int result;
    private String stringExpression;

    public CalculateVisitor(){
        this.result=0;
    }


    public int getResult() {
        return result;
    }

    @Override
    public void visit(Value value) {
        result= value.calculate();

        this.stringExpression = value.toString();

    }

    @Override
    public void visit(Operation operation) {
        result= operation.calculate();
        stringExpression=operation.toString();
        System.out.println(stringExpression);
    }

}
