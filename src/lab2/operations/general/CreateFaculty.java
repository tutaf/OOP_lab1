package lab2.operations.general;

import lab2.Utils;
import lab2.entities.Faculty;
import lab2.entities.StudyField;
import lab2.entities.University;
import lab2.operations.Operation;

import java.util.Arrays;

public class CreateFaculty implements Operation {


    @Override
    public boolean matchesRequiredArgsNumber(int argNumber) {
        return argNumber == 4;
    }

    @Override
    public boolean execute(String[] args, University university) {
        String facultyName = args[1];
        String facultyAbbreviation = args[2];
        StudyField studyField;

        try {
            studyField = StudyField.valueOf(args[3]);
        } catch (Exception e) {
            Utils.showInvalidStudyFieldError();
            return false;
        }

        university.addFaculty(new Faculty(facultyName, facultyAbbreviation, studyField));

        System.out.println("Faculty created successfully!");
        return true;

    }
}
