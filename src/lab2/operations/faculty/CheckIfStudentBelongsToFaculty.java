package lab2.operations.faculty;

import lab2.Utils;
import lab2.entities.Faculty;
import lab2.entities.University;
import lab2.operations.Operation;

public class CheckIfStudentBelongsToFaculty implements Operation {

    @Override
    public boolean matchesRequiredArgsNumber(int argNumber) {
        return argNumber == 3;
    }

    @Override
    public boolean execute(String[] args, University university) {
        String facultyAbbreviation = args[1];
        Faculty faculty = university.getFacultyByAbbreviation(facultyAbbreviation);
        if (faculty == null) {
            Utils.showErrorMessage("Couldn't find faculty with such abbreviation. Use h for help.");
            return false;
        }
        String email = args[2];
        if (!faculty.hasStudentWithEmail(email)) {
            Utils.showErrorMessage("Student with such email doesn't belong to this faculty.");
            return true;
        }
        System.out.println("Student with such email belongs to this faculty.");
        return true;
    }
}
