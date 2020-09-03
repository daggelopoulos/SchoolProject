package projectTools;

import individualproject.AssignmentsInCourse;
import individualproject.StudentsInCourse;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Check {

    public static int checkIntInput(int min, int max, String message) {
        Scanner input = new Scanner(System.in);
        int inputUser = -1;
        do {
            System.out.println("Please enter numbers from " + (min + 1) + " to " + max + ", 0 for " + message);
            if (input.hasNextInt()) {
                inputUser = input.nextInt();
            } else {
                input.next();
            }
        } while (inputUser < min || inputUser > max);
        return inputUser;
    }

    public static int checkTuitionInput() {
        Scanner input = new Scanner(System.in);
        int tuition = -1;
        do {
            if (input.hasNextInt()) {
                tuition = input.nextInt();
                if (tuition < 0) {
                    System.out.println("Please enter only positive numbers");
                }
            } else {
                input.next();
                System.out.println("Please enter only numbers");
            }
        } while (tuition < 0);
        return tuition;
    }

    public static int checkAnotherInput(String message) {
        Scanner input = new Scanner(System.in);
        int insertAnother = -1;
        do {
            if (input.hasNextInt()) {
                insertAnother = input.nextInt();
                if (insertAnother != 0 && insertAnother != 1) {
                    System.out.println("Type 1 to enter another " + "message" + " or 0 for homescreen");
                }
            } else {
                input.next();
                System.out.println("Please enter only numbers");
            }
        } while (insertAnother != 0 && insertAnother != 1);
        return insertAnother;
    }

    public static boolean checkValidDate(String d) {
        String regex = "^([0-2][0-9]|(3)[0-1])(-)(((0)[0-9])|((1)[0-2]))(-)\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence) d);
        return matcher.matches();
    }

    public static void checkSubmissionDate(ArrayList<StudentsInCourse> studentsInCourse, ArrayList<AssignmentsInCourse> assignmentsInCourse) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Assignment Submission Check");
        System.out.println("Please enter date ( dd-MM-yyyy )");
        String inDate = input.next();
        while (Check.checkValidDate(inDate) == false) {
            System.out.println("Invalid date. Enter format ( dd-MM-yyyy )");
            inDate = input.next();
        }
        LocalDate inputDate = LocalDate.parse(inDate, dateFormat);
        while (inputDate.getDayOfWeek() != DayOfWeek.MONDAY) {
            inputDate = inputDate.minusDays(1);
        }
        inputDate = inputDate.minusDays(1);
        if (studentsInCourse.isEmpty() || assignmentsInCourse.isEmpty()) {
            System.out.println("No assignments found");
        } else {
            int count = 0;
            for (StudentsInCourse x : studentsInCourse) {
                for (AssignmentsInCourse y : assignmentsInCourse) {
                    if (x.getCourse().equals(y.getCourse())) {
                        String name = x.getStudent().getFirstName();
                        String lname = x.getStudent().getLastName();
                        String title = y.getAssignment().getTitle();
                        String description = y.getAssignment().getDescription();
                        LocalDate date = y.getAssignment().getSubDateTime();
                        LocalDate inputEndDate = inputDate.plusDays(6);

                        if (inputDate.isBefore(date) && inputEndDate.isAfter(date)) {
                            System.out.println("Assignments to be submitted");
                            System.out.println(name + " " + lname + ": " + title + " " + description + " " + date.format(dateFormat));
                            count++;
                        } 
                    }
                }
            }
            if (count == 0)
            System.out.println("No assignments to be submitted");
        }

    }

}
