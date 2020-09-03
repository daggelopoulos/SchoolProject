package projectTools;

import individualproject.Database;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InsertSubjects {

    public static void insertStudent() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter student's name");
        String studentName = input.next();
        System.out.println("Please enter student's last name");
        String studentLastName = input.next();
        System.out.println("Please enter student's date of birth ( dd-MM-yyyy )");
        String birth = input.next();
        while (Check.checkValidDate(birth) == false) {
            System.out.println("Invalid date. Enter format ( dd-MM-yyyy )");
            birth = input.next();
        }
        LocalDate dateOfBirth = LocalDate.parse(birth, dateFormat);
        System.out.println("Please enter student's tuition fees");
        int tuition = Check.checkTuitionInput();
        Database.insertRecordToStudents(studentName, studentLastName, dateOfBirth, tuition);

    }

    public static void insertCourse() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter course title");
        String courseTitle = input.next();
        System.out.println("Please enter course stream");
        String courseStream = input.next();
        System.out.println("Please enter course type");
        String courseType = input.next();
        System.out.println("Please enter course's starting date ( dd-MM-yyyy )");
        String startDate = input.next();
        while (Check.checkValidDate(startDate) == false) {
            System.out.println("Invalid date. Enter format ( dd-MM-yyyy )");
            startDate = input.next();
        }
        LocalDate courseStartDate = LocalDate.parse(startDate, dateFormat);
        System.out.println("Please enter course's end date ( dd-MM-yyyy )");
        String endDate = input.next();
        while (Check.checkValidDate(endDate) == false) {
            System.out.println("Invalid date. Enter format ( dd-MM-yyyy )");
            endDate = input.next();
        }
        LocalDate courseEndDate = LocalDate.parse(endDate, dateFormat);
        Database.insertRecordToCourses(courseTitle, courseStream, courseType, courseStartDate, courseEndDate);
    }

    public static void insertTrainer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter trainer's first name");
        String trainerFirstName = input.next();
        System.out.println("Please enter trainer's last name");
        String trainerLastName = input.next();
        System.out.println("Please enter trainer's subject");
        String trainerSubject = input.next();
        Database.insertRecordToTrainers(trainerFirstName, trainerLastName, trainerSubject);
    }

    public static void insertAssignment() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter assignment title");
        String assignmentTitle = input.next();
        System.out.println("Please enter assignment description");
        String assignmentDescription = input.next();
        System.out.println("Please enter assignment submission date ( dd-MM-yyyy )");
        String subDateTime = input.next();
        while (Check.checkValidDate(subDateTime) == false) {
            System.out.println("Invalid date. Enter format ( dd-MM-yyyy )");
            subDateTime = input.next();
        }
        LocalDate assignmentSubDateTime = LocalDate.parse(subDateTime, dateFormat);
        System.out.println("Please enter assignment oral mark");
        int assignmentOralMark = -1;
        do {
            if (input.hasNextInt()) {
                assignmentOralMark = input.nextInt();
                if (assignmentOralMark < 0 || assignmentOralMark > 100) {
                    System.out.println("Please enter only mark 0-100");
                }
            } else {
                input.next();
                System.out.println("Please enter only numbers");
            }
        } while (assignmentOralMark < 0 || assignmentOralMark > 100);
        System.out.println("Please enter assignment total mark");
        int assignmentTotalMark = -1;
        do {
            if (input.hasNextInt()) {
                assignmentTotalMark = input.nextInt();
                if (assignmentTotalMark < 0 || assignmentTotalMark > 100) {
                    System.out.println("Please enter only mark 0-100");
                }
            } else {
                input.next();
                System.out.println("Please enter only numbers");
            }
        } while (assignmentTotalMark < 0 || assignmentTotalMark > 100);
        Database.insertRecordToAssignments(assignmentTitle, assignmentDescription, assignmentSubDateTime, assignmentOralMark, assignmentTotalMark);
    }
}
