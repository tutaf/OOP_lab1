package lab2.operations.general;

import lab2.Utils;
import lab2.entities.Faculty;
import lab2.entities.University;
import lab2.operations.Operation;

public class SearchStudent implements Operation {

    @Override
    public boolean matchesRequiredArgsNumber(int argNumber) {
        return argNumber == 2;
    }

    @Override
    public boolean execute(String[] args, University university) {
        String email = args[1];
        if (university.hasStudentWithEmail(email)) {
            for (Faculty faculty : university.getFacultyList()) {
                if (faculty.hasStudentWithEmail(email)) {
                    System.out.println("This student belongs to " + faculty.getAbbreviation());
                    return true;
                }
            }
        } else {
            Utils.showErrorMessage("There's no student with such email in this university.");
        }

        return false;
    }
}
