import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CalculatorView {
    private Scanner scanner;
    private PrintStream outputStream;

    public CalculatorView(Scanner scanner, PrintStream outputStream) {

        this.scanner = scanner;
        this.outputStream = outputStream;
    }

    public String takeInput() {
        return scanner.nextLine();
    }

    public void printOutput(String output) throws IOException {
        output=output+"\n";
        outputStream.write(output.getBytes());

    }
}
