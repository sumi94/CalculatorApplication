import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CalculatorDemo {
    public static void main(String[] args) throws IOException {
        CalculatorController calculatorController = new CalculatorController(new Computer(0), new CalculatorView(new Scanner(System.in), new PrintStream(System.out)), new CommandParser());
        calculatorController.startUsingCalculator();
    }
}
