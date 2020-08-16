import Calculator.Calculator;
import Expressions.ExpressionBuilder;
import Visitors.CalculateVisitor;
import Visitors.PrintVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    public static void Setup() {
        calculator = new Calculator();
    }

    @Test
    public void calculateSimpleString() {
        assertEquals(5, calculator.calculate("2 + 3"));
    }

    @Test
    public void calculateLongString() {
        assertEquals(-2, calculator.calculate("2 * 4 + 3 - 15 / 2"));
    }

    // Faculatatif, pour points bonus!
    @Test
    public void calculateComplexString() {
        assertEquals(16, calculator.calculate("2 + (5 - 3) * (16 / 4)"));
    }

    @Test
    public void calculateSimpleExpression() {
        ExpressionBuilder builder = new ExpressionBuilder(2);
        builder.add(3);

        assertEquals(5, calculator.calculate(builder.create()));
    }

    @Test
    public void calculateLongExpression() {
        ExpressionBuilder builder = new ExpressionBuilder(2);
        builder.multiply(4);
        builder.add(3);
        builder.subtract(15);
        builder.divide(2);

        assertEquals(-2, calculator.calculate(builder.create()));
    }

    @Test
    public void calculateComplexExpression() {
        ExpressionBuilder subtractBuilder = new ExpressionBuilder(5);
        subtractBuilder.subtract(3);

        ExpressionBuilder divideBuilder = new ExpressionBuilder(16);
        divideBuilder.divide(4);

        ExpressionBuilder builder = new ExpressionBuilder(2);
        builder.add(subtractBuilder);
        builder.multiply(divideBuilder);

        assertEquals(16, calculator.calculate(builder.create()));
    }

    @Test
    public void visitCalculateSimple() {
        ExpressionBuilder builder = new ExpressionBuilder(2);
        builder.add(3);

        CalculateVisitor visitor = new CalculateVisitor();
        calculator.visit(builder.create(), visitor);

        assertEquals(5, visitor.getResult());
    }

    @Test
    public void visitCalculateLong() {
        ExpressionBuilder builder = new ExpressionBuilder(2);
        builder.multiply(4);
        builder.add(3);
        builder.subtract(15);
        builder.divide(2);

        CalculateVisitor visitor = new CalculateVisitor();
        calculator.visit(builder.create(), visitor);

        assertEquals(-2, visitor.getResult());
    }

    @Test
    public void visitCalculateComplex() {
        ExpressionBuilder subtractBuilder = new ExpressionBuilder(5);
        subtractBuilder.subtract(3);

        ExpressionBuilder divideBuilder = new ExpressionBuilder(16);
        divideBuilder.divide(4);

        ExpressionBuilder builder = new ExpressionBuilder(2);
        builder.add(subtractBuilder);
        builder.multiply(divideBuilder);

        CalculateVisitor visitor = new CalculateVisitor();
        calculator.visit(builder.create(), visitor);

        assertEquals(16, visitor.getResult());
    }

    @Test
    public void visitPrintSimple() {
        ExpressionBuilder builder = new ExpressionBuilder(2);
        builder.add(3);

        PrintVisitor visitor = new PrintVisitor();
        calculator.visit(builder.create(), visitor);

        assertEquals("2 + 3", visitor.toString());
    }

    @Test
    public void visitPrintLong() {
        ExpressionBuilder builder = new ExpressionBuilder(2);
        builder.multiply(4);
        builder.add(3);
        builder.subtract(15);
        builder.divide(2);

        PrintVisitor visitor = new PrintVisitor();
        calculator.visit(builder.create(), visitor);

        assertEquals("2 * 4 + 3 - 15 / 2", visitor.toString());
    }

    @Test
    public void visitPrintComplex() {
        ExpressionBuilder subtractBuilder = new ExpressionBuilder(5);
        subtractBuilder.subtract(3);

        ExpressionBuilder divideBuilder = new ExpressionBuilder(16);
        divideBuilder.divide(4);

        ExpressionBuilder builder = new ExpressionBuilder(2);
        builder.subtract(subtractBuilder);
        builder.divide(divideBuilder);

        PrintVisitor visitor = new PrintVisitor();
        calculator.visit(builder.create(), visitor);

        assertEquals("2 - (5 - 3) / (16 / 4)", visitor.toString());
    }
}