package lab2.operations;

import lab2.operations.faculty.*;
import lab2.operations.general.CreateFaculty;
import lab2.operations.general.DisplayFaculties;
import lab2.operations.general.SearchStudent;

import java.util.HashMap;
import java.util.Map;

public class OperationRegistry {
    private final Map<String, Operation> operationMap = new HashMap<>();


    public OperationRegistry() {
        registerOperation("nf", new CreateFaculty());
        registerOperation("df", new DisplayFaculties());
        registerOperation("ns", new CreateStudent());
        registerOperation("ds", new DisplayEnrolledStudents());
        registerOperation("gs", new GraduateStudent());
        registerOperation("dg", new DisplayGraduatedStudents());
        registerOperation("bf", new CheckIfStudentBelongsToFaculty());
        registerOperation("ss",new SearchStudent());
    }

    public void registerOperation(String name, Operation operation) {
        operationMap.put(name, operation);
    }

    public Operation getOperation(String name) {
        return operationMap.get(name);
    }

    public boolean isAValidOperation(String operationName) {
        return operationMap.containsKey(operationName);
    }
}
