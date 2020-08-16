package Expressions;

import Visitors.Visitable;

public interface Expression extends Visitable {

    public boolean isOperation();
    public boolean isValue();
    public int calculate();

}
