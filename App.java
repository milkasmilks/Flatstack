package Flatstack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.init();
        app.start();
    }

    // Some app resources
    public Scanner inputScanner;

    // Some app properties
    public final String[] COMMAND_NAMES = {
            "exit", "help", "newSequence"
    };

    /**
     * Initialization function.
     */
    public void init() {
        inputScanner = new Scanner(System.in);
    }

    /**
     * Main running method.
     */
    public void start() {
        System.out.println("Hello! I am an App that generates interesting sequence" +"\n" + "and which was made for the successful entry into the Ruby On Rails course!");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("My creator really hopes that you will like this app and will allow her to entry your course!");
        System.out.println("Try me!");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        runHelp();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        while (true) {
            System.out.println("Please input the command.");
            String command = inputScanner.nextLine().trim();

            switch (command) {
                case "exit":
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                case "help":
                    runHelp();
                    break;
                case "newSequence":
                    newSequenceCreation();
                    break;
                default:
                    System.out.println("Unknown command");
                    runHelp();
                    break;
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    /**
     * Help running method.
     */
    public void runHelp() {
        System.out.println("These are the command that you can input: " + Arrays.toString(COMMAND_NAMES));
    }

    /**
     * New sequence creation method.
     */
    public void newSequenceCreation() {
        System.out.println("Please input the number to generate its sequence: ");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Please input only integer!");
            sc.next();
        }
        int number = sc.nextInt();

        System.out.println("Please input the height of sequence: ");
        while (!sc.hasNextInt()) {
            System.out.println("Please input only integer!");
            sc.next();
        }
        int height = sc.nextInt();

        SequenceGenerator sequenceGenerator = new SequenceGenerator(number,height);
        ArrayList<String> arrayList = sequenceGenerator.generate();

        if (arrayList.get(0).equals("-1")) {
            System.out.println("Sorry! You can't generate the sequence fow numbers lower of 0");
        } else if (arrayList.get(0).equals("-2")) {
            System.out.println("If the height of your sequence is 0 or lower, there is nothing to generate!");
        } else {
            System.out.println("Here is your sequence!");
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println(arrayList.get(i));
            }
        }
    }
}
