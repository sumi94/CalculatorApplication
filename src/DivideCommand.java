public class DivideCommand implements Command {
    private double operand;

    public DivideCommand(double operand) {
        this.operand = operand;
    }

    @Override
    public double calculate(Computer computer) {

        return computer.divide(operand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DivideCommand that = (DivideCommand) o;

        return Double.compare(that.operand, operand) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(operand);
        return (int) (temp ^ (temp >>> 32));
    }
}
