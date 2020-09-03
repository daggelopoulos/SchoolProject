package projectTools;

import individualproject.Database;
import java.util.Scanner;

public abstract class EditSubjects {

    public static void addStudentToCourse() {
        Scanner input = new Scanner(System.in);
        Database.printStudentResults(Database.getResults("SELECT * FROM students"));
        System.out.println("Enter student Id you wish to add to course");
        int sid = input.nextInt();
        Database.printCourseResults(Database.getResults("SELECT * FROM courses"));
        System.out.println("Enter course Id you wish to add the student to");
        int cid = input.nextInt();
        Database.insertRecordStudentToCourse(sid, cid);
    }

    public static void addTrainerToCourse() {
        Scanner input = new Scanner(System.in);
        Database.printTrainerResults(Database.getResults("SELECT * FROM trainers"));
        System.out.println("Enter trainer Id you wish to add to course");
        int tid = input.nextInt();
        Database.printCourseResults(Database.getResults("SELECT * FROM courses"));
        System.out.println("Enter course Id you wish to add the trainer to");
        int cid = input.nextInt();
        Database.insertRecordTrainerToCourse(tid, cid);
    }

    public static void addAssignmentToCourse() {
        Scanner input = new Scanner(System.in);
        Database.printAssignmentResults(Database.getResults("SELECT * FROM assignments"));
        System.out.println("Enter assignment Id you wish to add to course");
        int aid = input.nextInt();
        Database.printCourseResults(Database.getResults("SELECT * FROM courses"));
        System.out.println("Enter course Id you wish to add the assignment to");
        int cid = input.nextInt();
        Database.insertRecordAssignmentToCourse(aid, cid);
    }
}
