import java.util.ArrayList;
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
            CancelCommand cancelCommand = new CancelCommand();
            return cancelCommand;
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
            AddCommand addCommand = new AddCommand(operand);
            return addCommand;
        }else if(operation.equals("subtract")){
            SubtractCommand subtractCommand = new SubtractCommand(operand);
            return subtractCommand;
        }else if(operation.equals("multiply")){
            MultiplyCommand multiplyCommand = new MultiplyCommand(operand);
            return multiplyCommand;
        }else if(operation.equals("divide")){
            DivideCommand divideCommand = new DivideCommand(operand);
            return divideCommand;
        }
        else if(operation.equals("repeat")){
            return new RepeatCommand(operand);
        }
        return null;
    }
}
