import java.io.IOException;

public class CalculatorController {
    private Computer computer;
    private CalculatorView calculatorView;
    private CommandParser commandParser;

    public CalculatorController(Computer computer, CalculatorView calculatorView, CommandParser commandParser) {

        this.computer = computer;
        this.calculatorView = calculatorView;
        this.commandParser = commandParser;
    }

    public double computeCommand(String commandString) {
        Command command = commandParser.parse(commandString);
        return command.calculate(computer);
    }

    public void startUsingCalculator() throws IOException {
        String input;
        while (!((input = calculatorView.takeInput()).equals("exit"))) {
            calculatorView.printOutput(String.valueOf(computeCommand(input)));
        }


    }


}
