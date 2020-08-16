package Visitors;

public interface Visitable {
    void accept(ExpressionVisitor visitor);
}
