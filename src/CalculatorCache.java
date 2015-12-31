import java.util.ArrayList;
import java.util.List;

public class CalculatorCache {
    ArrayList<Command> historyCommands;

    public CalculatorCache(List<Command> commands) {
        historyCommands = new ArrayList<>();
        historyCommands.addAll(commands);
    }

    public CalculatorCache() {
        historyCommands = new ArrayList<Command>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalculatorCache that = (CalculatorCache) o;

        return !(historyCommands != null ? !historyCommands.equals(that.historyCommands) : that.historyCommands != null);


    }

    @Override
    public int hashCode() {
        return historyCommands != null ? historyCommands.hashCode() : 0;
    }

    public void addToHistory(Command command) {
        historyCommands.add(command);
    }

    public List<Command> getLastNCommands(int operand) {
        return historyCommands.subList(historyCommands.size()-operand, historyCommands.size());
    }
}
