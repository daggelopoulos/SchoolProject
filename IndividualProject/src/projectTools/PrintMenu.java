package projectTools;

public abstract class PrintMenu {

    public static void printMainMenu() {
        System.out.println("School Database Program");
        System.out.println("1 Insert Data");
        System.out.println("2 Edit Data");
        System.out.println("3 Show Data");
        System.out.println("4 Demo Mode ");
        System.out.println("0 Exit");
    }

    public static void printAddMenu() {
        System.out.println("1 Insert Student");
        System.out.println("2 Insert Course");
        System.out.println("3 Insert Trainer");
        System.out.println("4 Insert Assignment");
        System.out.println("0 Return to Homescreen");
    }

    public static void printEditMenu() {
        System.out.println("1 Add Student to Course");
        System.out.println("2 Add Trainer to Course");
        System.out.println("3 Add Assignment to Course");
        System.out.println("0 Return to Homescreen");
    }

    public static void printShowMenu() {
        System.out.println("1 Show List of Students");
        System.out.println("2 Show List of Courses");
        System.out.println("3 Show List of Trainers");
        System.out.println("4 Show List of Assignments");
        System.out.println("5 All the Students per Course");
        System.out.println("6 All the Trainers per Course");
        System.out.println("7 All the Assignments per Course");
        System.out.println("8 All the Assignments per student");
        System.out.println("9 List of Students with Multiple Courses");
        System.out.println("10 Assignment Submission Check");
        System.out.println("0 Return to Homescreen");
    }
}
