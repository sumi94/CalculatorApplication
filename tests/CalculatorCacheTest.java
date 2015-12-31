import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculatorCacheTest {
    @Test
    public void testAddingOfCommandToCache() {
        final Command command1 = new AddCommand(1);
        final Command command2 = new SubtractCommand(1);
        List<Command> commands = new ArrayList<Command>(){{
        add(command1);
        add(command2);
        }
        };
        CalculatorCache calculatorCacheExpected = new CalculatorCache(commands);
        CalculatorCache calculatorCache = new CalculatorCache();
        calculatorCache.addToHistory(command1);
        calculatorCache.addToHistory(command2);
        assertEquals(calculatorCacheExpected, calculatorCache);
    }

    @Test
    public void testGettingLast2Commands() {


        final Command command1 = new AddCommand(1);
        final Command command2 = new SubtractCommand(1);
        List<Command> commands = new ArrayList<Command>(){{
            add(command1);
            add(command2);
        }
        };

        CalculatorCache calculatorCache = new CalculatorCache(commands);
        List<Command> expectedCommands = new ArrayList<Command>();
        expectedCommands.add(new SubtractCommand(1));
        assertEquals(expectedCommands, calculatorCache.getLastNCommands(1));

    }
}
