# Lab 2 - University Management System

This lab focuses on building a basic University Management System, allowing operations related to faculties and students.

## Main Components

1. **[University](https://github.com/tutaf/OOP_lab1/blob/main/src/lab2/entities/University.java)**: Represents the main entity, contains a list of faculties.
2. **[Faculty](https://github.com/tutaf/OOP_lab1/blob/main/src/lab2/entities/Faculty.java)**: Represents a faculty, contains list of enrolled/graduated students, as well as basic info about faculty.
3. **[Student](https://github.com/tutaf/OOP_lab1/blob/main/src/lab2/entities/Student.java)**: Represents a student.
4. **[StudyField](https://github.com/tutaf/OOP_lab1/blob/main/src/lab2/entities/StudyField.java)**: Enum representing various fields of study.

## Operations

1. **[Operation](https://github.com/tutaf/OOP_lab1/blob/main/src/lab2/operations/Operation.java)**: An interface to unify command line operations.
2. **[OperationRegistry](https://github.com/tutaf/OOP_lab1/blob/main/src/lab2/operations/OperationRegistry.java)**: A registry of all available operations.

## Utilities

1. **[SaveManager](https://github.com/tutaf/OOP_lab1/blob/main/src/lab2/SaveManager.java)**: Saves and restores state of the university.
2. **[Utils](https://github.com/tutaf/OOP_lab1/blob/main/src/lab2/Utils.java)**: Contains utility methods for displaying messages.

## Application Loop.

The main loop of the application is managed by the **[ApplicationLoop](https://github.com/tutaf/OOP_lab1/blob/main/src/lab2/ApplicationLoop.java)** class. Provides command line interface to perform operations with university

---

To get started, run the [Main](https://github.com/tutaf/OOP_lab1/blob/main/src/lab2/Main.java) class.
