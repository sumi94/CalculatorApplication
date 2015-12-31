import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class CalculatorViewTest {
    @Test
    public void testReadingOfInput() {
        Scanner scanner = new Scanner("input");
        CalculatorView calculatorView = new CalculatorView(scanner, new PrintStream(new ByteArrayOutputStream()));
        assertEquals("input", calculatorView.takeInput());
    }

    @Test
    public void testPrintingOfTheOutput() throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(stream);
        CalculatorView calculatorView = new CalculatorView(new Scanner(""),output);
        calculatorView.printOutput("Hello");
        assertEquals("Hello\n", stream.toString());

    }
}
