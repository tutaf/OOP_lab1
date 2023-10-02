package lab2.operations;

import lab2.operations.general.CreateFaculty;
import lab2.operations.general.DisplayFaculties;

import java.util.HashMap;
import java.util.Map;

public class OperationRegistry {
    private final Map<String, Operation> operationMap = new HashMap<>();


    public OperationRegistry() {
        operationMap.put("nf", new CreateFaculty());
        operationMap.put("df", new DisplayFaculties());
    }

//    public void registerOperation(String name, Operation operation) {
//        operationMap.put(name, operation);
//    }

    public Operation getOperation(String name) {
        return operationMap.get(name);
    }
}
