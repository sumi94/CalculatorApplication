import java.util.List;

public class RepeatCommand implements Command{


    private double operand;

    public RepeatCommand(double operand) {

        this.operand = operand;
    }

    @Override
    public double calculate(Computer computer, CalculatorCache calculatorCache) {
        double result = 0;
        List<Command> commands = calculatorCache.getLastNCommands((int)operand);
        for(Command command: commands){
            result = command.calculate(computer, calculatorCache);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepeatCommand that = (RepeatCommand) o;

        return Double.compare(that.operand, operand) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(operand);
        return (int) (temp ^ (temp >>> 32));
    }
}
