package lab2.operations.faculty;

import lab2.entities.University;
import lab2.operations.Operation;

import java.time.LocalDate;

public class CreateStudent implements Operation {
    @Override
    public void execute(String[] args, University university) {
        String facultyAbbreviation = args[1];
        String firstName = args[2];
        String lastName = args[3];
        String email = args[4];
        int day = Integer.parseInt(args[5]);
        int month = Integer.parseInt(args[6]);
        int year = Integer.parseInt(args[7]);

        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        LocalDate enrollmentDate = LocalDate.now();

        university.getFacultyByAbbreviation(facultyAbbreviation).addStudent(firstName, lastName, email, enrollmentDate, dateOfBirth);

        System.out.println("Student created successfully!");
    }
}
