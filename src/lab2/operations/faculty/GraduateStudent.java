package lab2.operations.faculty;

import lab2.Utils;
import lab2.entities.University;
import lab2.operations.Operation;

public class GraduateStudent implements Operation {

    @Override
    public boolean matchesRequiredArgsNumber(int argNumber) {
        return argNumber == 2;
    }

    @Override
    public boolean execute(String[] args, University university) {
        String email = args[1];
        if (university.hasStudentWithEmail(email)) {
            university.graduateStudentByEmail(email);
            System.out.println("Student graduated successfully!");
            return true;
        } else {
            Utils.showErrorMessage("Couldn't find student with such email.");
        }

        return false;
    }
}
