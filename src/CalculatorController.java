import java.io.IOException;

public class CalculatorController {
    private Computer computer;
    private CalculatorView calculatorView;
    private CommandParser commandParser;
    private CalculatorCache calculatorCache;

    public CalculatorController(Computer computer, CalculatorView calculatorView, CommandParser commandParser, CalculatorCache calculatorCache) {

        this.computer = computer;
        this.calculatorView = calculatorView;
        this.commandParser = commandParser;
        this.calculatorCache = calculatorCache;
    }

    public String computeCommand(String commandString) {
        Command command = commandParser.parse(commandString);
        try{
            return String.valueOf(command.calculate(computer, calculatorCache));
        }
        catch (ArithmeticException exception){
            return "Not a Number";
        }
    }

    public void startUsingCalculator() throws IOException {
        String input;
        while (!((input = calculatorView.takeInput()).equals("exit"))) {
            calculatorView.printOutput(computeCommand(input));
        }


    }


}
