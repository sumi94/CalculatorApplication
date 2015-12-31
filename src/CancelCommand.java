public class CancelCommand implements Command{

    @Override
    public double calculate(Computer computer) {

        return computer.cancel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
