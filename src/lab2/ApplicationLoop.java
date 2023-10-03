package lab2;

import jdk.jshell.execution.Util;
import lab2.entities.University;
import lab2.operations.OperationRegistry;

import java.util.*;

public class ApplicationLoop {

    private static final Scanner scanner = new Scanner(System.in);
    private OperationRegistry operationRegistry = new OperationRegistry();
    private University university = new University();
    private ProgramState state = ProgramState.MAIN_MENU;



    public void run() {

        System.out.println("Welcome");
        displayHelp(ProgramState.MAIN_MENU);

        while (true) {
            handleInput(requestInput());
            System.out.println();
        }
    }

    void handleInput(String inputString) {
        String[] input = inputString.split("/");

        if ("h".equals(input[0])) {
            displayHelp(state);
            return;
        }
        if ("q".equals(input[0])) {
            System.out.println("Bye!");
            System.exit(0);
        }
        if (state != ProgramState.MAIN_MENU && "b".equals(input[0])) {
            state = ProgramState.MAIN_MENU;
            displayHelp(state);
            return;
        }

        switch (state) {
            case MAIN_MENU -> {
                switch (input[0]) {
                    case "g" -> {
                        state = ProgramState.GENERAL_OPERATIONS;
                        displayHelp(state);
                    } case "f" -> {
                        state = ProgramState.FACULTY_OPERATIONS;
                        displayHelp(state);
                    } default -> Utils.showInvalidCommandError(input[0]);
                }
            }
            case GENERAL_OPERATIONS, FACULTY_OPERATIONS -> {
                if (operationRegistry.isAValidOperation(input[0])) {
                    operationRegistry.getOperation(input[0]).safeExecute(input, university);
                } else {
                    Utils.showInvalidCommandError(input[0]);
                }
            }
//            case GENERAL_OPERATIONS -> {
//                if (!isValidCommand(Arrays.asList("nf", "ss", "df"), input[0])) {
//                    showInvalidCommandErrorMessage(input[0]);
//                    return;
//                }
//                boolean success = operationRegistry.getOperation(input[0]).safeExecute(input, university);
//                if (!success) showInvalidArgumentsException();
//            }
//            case FACULTY_OPERATIONS -> {
//                if (!isValidCommand(Arrays.asList("ns", "gs", "ds", "dg", "bf"), input[0])) {
//                    showInvalidCommandErrorMessage(input[0]);
//                    return;
//                }
//                boolean success = operationRegistry.getOperation(input[0]).safeExecute(input, university);
//                if (!success) showInvalidArgumentsException();
//            }
        }
    }

    String requestInput() {
        System.out.print("\u001B[32muser> \u001B[0m");
        return scanner.nextLine();
    }

    static void displayHelp(ProgramState state) {
        switch (state) {
            case MAIN_MENU:
                System.out.println("Available commands:");
                System.out.println("g - General operations");
                System.out.println("f - Faculty operations");
                System.out.println("h - Help");
                System.out.println("\nq - Quit");
                break;
            case GENERAL_OPERATIONS:
                System.out.println("General operations");
                System.out.println("What do you want to do?\n");
                System.out.println("nf/<faculty name>/<faculty abbreviation>/<field> - create faculty");
                System.out.println("TODO - ss/<student email> - search student and show faculty");
                System.out.println("df - display faculties");
                System.out.println("df/<field> - display all faculties of a field");
                System.out.println("\nb - Back");
                System.out.println("q - Quit");
                break;
            case FACULTY_OPERATIONS:
                System.out.println("Faculty operations");
                System.out.println("What do you want to do?\n");
                System.out.println("ns/<faculty abbreviation>/<student first name>/<student last name>/<student email>/<day>/<month>/<year> - create student");
                System.out.println("TODO - gs/<email> - (g)raduate (s)tudent");
                System.out.println("ds/<faculty abbreviation> - (d)isplay enrolled (s)tudents");
                System.out.println("TODO - dg/<faculty abbreviation> - (d)isplay (g)raduated students");
                System.out.println("TODO - bf/<faculty abbreviation>/<email> - check if student (b)elongs to (f)aculty");


                System.out.println("\nb - Back");
                System.out.println("q - Quit");
                break;
        }
    }

//    private boolean isValidCommand(List<String> validCommands, String command) {
//        return validCommands.contains(command);
//    }
//
//    private void showErrorMessage(String message) {
//        System.out.println("\u001B[31m" + message + "\u001B[0m");
//    }
//
//    private void showInvalidArgumentsException() {
//        System.out.println("\u001B[31mError! Check your arguments. Help - \"h\"\u001B[0m");
//    }
//
//    private void showInvalidCommandErrorMessage(String command) {
//        showErrorMessage(command + " is not a valid command. Use h for help.");
//    }

    enum ProgramState {
        MAIN_MENU,
        GENERAL_OPERATIONS,
        FACULTY_OPERATIONS,
    }
}
