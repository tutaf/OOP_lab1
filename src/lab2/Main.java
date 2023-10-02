package lab2;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        ProgramState state = ProgramState.MAIN_MENU;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome");
        displayHelp(state);

        while (true) {

        }
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
                System.out.println("General operations:");
                System.out.println("What do you want to do?");
                System.out.println("-----------------------");
                System.out.println("nf/<faculty abbreviation>/<field> - create faculty");
                System.out.println("ss/<student email> - search student and show faculty");
                System.out.println("df - display faculties");
                System.out.println("df/<field> - display all faculties of a field");
                System.out.println("\nb - Back");
                System.out.println("q - Quit");
                break;
        }
    }

    static String requestInput(Scanner scanner) {
        System.out.print("your input> ");
        return scanner.nextLine();
    }




    enum ProgramState {
        MAIN_MENU,
        GENERAL_OPERATIONS,
        FACULTY_OPERATIONS,
        STUDENT_OPERATIONS,
    }
}


