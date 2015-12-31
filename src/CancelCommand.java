public class CancelCommand implements Command{

    private int numOfTimesCalled;

    @Override
    public double calculate(Computer computer, CalculatorCache calculatorCache) {
        if(numOfTimesCalled == 0)
            calculatorCache.addToHistory(this);
        numOfTimesCalled++;

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
