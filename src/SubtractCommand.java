public class SubtractCommand implements Command {
    private double operand;
    private int numOfTimesCalled;

    public SubtractCommand(double operand) {
        this.operand = operand;
    }

    @Override
    public double calculate(Computer computer, CalculatorCache calculatorCache) {
        if(numOfTimesCalled == 0)
            calculatorCache.addToHistory(this);
        numOfTimesCalled++;

        return computer.subtract(operand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubtractCommand that = (SubtractCommand) o;

        return Double.compare(that.operand, operand) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(operand);
        return (int) (temp ^ (temp >>> 32));
    }
}
