import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CalculatorControllerTest {

    @Test
    public void testIfParseMethodOfParserIsInvoked() {
        Computer computer = mock(Computer.class);
        CommandParser commandParser = mock(CommandParser.class);
        when(commandParser.parse("add 5")).thenReturn(new AddCommand(5));

        CalculatorController calculatorController = new CalculatorController(computer, new CalculatorView(new Scanner(""), new PrintStream(new ByteArrayOutputStream())), commandParser, new CalculatorCache());
        calculatorController.computeCommand("add 5");
        verify(commandParser).parse("add 5");
    }

    @Test
    public void takeTheInputAndParseItToAdd() {
        Computer computer = mock(Computer.class);
        CommandParser commandParser = mock(CommandParser.class);
        when(commandParser.parse("add 5")).thenReturn(new AddCommand(5));

        CalculatorController calculatorController = new CalculatorController(computer, new CalculatorView(new Scanner(""), new PrintStream(new ByteArrayOutputStream())), commandParser, new CalculatorCache());
        calculatorController.computeCommand("add 5");

        verify(computer).add(5.0);
    }

    @Test
    public void takeTheInputAndParseItToSubtract() {
        Computer computer = mock(Computer.class);
        CommandParser commandParser = mock(CommandParser.class);
        when(commandParser.parse("subtract 5")).thenReturn(new SubtractCommand(5));

        CalculatorController calculatorController = new CalculatorController(computer, new CalculatorView(new Scanner(""), new PrintStream(new ByteArrayOutputStream())), commandParser, new CalculatorCache());
        calculatorController.computeCommand("subtract 5");

        verify(computer).subtract(5.0);
    }

    @Test
    public void takeTheInputAndParseItToMultiply() {
        Computer computer = mock(Computer.class);
        CommandParser commandParser = mock(CommandParser.class);
        when(commandParser.parse("multiply 5")).thenReturn(new MultiplyCommand(5));

        CalculatorController calculatorController = new CalculatorController(computer, new CalculatorView(new Scanner(""), new PrintStream(new ByteArrayOutputStream())), commandParser, new CalculatorCache());
        calculatorController.computeCommand("multiply 5");

        verify(computer).multiply(5.0);
    }

    @Test
    public void takeTheInputAndParseItToDivide() {
        Computer computer = mock(Computer.class);
        CommandParser commandParser = mock(CommandParser.class);
        when(commandParser.parse("divide 5")).thenReturn(new DivideCommand(5));

        CalculatorController calculatorController = new CalculatorController(computer, new CalculatorView(new Scanner(""), new PrintStream(new ByteArrayOutputStream())), commandParser, new CalculatorCache());
        calculatorController.computeCommand("divide 5");

        verify(computer).divide(5.0);
    }

    @Test
    public void shouldPrintNotANumberWhenDividedByZero() throws IOException {
        CalculatorView calculatorView = mock(CalculatorView.class);
        Computer computer = mock(Computer.class);
        CommandParser commandParser = mock(CommandParser.class);
        when(commandParser.parse("divide 0")).thenReturn(new DivideCommand(0));
        when(commandParser.parse("exit")).thenReturn(null);


        CalculatorController calculatorController = new CalculatorController(computer, calculatorView, commandParser, new CalculatorCache());
        when(calculatorView.takeInput()).thenReturn("divide 0").thenReturn("exit");
        when(computer.divide(0)).thenThrow(new ArithmeticException());


        calculatorController.startUsingCalculator();
        verify(calculatorView).printOutput("Not a Number");
    }

    @Test
    public void takeTheInputAndParseItToCancel() {
        Computer computer = mock(Computer.class);
        CommandParser commandParser = mock(CommandParser.class);
        when(commandParser.parse("cancel")).thenReturn(new CancelCommand());

        CalculatorController calculatorController = new CalculatorController(computer, new CalculatorView(new Scanner(""), new PrintStream(new ByteArrayOutputStream())), commandParser, new CalculatorCache());
        calculatorController.computeCommand("cancel");

        verify(computer).cancel();
    }

    @Test
    public void shouldCallDivideOfComputerThroughTheStartUsingCalculatorMethod() throws IOException {
        Computer computer = mock(Computer.class);
        CalculatorView calculatorView = mock(CalculatorView.class);
        CommandParser commandParser = mock(CommandParser.class);
        when(commandParser.parse("divide 5")).thenReturn(new DivideCommand(5));
        when(commandParser.parse("exit")).thenReturn(null);


        CalculatorController calculatorController = new CalculatorController(computer, calculatorView, commandParser, new CalculatorCache());
        when(calculatorView.takeInput()).thenReturn("divide 5").thenReturn("exit");


        calculatorController.startUsingCalculator();
        verify(computer).divide(5.0);
    }

    @Test
    public void shouldNotCallAnyOfTheComputerMethodsIfExitCommandIsEntered() throws IOException {
        Computer computer = mock(Computer.class);
        CalculatorView calculatorView = mock(CalculatorView.class);
        CommandParser commandParser = mock(CommandParser.class);
        //when(commandParser.parse("exit")).thenReturn(new String[]{"exit"});


        CalculatorController calculatorController = new CalculatorController(computer, calculatorView, commandParser, new CalculatorCache());
        when(calculatorView.takeInput()).thenReturn("exit");


        calculatorController.startUsingCalculator();
        verify(computer, times(0)).divide(5);
        verify(computer, times(0)).multiply(5);
        verify(computer, times(0)).add(5);
        verify(computer, times(0)).subtract(5);
        verify(computer, times(0)).cancel();
    }


    @Test
    public void shouldCallInputMethodOfCalculatorView() throws IOException {
        CalculatorView calculatorView = mock(CalculatorView.class);
        CommandParser commandParser = mock(CommandParser.class);
        //when(commandParser.parse("exit")).thenReturn(new String[]{"exit"});

        CalculatorController calculatorController = new CalculatorController(new Computer(0), calculatorView, commandParser, new CalculatorCache());
        when(calculatorView.takeInput()).thenReturn("exit");
        calculatorController.startUsingCalculator();
        verify(calculatorView).takeInput();
    }

    @Test
    public void shouldCallThePrintOutputMethodForDisplayingOutput() throws IOException {
        CalculatorView calculatorView = mock(CalculatorView.class);
        Computer computer = mock(Computer.class);
        CommandParser commandParser = mock(CommandParser.class);
        when(commandParser.parse("add 5")).thenReturn(new AddCommand(5));
        when(commandParser.parse("exit")).thenReturn(null);


        CalculatorController calculatorController = new CalculatorController(computer, calculatorView, commandParser, new CalculatorCache());
        when(calculatorView.takeInput()).thenReturn("add 5").thenReturn("exit");
        when(computer.add(5)).thenReturn(5d);


        calculatorController.startUsingCalculator();
        verify(calculatorView).printOutput("5.0");
    }

    @Test
    public void shouldRepeatAdd5andAdd2WhenRepeat2IsCalled() throws IOException {

        CalculatorView calculatorView = mock(CalculatorView.class);
        Computer computer = mock(Computer.class);
        CommandParser commandParser = mock(CommandParser.class);
        CalculatorCache calculatorCache = mock(CalculatorCache.class);
        when(commandParser.parse("add 5")).thenReturn(new AddCommand(5));
        when(commandParser.parse("add 2")).thenReturn(new AddCommand(2));
        when(calculatorCache.getLastNCommands(2)).thenReturn(new ArrayList<Command>(){{
            add(new AddCommand(5));
            add(new AddCommand(2));
        }
        });

        List<Command> historyCommands = new ArrayList<>();
        historyCommands.add(new AddCommand(5));
        historyCommands.add(new AddCommand(2));


        when(commandParser.parse("repeat 2")).thenReturn(new RepeatCommand(2));
        when(commandParser.parse("exit")).thenReturn(null);


        CalculatorController calculatorController = new CalculatorController(computer, calculatorView, commandParser, calculatorCache);
        when(calculatorView.takeInput()).thenReturn("add 5").thenReturn("add 2").thenReturn("repeat 2").thenReturn("exit");
        when(computer.add(5)).thenReturn(5d).thenReturn(12d);
        when(computer.add(2)).thenReturn(7d).thenReturn(14d);

        calculatorController.startUsingCalculator();
        verify(calculatorView).printOutput("14.0");

    }

}

