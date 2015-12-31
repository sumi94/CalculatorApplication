import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommandParser {
    public static final HashMap<List<String>, String> operationsToCommandMap = new HashMap<List<String>, String>(){{
        put(Arrays.asList("add", "plus","+"), "add");
        put(Arrays.asList("subtract","-","minus"), "subtract");
        put(Arrays.asList("multiply","*"), "multiply");
        put(Arrays.asList("divide","/"), "divide");

    }};
    public Command parse(String command) {
        String []expression={""}; String operation=""; double operand=0;
        if(command.equals("cancel")){
            return new CancelCommand();
        }
        if (command.contains(" ")) {
            expression = command.split(" ");
            operation=expression[0];
            for(List<String> options: operationsToCommandMap.keySet()){
                if(options.contains(operation)){
                    operation = operationsToCommandMap.get(options);
                }
            }
            operand = Double.parseDouble(expression[1]);
        }

        if(operation.equals("add")){
            return new AddCommand(operand);
        }else if(operation.equals("subtract")){
            return new SubtractCommand(operand);
        }else if(operation.equals("multiply")){
            return new MultiplyCommand(operand);
        }else if(operation.equals("divide")){
            return new DivideCommand(operand);
        }
        return null;
    }
}
