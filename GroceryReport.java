import java.util.ArrayList;

public class GroceryReport {

    public void showReport(ArrayList<GroceryItem> groceryList) {

        System.out.println("\n----- Grocery Report -----");

        if (groceryList.isEmpty()) {
            System.out.println("No grocery items available.");
            return;
        }

        int totalItems = groceryList.size();
        double totalValue = 0;
        int expiredItems = 0;
        int soonExpiringItems = 0;

        for (GroceryItem item : groceryList) {

            totalValue = totalValue +
                    (item.quantity * item.price);

            String status =
                    ExpiryChecker.getExpiryStatus(item.expiryDate);

            if (status.equals("Expired")) {
                expiredItems++;
            } else if (status.equals("Expiring Soon")) {
                soonExpiringItems++;
            }
        }

        System.out.println("Total items: " + totalItems);
        System.out.println("Estimated grocery value: Rs. " + totalValue);
        System.out.println("Expired items: " + expiredItems);
        System.out.println("Items expiring soon: " + soonExpiringItems);
    }
}