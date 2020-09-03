package projectTools;

import individualproject.Assignment;
import individualproject.AssignmentsInCourse;
import individualproject.Course;
import individualproject.Student;
import individualproject.StudentsInCourse;
import individualproject.Trainer;
import individualproject.TrainersInCourse;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class EditSubjects {

    public static void addStudentToCourse(ArrayList<Student> students, ArrayList<Course> courses, ArrayList<StudentsInCourse> studentsToCourse) {
        Scanner input = new Scanner(System.in);
        int b = 1;
        for (int i = 0; i < students.size(); i++) {
            System.out.printf("%d %s %s \n", (i + 1), students.get(i).getFirstName(), students.get(i).getLastName());
        }
        System.out.println("Enter student you wish to add to course");
        do {
            if (input.hasNextInt()) {
                b = input.nextInt();
                if (b < 1 || b > students.size()) {
                    System.out.println("Type a number from 1 to " + students.size());
                }
            } else {
                input.next();
                b = -1;
                System.out.println("Please enter only numbers");
            }
        } while (b < 1 || b > students.size());
        Student x = students.get(b - 1);
        for (int i = 0; i < courses.size(); i++) {
            System.out.printf("%d %s %s \n", (i + 1), courses.get(i).getTitle(), courses.get(i).getType());
        }
        System.out.println("Enter course you wish to add the student to");
        do {
            if (input.hasNextInt()) {
                b = input.nextInt();
                if (b < 1 || b > courses.size()) {
                    System.out.println("Type a number from 1 to " + courses.size());
                }
            } else {
                input.next();
                b = -1;
                System.out.println("Please enter only numbers");
            }
        } while (b < 1 || b > courses.size());
        Course y = courses.get(b - 1);
        StudentsInCourse studentInCourse1 = new StudentsInCourse(x, y);
        studentsToCourse.add(studentInCourse1);
    }

    public static void addTrainerToCourse(ArrayList<Trainer> trainers, ArrayList<Course> courses, ArrayList<TrainersInCourse> trainersToCourse) {
        Scanner input = new Scanner(System.in);
        int b = 1;
        for (int i = 0; i < trainers.size(); i++) {
            System.out.printf("%d %s %s \n", (i + 1), trainers.get(i).getFirstName(), trainers.get(i).getLastName());
        }
        System.out.println("Enter trainer you wish to add to course");
        do {
            if (input.hasNextInt()) {
                b = input.nextInt();
                if (b < 1 || b > trainers.size()) {
                    System.out.println("Type a number from 1 to " + trainers.size());
                }
            } else {
                input.next();
                b = -1;
                System.out.println("Please enter only numbers");
            }
        } while (b < 1 || b > trainers.size());
        Trainer x = trainers.get(b - 1);
        for (int i = 0; i < courses.size(); i++) {
            System.out.printf("%d %s %s \n", (i + 1), courses.get(i).getTitle(), courses.get(i).getType());
        }
        System.out.println("Enter course you wish to add the trainer to");
        do {
            if (input.hasNextInt()) {
                b = input.nextInt();
                if (b < 1 || b > courses.size()) {
                    System.out.println("Type a number from 1 to " + courses.size());
                }
            } else {
                input.next();
                b = -1;
                System.out.println("Please enter only numbers");
            }
        } while (b < 1 || b > courses.size());
        Course y = courses.get(b - 1);
        TrainersInCourse trainerInCourse1 = new TrainersInCourse(x, y);
        trainersToCourse.add(trainerInCourse1);
    }

    public static void addAssignmentToCourse(ArrayList<Assignment> assignments, ArrayList<Course> courses, ArrayList<AssignmentsInCourse> assignmentsToCourse) {
        Scanner input = new Scanner(System.in);
        int b = 1;
        for (int i = 0; i < assignments.size(); i++) {
            System.out.printf("%d %s %s \n", (i + 1), assignments.get(i).getTitle(), assignments.get(i).getDescription());
        }
        System.out.println("Enter assignment you wish to add to course");
        do {
            if (input.hasNextInt()) {
                b = input.nextInt();
                if (b < 1 || b > assignments.size()) {
                    System.out.println("Type a number from 1 to " + assignments.size());
                }
            } else {
                input.next();
                b = -1;
                System.out.println("Please enter only numbers");
            }
        } while (b < 1 || b > assignments.size());

        Assignment x = assignments.get(b - 1);

        for (int i = 0; i < courses.size(); i++) {
            System.out.printf("%d %s %s \n", (i + 1), courses.get(i).getTitle(), courses.get(i).getType());
        }
        System.out.println("Enter course you wish to add the assignment to");
        do {
            if (input.hasNextInt()) {
                b = input.nextInt();
                if (b < 1 || b > courses.size()) {
                    System.out.println("Type a number from 1 to " + courses.size());
                }
            } else {
                input.next();
                b = -1;
                System.out.println("Please enter only numbers");
            }
        } while (b < 1 || b > courses.size());

        Course y = courses.get(b - 1);
        AssignmentsInCourse assignInCourse1 = new AssignmentsInCourse(x, y);
        assignmentsToCourse.add(assignInCourse1);
    }
}
