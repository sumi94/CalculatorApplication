import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;

public class ParserTest {
    @Test
    public void parseAdd5ToReturnAddCommand() {
        CommandParser parser = new CommandParser();
        assertEquals(new AddCommand(5), parser.parse("plus 5"));
    }

    @Test
    public void parseSubtract5ToReturnSubtractCommand() {
        CommandParser parser = new CommandParser();
        assertEquals(new SubtractCommand(5), parser.parse("subtract 5"));
    }

    @Test
    public void parseMultiply5ToReturnMultiplyCommand() {
        CommandParser parser = new CommandParser();
        assertEquals(new MultiplyCommand(5), parser.parse("multiply 5"));
    }

    @Test
    public void parseDivide5ToReturnDivideCommand() {
        CommandParser parser = new CommandParser();
        assertEquals(new DivideCommand(5), parser.parse("divide 5"));
    }

    @Test
    public void parseExitCommand() {
        CommandParser parser = new CommandParser();
        assertNull(parser.parse("exit"));
    }

    @Test
    public void parseCancelCommand() {
        CommandParser parser = new CommandParser();
        assertEquals(new CancelCommand(),parser.parse("cancel"));

    }
}
