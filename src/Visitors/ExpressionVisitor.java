package Visitors;

import models.Operation;
import models.Value;

public interface ExpressionVisitor {
    public void visit(Value value);
    public void visit(Operation operation);

}
