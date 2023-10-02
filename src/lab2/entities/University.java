package lab2.entities;

import java.util.ArrayList;
import java.util.List;

public class University {

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

}
