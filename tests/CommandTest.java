import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CommandTest {
    @Test
    public void testIfAddCommandIsAddedToCache() {
        Computer computer = Mockito.mock(Computer.class);

        CalculatorCache calculatorCache = new CalculatorCache();
        final AddCommand addCommand = new AddCommand(5);
        addCommand.calculate(computer, calculatorCache);

        CalculatorCache expectedCalculatorCache = new CalculatorCache(new ArrayList<Command>(){{
            add(addCommand);
        }
        });

        assertEquals(expectedCalculatorCache, calculatorCache);
    }

    @Test
    public void testIfAddCommandIsNotAddedToCacheWhenRepeated() {
        Computer computer = Mockito.mock(Computer.class);

        CalculatorCache calculatorCache = new CalculatorCache();
        final AddCommand addCommand = new AddCommand(5);
        addCommand.calculate(computer, calculatorCache);
        addCommand.calculate(computer, calculatorCache);

        CalculatorCache expectedCalculatorCache = new CalculatorCache(new ArrayList<Command>(){{
            add(addCommand);
        }
        });

        assertEquals(expectedCalculatorCache, calculatorCache);
    }
}