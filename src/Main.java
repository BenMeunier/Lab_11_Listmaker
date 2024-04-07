import java.util.ArrayList;
import java.util.Scanner;

class ListManager {
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printList();
            showMenu();
            String choice = getSafeInput("[AaDdPpQq]", "Choose an option: ");// choose option
            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    running = quitProgram();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");// Invalid force re entry
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nMenu Options:");// List options
        System.out.println("A – Add an item to the list");// To add
        System.out.println("D – Delete an item from the list");// To delete
        System.out.println("P – Print the list");// To print
        System.out.println("Q – Quit the program");// To quit
    }

    private static void addItem() {
        System.out.print("Enter Item: ");// Ask for item
        String item = scanner.nextLine();
        list.add(item);
    }

    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("There is nothing in the list");// Clarify nothing is on the list
            return;
        }
        printNumberedList();
        int itemNumber = getSafeRangedInt(1, list.size(), "How many items do you want to delete ");// Ask how many itmes they want deleted
        list.remove(itemNumber - 1);
    }

    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("There is nothing in the list");// Clarify nothing is on the list
        } else {
            System.out.println("Your List:");// Show list
            for (String item : list) {
                System.out.println(item);
            }
        }
    }

    private static boolean quitProgram() {
        return !getSafeYNConfirm("Do you wanna quit? (y/n): ");// Check if they want to quit
    }

    private static String getSafeInput(String pattern, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int getSafeRangedInt(int min, int max, String prompt) {
        return SafeInput.getRangedInt(scanner, prompt, min, max);
    }

    private static boolean getSafeYNConfirm(String prompt) {
        return SafeInput.getYNConfirm(scanner, prompt);
    }

    private static void printNumberedList() {
        int number = 1;
        for (String item : list) {
            System.out.println(number++ + ". " + item);
        }
    }
}
