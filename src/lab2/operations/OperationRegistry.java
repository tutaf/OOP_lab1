package lab2.operations;

import lab2.operations.faculty.CreateStudent;
import lab2.operations.faculty.DisplayEnrolledStudents;
import lab2.operations.general.CreateFaculty;
import lab2.operations.general.DisplayFaculties;

import java.util.HashMap;
import java.util.Map;

public class OperationRegistry {
    private final Map<String, Operation> operationMap = new HashMap<>();


    public OperationRegistry() {
        registerOperation("nf", new CreateFaculty());
        registerOperation("df", new DisplayFaculties());
        registerOperation("ns", new CreateStudent());
        registerOperation("ds", new DisplayEnrolledStudents());
    }

    public void registerOperation(String name, Operation operation) {
        operationMap.put(name, operation);
    }

    public Operation getOperation(String name) {
        return operationMap.get(name);
    }
}
