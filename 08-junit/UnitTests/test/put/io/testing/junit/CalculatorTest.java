package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = null;
    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }
    @Test
    public void testAdd(){
        assertEquals(calculator.add(5,6),11);
        assertEquals(calculator.add(1,-1),0);
        assertEquals(calculator.add(-1,-4),-5);

    }

    @Test
    public void testMultiply(){
        assertEquals(calculator.multiply(5,6),30);
        assertEquals(calculator.multiply(1,-1),-1);
        assertEquals(calculator.multiply(-1,-4),4);

    }

    @Test
    public void testAddPositiveNumbers(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            calculator.addPositiveNumbers(-1,1);
        });
    }
}