package com.dubiner;

import junit.framework.JUnit4TestAdapter;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Basic test class using @Test, @Before and @Ignore annotation
 * as welll as assert keyword and assertEqual methods
 */
public class CalculatorTest {

    private static Calculator calculator = new Calculator();

    // Used for backward compatibility (IDEs, Ant and JUnit 3 text runner)
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(CalculatorTest.class);
    }

    @Before
    // must be public not protected like the setup
    public void clearCalculator() {
        System.out.println( "Clearing the calculator in @Before");
        calculator.clear();
    }

    //==================================
    //=            Test cases          =
    //==================================
    @Test
    public void add() {
        calculator.add(1);
        calculator.add(1);
        assertEquals(calculator.getResult(), 2);
    }

    @Test
    public void subtract() {
        calculator.add(10);
        calculator.substract(2);
        assertEquals(calculator.getResult(), 8);
    }

    @Test
    public void divide() {
        calculator.add(8);
        calculator.divide(2);
        assert calculator.getResult() == 4;
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        calculator.divide(0);
    }

    // @Ignore has a String parameter which displays a message
    @Test
    @Ignore("not ready yet")
    public void multiply() {
        calculator.add(10);
        calculator.multiply(10);
        assertEquals(calculator.getResult(), 100);
    }
}
