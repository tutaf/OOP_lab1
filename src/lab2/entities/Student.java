package lab2.entities;

import java.time.LocalDate;

public class Student {

    private String name;
    private String lastName;
    private String email;
    private LocalDate enrollmentDate;
    private LocalDate dateOfBirth;



    public Student(String name, String lastName, String email, LocalDate enrollmentDate, LocalDate dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.dateOfBirth = dateOfBirth;
    }



    @Override
    public String toString() {
        return String.format("Student(name: %s; lastName: %s; email: %s; enrollmentDate: %s; dateOfBirth: %s)", name, lastName, email, enrollmentDate.toString(), dateOfBirth.toString());
    }
}
