package lab2.entities;

import java.util.ArrayList;
import java.util.List;

public class Faculty {

    public Faculty(String name, String abbreviation, StudyField studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.students = new ArrayList<Student>();
        this.studyField = studyField;
    }

    private String name;

    private String abbreviation;

    private List<Student> students;

    private StudyField studyField;



    public void addStudent(Student student) {
        this.students.add(student);
    }



}
