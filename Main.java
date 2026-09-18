import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PantryManager manager = new PantryManager();
        GroceryReport report = new GroceryReport();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("   SMART PANTRY & GROCERY TRACKER");
            System.out.println("====================================");
            System.out.println("1. Add Grocery Item");
            System.out.println("2. View All Items");
            System.out.println("3. Search Item");
            System.out.println("4. Remove Item");
            System.out.println("5. Show Grocery Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    manager.addItem();
                    break;

                case 2:
                    manager.viewItems();
                    break;

                case 3:
                    manager.searchItem();
                    break;

                case 4:
                    manager.removeItem();
                    break;

                case 5:
                    report.showReport(manager.getGroceryList());
                    break;

                case 6:
                    System.out.println(
                        "Thank you for using Smart Pantry Tracker!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please enter a number from 1 to 6."
                    );
            }

        } while (choice != 6);

        scanner.close();
    }
}