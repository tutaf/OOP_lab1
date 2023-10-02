package lab2.operations.general;

import lab2.entities.Faculty;
import lab2.entities.StudyField;
import lab2.entities.University;
import lab2.operations.Operation;

public class CreateFaculty implements Operation {

    @Override
    public void execute(String[] args, University university) {
        String facultyName = args[1];
        String facultyAbbreviation = args[2];
        StudyField studyField = StudyField.valueOf(args[3]);

        university.addFaculty(new Faculty(facultyName, facultyAbbreviation, studyField));

        System.out.println("Faculty created successfully!");
    }
}
