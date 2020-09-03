package projectTools;

import individualproject.Assignment;
import individualproject.Course;
import individualproject.Student;
import individualproject.Trainer;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class SyntheticData {

    public static void getSythData(ArrayList<Student> students, ArrayList<Course> courses, ArrayList<Trainer> trainers, ArrayList<Assignment> assignments) {
        Student student1 = new Student("Dimitris", "Aggelopoulos", LocalDate.of(1988, 05, 19), 2500);
        Student student2 = new Student("Takis", "Ploutonas", LocalDate.of(2001, 10, 25), 5000);
        Student student3 = new Student("Minas", "Badounieri", LocalDate.of(1980, 03, 02), 2200);
        Student student4 = new Student("Ilias", "Koutsoumpardis", LocalDate.of(1990, 05, 01), 2000);
        Student student5 = new Student("Harry", "G", LocalDate.of(1988, 05, 19), 7500);
        Student student6 = new Student("Faidra", "Xomeritaki", LocalDate.of(1991, 01, 02), 12500);
        Student student7 = new Student("Iris", "Labrador", LocalDate.of(2007, 3, 01), 5);
        Student student8 = new Student("Venetia", "Aggelopoulou", LocalDate.of(1991, 01, 03), 1500);
        Student student9 = new Student("Xhin", "Wu", LocalDate.of(2000, 05, 13), 2550);
        Student student10 = new Student("Dimitra", "Satanaki", LocalDate.of(2000, 10, 26), 1200);
        Trainer trainer1 = new Trainer("Tasos", "Lelakis", "Java");
        Trainer trainer2 = new Trainer("Nikos", "Tsidimas", "C#");
        Trainer trainer3 = new Trainer("Eleni", "Petroulaki", "Gymnastics");
        Course course1 = new Course("Beginner Java", "Online", "Part Time", LocalDate.of(2020, 3, 3), LocalDate.of(2020, 9, 3));
        Course course2 = new Course("Advanced Java", "Online", "Full Time", LocalDate.of(2020, 3, 3), LocalDate.of(2020, 6, 3));
        Course course3 = new Course("Beginner C#", "Online", "Part Time", LocalDate.of(2020, 3, 15), LocalDate.of(2020, 9, 15));
        Course course4 = new Course("Advanced C#", "Online", "Full Time", LocalDate.of(2020, 4, 10), LocalDate.of(2020, 7, 15));
        Assignment assignment1 = new Assignment("Java", "Individual Project", LocalDate.of(2020, 5, 1), 0, 0);
        Assignment assignment2 = new Assignment("C#", "Individual Project", LocalDate.of(2020, 6, 1), 0, 0);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        students.add(student10);
        trainers.add(trainer1);
        trainers.add(trainer2);
        trainers.add(trainer3);
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        assignments.add(assignment1);
        assignments.add(assignment2);
    }
}
