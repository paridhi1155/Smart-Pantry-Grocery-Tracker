import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class PantryManager {

    private ArrayList<GroceryItem> groceryList;
    private Scanner input;

    public PantryManager() {
        groceryList = new ArrayList<GroceryItem>();
        input = new Scanner(System.in);
    }

    public void addItem() {

        System.out.print("Enter item name: ");
        String itemName = input.nextLine();

        System.out.print("Enter category: ");
        String category = input.nextLine();

        System.out.print("Enter quantity: ");
        double quantity = input.nextDouble();

        System.out.print("Enter price: ");
        double price = input.nextDouble();
        input.nextLine();

        System.out.print("Enter expiry date (YYYY-MM-DD): ");
        String dateText = input.nextLine();

        LocalDate expiryDate = LocalDate.parse(dateText);

        GroceryItem newItem = new GroceryItem(
                itemName,
                category,
                quantity,
                price,
                expiryDate
        );

        groceryList.add(newItem);

        System.out.println("Grocery item added successfully!");

        newItem.showExpiryAlert();
    }

    public void viewItems() {

        if (groceryList.isEmpty()) {
            System.out.println("The pantry is empty.");
            return;
        }

        System.out.println("\n----- Pantry Items -----");

        for (GroceryItem item : groceryList) {
            item.showDetails();
            item.showExpiryAlert();
        }
    }

    public void searchItem() {

        System.out.print("Enter item name to search: ");
        String searchText = input.nextLine();

        boolean itemFound = false;

        for (GroceryItem item : groceryList) {

            if (item.itemName.equalsIgnoreCase(searchText)) {
                item.showDetails();
                item.showExpiryAlert();
                itemFound = true;
            }
        }

        if (!itemFound) {
            System.out.println("No matching item found.");
        }
    }

    public void removeItem() {

        System.out.print("Enter item name to remove: ");
        String removeText = input.nextLine();

        boolean itemRemoved = false;

        for (int i = 0; i < groceryList.size(); i++) {

            GroceryItem item = groceryList.get(i);

            if (item.itemName.equalsIgnoreCase(removeText)) {
                groceryList.remove(i);
                itemRemoved = true;

                System.out.println("Item removed successfully.");
                break;
            }
        }

        if (!itemRemoved) {
            System.out.println("No matching item found.");
        }
    }

    public ArrayList<GroceryItem> getGroceryList() {
        return groceryList;
    }
}