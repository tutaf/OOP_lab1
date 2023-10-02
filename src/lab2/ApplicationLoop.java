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

        while (true) {
            handleInput(requestInput());
            System.out.println("--------------------");
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
                    }
                }
            }
            case GENERAL_OPERATIONS -> {
                operationRegistry.getOperation(input[0]).execute(input, university);
            }
        }
    }

    String requestInput() {
        System.out.print("\u001B[32muser> \u001B[0m");
        String input =  scanner.nextLine();
        return input;
    }

    static void displayHelp(ProgramState state) {
        switch (state) {
            case MAIN_MENU:
                System.out.println("Available commands:");
                System.out.println("g - General operations");
                System.out.println("f - Faculty operations");
                System.out.println("s - Student operations");
                System.out.println("h - Help");
                System.out.println("\nq - Quit");
                break;
            case GENERAL_OPERATIONS:
                System.out.println("General operations");
                System.out.println("What do you want to do?\n");
                System.out.println("nf/<faculty name>/<faculty abbreviation>/<field> - create faculty");
                System.out.println("ss/<student email> - search student and show faculty");
                System.out.println("df - display faculties");
                System.out.println("df/<field> - display all faculties of a field");
                System.out.println("\nb - Back");
                System.out.println("q - Quit");
                break;
        }
    }

    enum ProgramState {
        MAIN_MENU,
        GENERAL_OPERATIONS,
        FACULTY_OPERATIONS,
        STUDENT_OPERATIONS,
    }
}
