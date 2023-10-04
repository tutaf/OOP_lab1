package lab2;

import lab2.entities.StudyField;

import java.util.Arrays;

public class Utils {

    public static void showErrorMessage(String message) {
        System.out.println("\u001B[31m" + message + "\u001B[0m");
    }

    public static void showInvalidArgumentNumberError() {
        showErrorMessage("Invalid argument number! See help for details (h).");
    }

    public static void showInvalidCommandError(String command) {
        showErrorMessage(command + " is not a valid command. Use h for help.");
    }

    public static void showInvalidStudyFieldError() {
        showErrorMessage("Invalid study field. \nStudy fields: "+ Arrays.toString(StudyField.values()));
    }

}
