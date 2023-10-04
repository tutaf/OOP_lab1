package lab2.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Faculty implements Serializable {

    private String name;
    private String abbreviation;
    private List<Student> enrolledStudents;
    private List<Student> graduatedStudents;
    private StudyField studyField;

    public Faculty(String name, String abbreviation, StudyField studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.enrolledStudents = new ArrayList<>();
        this.graduatedStudents = new ArrayList<>();
        this.studyField = studyField;
    }


    public void addStudent(Student student) {
        this.enrolledStudents.add(student);
    }

    public StudyField getStudyField() {
        return studyField;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void addStudent(String name, String lastName, String email, LocalDate enrollmentDate, LocalDate dateOfBirth) {
        Student student = new Student(name, lastName, email, enrollmentDate, dateOfBirth);
        this.enrolledStudents.add(student);
    }


    public List<Student> getEnrolledStudents () {
        return enrolledStudents;
    }

    public List<Student> getGraduatedStudents () {
        return graduatedStudents;
    }

    public boolean graduateStudentByEmail(String email) {
        for (int i = 0; i < enrolledStudents.size(); i++) {
            if (enrolledStudents.get(i).getEmail().equals(email)) {
                graduatedStudents.add(enrolledStudents.get(i));
                enrolledStudents.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean hasStudentWithEmail(String email) {
        for (Student student : enrolledStudents) {
            if (student.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Faculty(name: %s; abbreviation: %s; studyField: %s)", name, abbreviation, studyField);
    }
}
