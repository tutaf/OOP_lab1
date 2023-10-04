package lab2.operations.faculty;

import lab2.Utils;
import lab2.entities.Faculty;
import lab2.entities.University;
import lab2.operations.Operation;

import java.time.LocalDate;

public class CreateStudent implements Operation {

    @Override
    public boolean matchesRequiredArgsNumber(int argNumber) {
        return argNumber == 8;
    }



    @Override
    public boolean execute(String[] args, University university) {
        String facultyAbbreviation = args[1];
        String firstName = args[2];
        String lastName = args[3];
        String email = args[4];

        LocalDate dateOfBirth;
        LocalDate enrollmentDate;
        try {
            int day = Integer.parseInt(args[5]);
            int month = Integer.parseInt(args[6]);
            int year = Integer.parseInt(args[7]);

            dateOfBirth = LocalDate.of(year, month, day);
            enrollmentDate = LocalDate.now();
        } catch (Exception e) {
            Utils.showErrorMessage("Invalid date format. Use dd/mm/yyyy.");
            return false;
        }

        Faculty faculty = university.getFacultyByAbbreviation(facultyAbbreviation);
        if (faculty == null) {
            Utils.showErrorMessage("Couldn't find faculty with such abbreviation. Use h for help.");
            return false;
        }

        faculty.addStudent(firstName, lastName, email, enrollmentDate, dateOfBirth);

        System.out.println("Student created successfully!");
        return true;
    }
}
