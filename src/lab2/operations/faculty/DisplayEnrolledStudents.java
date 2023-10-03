package lab2.operations.faculty;

import lab2.Utils;
import lab2.entities.Faculty;
import lab2.entities.University;
import lab2.entities.Student;
import lab2.operations.Operation;

import java.util.List;

public class DisplayEnrolledStudents implements Operation {


    @Override
    public boolean matchesRequiredArgsNumber(int argNumber) {
        return argNumber == 2;
    }

    @Override
    public boolean execute(String[] args, University university) {
        String facultyAbbreviation = args[1];
        Faculty faculty = university.getFacultyByAbbreviation(facultyAbbreviation);
        if (faculty == null) {
            Utils.showErrorMessage("Couldn't find faculty with such abbreviation. Use h for help.");
            return false;
        }
        List<Student> enrolledStudentList = university.getFacultyByAbbreviation(facultyAbbreviation).getEnrolledStudents();

        for(Student student : enrolledStudentList) {
            System.out.println(student.toString());
        }

        return true;
    }
}
