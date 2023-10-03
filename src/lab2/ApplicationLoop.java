package lab2;

import lab2.entities.University;
import lab2.operations.OperationRegistry;

import java.util.Scanner;

public class ApplicationLoop {

    private static final Scanner scanner = new Scanner(System.in);
    private OperationRegistry operationRegistry = new OperationRegistry();
    private University university = new University();
    private ProgramState state = ProgramState.MAIN_MENU;



    public void run() {

        System.out.println("Welcome");
        displayHelp(ProgramState.MAIN_MENU);

        String command = "";
        // meaningful condition
        while (!command.equals("q")) {
            command = requestInput();
            handleInput(command);
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
            return;
        }
        if (state != ProgramState.MAIN_MENU && "b".equals(input[0])) {
            state = ProgramState.MAIN_MENU;
            displayHelp(state);
            return;
        }

        switch (state) {
            case MAIN_MENU -> handleMainMenu(inputString);
            case GENERAL_OPERATIONS, FACULTY_OPERATIONS -> {
                if (operationRegistry.isAValidOperation(input[0])) {
                    operationRegistry.getOperation(input[0]).safeExecute(input, university);
                } else {
                    Utils.showInvalidCommandError(input[0]);
                }
            }
        }
    }

    void handleMainMenu(String input) {
        switch (input) {
            case "g" -> {
                state = ProgramState.GENERAL_OPERATIONS;
                displayHelp(state);
            } case "f" -> {
                state = ProgramState.FACULTY_OPERATIONS;
                displayHelp(state);
            } default -> Utils.showInvalidCommandError(input);
        }
    }

    String requestInput() {
        System.out.print("\u001B[32muser> \u001B[0m");
        return scanner.nextLine();
    }

    void displayHelp(ProgramState state) {
        switch (state) {
            case MAIN_MENU -> printMainMenuHelp();
            case GENERAL_OPERATIONS -> printGeneralOperationsHelp();
            case FACULTY_OPERATIONS -> printFacultyOperationsHelp();
        }
    }

    void printMainMenuHelp() {
        System.out.println("Available commands:");
        System.out.println("g - General operations");
        System.out.println("f - Faculty operations");
        System.out.println("h - Help");
        System.out.println("\nq - Quit");
    }

    void printGeneralOperationsHelp() {
        System.out.println("General operations");
        System.out.println("What do you want to do?\n");
        System.out.println("nf/<faculty name>/<faculty abbreviation>/<field> - create faculty");
        System.out.println("TODO - ss/<student email> - search student and show faculty");
        System.out.println("df - display faculties");
        System.out.println("df/<field> - display all faculties of a field");
        System.out.println("\nb - Back");
        System.out.println("q - Quit");
    }

    void printFacultyOperationsHelp() {
        System.out.println("Faculty operations");
        System.out.println("What do you want to do?\n");
        System.out.println("ns/<faculty abbreviation>/<student first name>/<student last name>/<student email>/<day>/<month>/<year> - create student");
        System.out.println("gs/<email> - (g)raduate (s)tudent");
        System.out.println("ds/<faculty abbreviation> - (d)isplay enrolled (s)tudents");
        System.out.println("dg/<faculty abbreviation> - (d)isplay (g)raduated students");
        System.out.println("TODO - bf/<faculty abbreviation>/<email> - check if student (b)elongs to (f)aculty");
        System.out.println("\nb - Back");
        System.out.println("q - Quit");
    }

    enum ProgramState {
        MAIN_MENU,
        GENERAL_OPERATIONS,
        FACULTY_OPERATIONS,
    }
}
