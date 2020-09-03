package individualproject;

import projectTools.Check;
import projectTools.EditSubjects;
import projectTools.InsertSubjects;
import projectTools.PrintMenu;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class IndividualProject {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        int mainMenu = -1;
        while (mainMenu != 0) {
            PrintMenu.printMainMenu();
            mainMenu = Check.checkIntInput(0, 8, "Exit");
            switch (mainMenu) {
                case 1:
                    mainMenu = 1;
                    while (mainMenu == 1) {
                        InsertSubjects.insertStudent();
                        System.out.println("Student succesfully created");
                        System.out.println("Type 1 to enter another studente or 0 for homescreen");
                        mainMenu = Check.checkAnotherInput("student");
                    }
                    break;

                case 2:
                    mainMenu = 1;
                    while (mainMenu == 1) {
                        InsertSubjects.insertCourse();
                        System.out.println("Course succesfully created");
                        System.out.println("Type 1 to enter another course or 0 for homescreen");
                        mainMenu = Check.checkAnotherInput("course");
                    }
                    break;

                case 3:
                    mainMenu = 1;
                    while (mainMenu == 1) {
                        InsertSubjects.insertTrainer();
                        System.out.println("trainer succesfully created");
                        System.out.println("Type 1 to enter another trainer or 0 for homescreen");
                        mainMenu = Check.checkAnotherInput("trainer");
                    }
                    break;

                case 4:
                    mainMenu = 1;
                    while (mainMenu == 1) {
                        InsertSubjects.insertAssignment();
                        System.out.println("Assignment succesfully created");
                        System.out.println("Type 1 to enter another assignment or 0 for homescreen");
                        mainMenu = Check.checkAnotherInput("assignment");
                    }
                    break;

                case 5:
                    mainMenu = 1;
                    while (mainMenu == 1) {
                        EditSubjects.addStudentToCourse();
                        System.out.println("Student succesfully added to course");
                        System.out.println("Type 1 to add another studente or 0 for homescreen");
                        mainMenu = Check.checkAnotherInput("student");
                    }
                    break;

                case 6:
                    mainMenu = 1;
                    while (mainMenu == 1) {
                        EditSubjects.addTrainerToCourse();
                        System.out.println("Trainer succesfully added to course");
                        System.out.println("Type 1 to add another trainer or 0 for homescreen");
                        mainMenu = Check.checkAnotherInput("trainer");
                    }
                    break;

                case 7:
                    mainMenu = 1;
                    while (mainMenu == 1) {
                        EditSubjects.addAssignmentToCourse();
                        System.out.println("Assignment succesfully added to course");
                        System.out.println("Type 1 to add another assignment or 0 for homescreen");
                        mainMenu = Check.checkAnotherInput("assignment");
                    }
                    break;

                case 8:
                    Database.getQueries();
            }
        }
    }
}
