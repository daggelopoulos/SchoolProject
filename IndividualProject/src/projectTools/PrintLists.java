package projectTools;

import individualproject.Assignment;
import individualproject.AssignmentsInCourse;
import individualproject.Course;
import individualproject.Student;
import individualproject.StudentsInCourse;
import individualproject.Trainer;
import individualproject.TrainersInCourse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.util.converter.LocalDateStringConverter;

public abstract class PrintLists {

    public static void printListOfStudents(ArrayList<Student> students) {
        System.out.println("List of Students");
        for (Student x : students) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            System.out.printf("Name: %s %s %s \n", x.getFirstName(), x.getLastName(), x.getDateOfBirth().format(dateFormat));
        }
    }

    public static void printListOfCourses(ArrayList<Course> courses) {
        System.out.println("List of Courses");
        for (Course x : courses) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            System.out.printf("Title: %s, Stream: %s, Type: %s, %s - %s \n", x.getTitle(), x.getStream(), x.getType(), x.getStart_date().format(dateFormat), x.getEnd_date().format(dateFormat));
        }
    }

    public static void printLisOftTrainers(ArrayList<Trainer> trainers) {
        System.out.println("List of Trainers");
        for (Trainer x : trainers) {
            System.out.printf("Name: %s %s ,Subject: %s \n", x.getFirstName(), x.getLastName(), x.getSubject());
        }
    }

    public static void printListOfAssignments(ArrayList<Assignment> assignments) {
        System.out.println("List of Assignments");
        for (Assignment x : assignments) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            System.out.printf("Title: %s, Description: %s, SubDate: %s \n", x.getTitle(), x.getDescription(), x.getSubDateTime().format(dateFormat));
        }
    }

    public static void printListOfStudentsPerCourse(ArrayList<Course> courses, ArrayList<StudentsInCourse> studentsInCourse) {
        System.out.println("List of students per course");
        for (Course x : courses) {
            System.out.println(x.getTitle());
            for (StudentsInCourse y : studentsInCourse) {
                if (x.equals(y.getCourse())) {
                    System.out.println(y.getStudent().getFirstName() + " " + y.getStudent().getLastName());
                }
            }
        }
    }

    public static void printListOfTrainersPerCourse(ArrayList<Course> courses, ArrayList<TrainersInCourse> trainersInCourse) {
        System.out.println("List of trainers per course");
        for (Course x : courses) {
            System.out.println(x.getTitle());
            for (TrainersInCourse y : trainersInCourse) {
                if (x.equals(y.getCourse())) {
                    System.out.println(y.getTrainer().getFirstName() + " " + y.getTrainer().getLastName());
                }
            }
        }
    }

    public static void printListOfAssignmentsPerCourse(ArrayList<Course> courses, ArrayList<AssignmentsInCourse> assignmentsInCourse) {
        System.out.println("List of assignments per course");
        for (Course x : courses) {
            System.out.println(x.getTitle());
            for (AssignmentsInCourse y : assignmentsInCourse) {
                if (x.equals(y.getCourse())) {
                    System.out.println(y.getAssignment().getTitle() + " " + y.getAssignment().getDescription());
                }
            }
        }
    }

    public static void printListOfAssignmentsPerStudent(ArrayList<StudentsInCourse> studentsInCourse, ArrayList<AssignmentsInCourse> assignmentsInCourse) {
        System.out.println("List of assignments per student");
        for (StudentsInCourse x : studentsInCourse) {
            System.out.println(x.getStudent().getFirstName() + " " + x.getStudent().getLastName());
            for (AssignmentsInCourse y : assignmentsInCourse) {
                if (x.getCourse().equals(y.getCourse())) {
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    System.out.println(y.getAssignment().getTitle() + " " + y.getAssignment().getDescription() + " " + y.getAssignment().getSubDateTime().format(dateFormat));
                } 
            }
        }
    }

    public static void printListOfStudentsWithMultipleCourses(ArrayList<Student> students, ArrayList<StudentsInCourse> studentsInCourse, ArrayList<Student> studentsWithMultiCourses) {
        System.out.println("List of students with multiple courses");
        for (Student x : students) {
            int i = 0;
            for (StudentsInCourse y : studentsInCourse) {
                if (x.equals(y.getStudent())) {
                    i++;
                }
            }
            if (i > 1) {
                studentsWithMultiCourses.add(x);
            }
        }
        if (studentsWithMultiCourses.isEmpty()) {
            System.out.println("No students with multiple courses");
        } else {
            for (Student x : studentsWithMultiCourses) {
                System.out.println(x.getFirstName() + " " + x.getLastName());
            }
        }

    }
}
