public class Computer {


    private double accumulator;

    public Computer(double accumulator) {

        this.accumulator = accumulator;
    }

    public double add(double inputNumber) {
        accumulator += inputNumber;
        return accumulator;
    }


    public double subtract(double inputNumber) {
        return accumulator-=inputNumber;
    }

    public double multiply(double inputNumber) {
        accumulator *= inputNumber;
        return accumulator;
    }

    public double divide(double inputNumber) {
        if(inputNumber == 0){
            throw new ArithmeticException();
        }
        accumulator /= inputNumber;
        return accumulator;
    }

    public double cancel() {
        return accumulator=0;
    }

}
