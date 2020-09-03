package individualproject;

import projectTools.Check;
import projectTools.EditSubjects;
import projectTools.InsertSubjects;
import projectTools.PrintLists;
import projectTools.PrintMenu;
import projectTools.SyntheticData;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class IndividualProject {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> listOfStudents = new ArrayList();
        ArrayList<Trainer> listOfTrainers = new ArrayList();
        ArrayList<Course> listOfCourses = new ArrayList();
        ArrayList<Assignment> listOfAssignments = new ArrayList();
        ArrayList<StudentsInCourse> listOfStudentsInCourse = new ArrayList();
        ArrayList<TrainersInCourse> listOfTrainersInCourse = new ArrayList();
        ArrayList<AssignmentsInCourse> listOfAssignInCourse = new ArrayList();
        ArrayList<Student> listOfStudentsWithMultipleCourses = new ArrayList();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        int mainMenu = -1;
        while (mainMenu != 0) {
            PrintMenu.printMainMenu();
            mainMenu = Check.checkIntInput(0, 4, "Exit");
            switch (mainMenu) {
                case 1:
                    PrintMenu.printAddMenu();
                    mainMenu = Check.checkIntInput(0, 4, "Homescreen");
                    switch (mainMenu) {
                        case 1:
                            int subMenu1 = 1;
                            while (subMenu1 == 1) {
                                InsertSubjects.insertStudent(listOfStudents);
                                System.out.println("Student succesfully created");
                                System.out.println("Type 1 to enter another studente or 0 for homescreen");
                                subMenu1 = Check.checkAnotherInput("student");
                            }
                            break;

                        case 2:
                            subMenu1 = 1;
                            while (subMenu1 == 1) {
                                InsertSubjects.insertCourse(listOfCourses);
                                System.out.println("Course succesfully created");
                                System.out.println("Type 1 to enter another course or 0 for homescreen");
                                subMenu1 = Check.checkAnotherInput("course");
                            }
                            break;

                        case 3:
                            subMenu1 = 1;
                            while (subMenu1 == 1) {
                                InsertSubjects.insertTrainer(listOfTrainers);
                                System.out.println("trainer succesfully created");
                                System.out.println("Type 1 to enter another trainer or 0 for homescreen");
                                subMenu1 = Check.checkAnotherInput("trainer");
                            }
                            break;

                        case 4:
                            subMenu1 = 1;
                            while (subMenu1 == 1) {
                                InsertSubjects.insertAssignment(listOfAssignments);
                                System.out.println("Assignment succesfully created");
                                System.out.println("Type 1 to enter another assignment or 0 for homescreen");
                                subMenu1 = Check.checkAnotherInput("assignment");
                            }
                            break;
                        default:
                            mainMenu = -1;
                            break;
                    }
                    break;
                case 2:
                    PrintMenu.printEditMenu();
                    mainMenu = Check.checkIntInput(0, 3, "Homescreen");
                    switch (mainMenu) {
                        case 1:
                            int subMenu2 = 1;
                            while (subMenu2 == 1) {
                                if (listOfStudents.isEmpty() || listOfCourses.isEmpty()) {
                                    System.out.println("No students or courses available");
                                    subMenu2 = 0;
                                } else {
                                    EditSubjects.addStudentToCourse(listOfStudents, listOfCourses, listOfStudentsInCourse);
                                    System.out.println("Student succesfully added to course");
                                    System.out.println("Type 1 to add another studente or 0 for homescreen");
                                    subMenu2 = Check.checkAnotherInput("student");
                                }
                            }
                            break;

                        case 2:
                            subMenu2 = 1;
                            while (subMenu2 == 1) {
                                if (listOfTrainers.isEmpty() || listOfCourses.isEmpty()) {
                                    System.out.println("No trainers or courses available");
                                    subMenu2 = 0;
                                } else {
                                    EditSubjects.addTrainerToCourse(listOfTrainers, listOfCourses, listOfTrainersInCourse);
                                    System.out.println("Trainer succesfully added to course");
                                    System.out.println("Type 1 to add another trainer or 0 for homescreen");
                                    subMenu2 = Check.checkAnotherInput("trainer");
                                }
                            }
                            break;

                        case 3:
                            subMenu2 = 1;
                            while (subMenu2 == 1) {
                                if (listOfAssignments.isEmpty() || listOfCourses.isEmpty()) {
                                    System.out.println("No assignments or courses available");
                                    subMenu2 = 0;
                                } else {
                                    EditSubjects.addAssignmentToCourse(listOfAssignments, listOfCourses, listOfAssignInCourse);
                                    System.out.println("Assignment succesfully added to course");
                                    System.out.println("Type 1 to add another assignment or 0 for homescreen");
                                    subMenu2 = Check.checkAnotherInput("assignment");
                                }
                            }
                            break;

                        default:
                            mainMenu = -1;
                            break;
                    }
                    break;

                case 3:
                    PrintMenu.printShowMenu();
                    mainMenu = Check.checkIntInput(0, 10, "Homescreen");
                    switch (mainMenu) {
                        case 1:
                            if (listOfStudents.isEmpty()) {
                                System.out.println("No students currently enrolled");

                            } else {
                                PrintLists.printListOfStudents(listOfStudents);
                            }
                            break;
                        case 2:
                            if (listOfCourses.isEmpty()) {
                                System.out.println("No courses currently available");

                            } else {
                                PrintLists.printListOfCourses(listOfCourses);
                            }
                            break;
                        case 3:
                            if (listOfTrainers.isEmpty()) {
                                System.out.println("No trainers currently available");
                            } else {
                                PrintLists.printLisOftTrainers(listOfTrainers);
                            }
                            break;
                        case 4:
                            if (listOfAssignments.isEmpty()) {
                                System.out.println("No assignments currently available");
                            } else {
                                PrintLists.printListOfAssignments(listOfAssignments);
                            }
                            break;
                        case 5:
                            if (listOfCourses.isEmpty() || listOfStudentsInCourse.isEmpty()) {
                                System.out.println("Not available data");
                            } else {
                                PrintLists.printListOfStudentsPerCourse(listOfCourses, listOfStudentsInCourse);
                            }
                            break;
                        case 6:
                            if (listOfCourses.isEmpty() || listOfTrainersInCourse.isEmpty()) {
                                System.out.println("Not available data");
                            } else {
                                PrintLists.printListOfTrainersPerCourse(listOfCourses, listOfTrainersInCourse);
                            }
                            break;
                        case 7:
                            if (listOfCourses.isEmpty() || listOfAssignInCourse.isEmpty()) {
                                System.out.println("Not available data");
                            } else {
                                PrintLists.printListOfAssignmentsPerCourse(listOfCourses, listOfAssignInCourse);
                            }
                            break;
                        case 8:
                            if (listOfAssignInCourse.isEmpty() || listOfStudentsInCourse.isEmpty()) {
                                System.out.println("Not available data");
                            } else {
                                PrintLists.printListOfAssignmentsPerStudent(listOfStudentsInCourse, listOfAssignInCourse);
                            }
                            break;
                        case 9:
                            if (listOfStudents.isEmpty() || listOfStudentsInCourse.isEmpty()) {
                                System.out.println("Not available data");
                            } else {
                                PrintLists.printListOfStudentsWithMultipleCourses(listOfStudents, listOfStudentsInCourse, listOfStudentsWithMultipleCourses);
                            }
                            break;
                        case 10:
                            Check.checkSubmissionDate(listOfStudentsInCourse, listOfAssignInCourse);
                            break;
                        default:
                            mainMenu = -1;
                            break;
                    }
                    break;
                case 4:
                    SyntheticData.getSythData(listOfStudents, listOfCourses, listOfTrainers, listOfAssignments);
                    System.out.println("Synthetic Data Loaded");
                    mainMenu = -1;

                    break;
                default:
                    System.out.println("Thank You");
                    break;
            }
        }
    }
}
