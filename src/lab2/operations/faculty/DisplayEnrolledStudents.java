package lab2.operations.faculty;

import lab2.entities.University;
import lab2.entities.Student;
import lab2.operations.Operation;

import java.util.List;

public class DisplayEnrolledStudents implements Operation {

    @Override
    public void execute(String[] args, University university) {
        String facultyAbbreviation = args[1];
        List<Student> enrolledStudentList = university.getFacultyByAbbreviation(facultyAbbreviation).getEnrolledStudents();

        for(Student student : enrolledStudentList) {
            System.out.println(student.toString());
        }
    }
}
