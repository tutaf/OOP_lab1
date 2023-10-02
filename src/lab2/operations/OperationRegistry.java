package lab2.operations;

import java.util.HashMap;
import java.util.Map;

public class OperationRegistry {
    private final Map<String, Operation> operationMap = new HashMap<>();

    public void registerOperation(String name, Operation operation) {
        operationMap.put(name, operation);
    }

    public Operation getOperation(String name) {
        return operationMap.get(name);
    }
}
