import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.assertEquals;

public class ComputerTest {

    @Test
    public void shouldAdd5ToTheAccumulator() {
        Computer computer = new Computer(0);
        assertEquals(5.0, computer.add(5),0.2);
    }

    @Test
    public void shouldSubtract2ToTheAccumulator() {
        Computer computer = new Computer(0);
        assertEquals(-2.0, computer.subtract(2d), 0.2);

    }
    @Test
    public void shouldMultiplyBy2ToReturnTheAccumulatorAs0() {
        Computer computer = new Computer(0);
        assertEquals(0.0, computer.multiply(2d), 0.2);
    }
    @Test
    public void shouldDivideBy2ToReturnTheAccumulatorAs1AfterAdding2() {
        Computer computer = new Computer(2);
        assertEquals(1.0, computer.divide(2d), 0.2);
    }

    @Test
    public void shouldResetAllToZeroWhenWeInvokeCancel() {
        Computer computer = new Computer(0);
        assertEquals(0.0, computer.cancel(), 0.2);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowArithmeticExceptionWhenDividedByZero() {
        expectedException.expect(ArithmeticException.class);
        Computer computer = new Computer(4);
        computer.divide(0);
    }
}
