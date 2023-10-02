package lab2.operations.general;

import lab2.entities.Faculty;
import lab2.entities.StudyField;
import lab2.entities.University;
import lab2.operations.Operation;

import java.util.ArrayList;
import java.util.List;

public class DisplayFaculties implements Operation {
    @Override
    public int requiredArgsNumber() { // TODO: this breaks no-argument command, fix required
        return 1;
    }

    @Override
    public boolean execute(String[] args, University university) {

        List<Faculty> facultyList = university.getFacultyList();

        if (args.length > 1) {
            StudyField selectedStudyField = StudyField.valueOf(args[1]);

            facultyList = facultyList.stream()
                    .filter(faculty -> faculty.getStudyField().equals(selectedStudyField))
                    .toList();

            System.out.printf("Faculties with study field %s:%n", selectedStudyField);
        } else {
            System.out.println("All Faculties:");
        }

        for (Faculty faculty : facultyList) {
            System.out.println(faculty.toString());
        }

        return true;
    }
}
