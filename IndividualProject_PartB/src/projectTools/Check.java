package projectTools;

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
        if (insertAnother == 0) {
            insertAnother = -1;
        }
        return insertAnother;
    }

    public static boolean checkValidDate(String d) {
        String regex = "^([0-2][0-9]|(3)[0-1])(-)(((0)[0-9])|((1)[0-2]))(-)\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence) d);
        return matcher.matches();
    }

}
