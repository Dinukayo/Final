package package1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tester {

    public static int id;
    static String name;
    static String yob;
    static int height;
    static int weight;
    static Bmi bmi;
    public static List<Bmi> users = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> create();
                case 2 -> index();
                case 3 -> {
                    System.out.println("Please Enter User Id");
                    choice = scanner.nextInt();
                    view(choice);
                }
                case 4 -> delete();
                case 5 -> exit();
                default -> throw new AssertionError();
            }
        } while (true);

    }

    public static void displayMenu() {
        System.out.println("Welcome!");
        System.out.println("** BMI CALCULATOR **");
        System.out.println("");
        System.out.println("1.Make a record");
        System.out.println("2.Display BMI data for all users. ");
        System.out.println("3.Display BMI data for a selected user");
        System.out.println("4.Delete all ");
        System.out.println("5.Exit ");
        System.out.println("");
        System.out.println("Please Enter Your option ");

    }

    public static void view(int id) { // show onw record
        users.forEach(user -> {
            if (user.getId() == id) {
                user.display();
            }
        });
    }

    public static void create() {

        boolean isIdOk = false;
        boolean isNameOk = false;
        boolean isYobOk = false;
        boolean isHeightOk = false;
        boolean isWeightOk = false;

        for (int i = 0; i < 3; i++) {

            if (!isIdOk) {
                System.out.println("Input your id number here:");
                id = scanner.nextInt();
                scanner.nextLine();
            }
            if (!isNameOk) {
                System.out.println("Input your name here:");
                name = scanner.nextLine();
                isNameOk = true;
            }
            if (!isYobOk) {
                System.out.println("Input your yob here:");
                yob = scanner.nextLine();
            }
            if (!isHeightOk) {
                System.out.println("Input your height here:");
                height = scanner.nextInt();
                isHeightOk = true;
            }
            if (!isWeightOk) {
                System.out.println("Input your weight here:");
                weight = scanner.nextInt();
                isWeightOk = true;
            }

            if (id < 0 || id > 6) {
                System.out.println("Id must be greater than 0 and less than 5");
                i = 1;
            } else {
                isIdOk = true;
                i = 3;
            }

            if (Integer.parseInt(yob) >= 2025) {
                System.out.println("Year of birth must be less than 2025");
                i = 1;
            } else {
                isYobOk = true;
                if (i != 1) {//error on previous validation
                    i = 3;
                }
            }

        }

        bmi = new Bmi(id, name, yob, height, weight);
        users.add(bmi);
        index();
        System.out.println(users.size());

//        displayMenu();
//        scanner.nextLine();
    }

    public static void index() {
        users.forEach(user -> user.display());

    }

    public static void delete() {
        users.clear();
    }

    public static void exit() {
        System.exit(0);
    }

}
