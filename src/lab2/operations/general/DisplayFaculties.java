package lab2.operations.general;

import lab2.entities.Faculty;
import lab2.entities.University;
import lab2.operations.Operation;

import java.util.ArrayList;
import java.util.List;

public class DisplayFaculties implements Operation {
    @Override
    public void execute(String[] args, University university) {
        // TODO: implement "df/<study field>" operation

        List<Faculty> facultyList = university.getFacultyList();

        System.out.println("All Faculties:");
        for (Faculty faculty : facultyList) {
            System.out.println(faculty.toString());
        }
    }
}
