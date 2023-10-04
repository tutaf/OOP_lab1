package lab2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class University implements Serializable {

    private List<Faculty> faculties;

    public University() {
        this.faculties = new ArrayList<Faculty>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public List<Faculty> getFacultyList() {
        return faculties;
    }

    public boolean graduateStudentByEmail(String email) {
        for (Faculty faculty : faculties) {
            if (faculty.graduateStudentByEmail(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasStudentWithEmail(String email) {
        for (Faculty faculty : faculties) {
            if (faculty.hasStudentWithEmail(email)) {
                return true;
            }
        }
        return false;
    }

    public Faculty getFacultyByAbbreviation(String abbreviation) {
        return faculties.stream()
                .filter(faculty -> faculty.getAbbreviation().equals(abbreviation))
                .findFirst()
                .orElse(null);
    }

}
