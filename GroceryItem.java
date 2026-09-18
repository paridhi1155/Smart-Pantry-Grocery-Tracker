import java.time.LocalDate;

public class GroceryItem {

    String itemName;
    String category;
    double quantity;
    double price;
    LocalDate expiryDate;

    public GroceryItem(String itemName, String category,
                       double quantity, double price,
                       LocalDate expiryDate) {

        this.itemName = itemName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public void showDetails() {

        String expiryStatus =
                ExpiryChecker.getExpiryStatus(expiryDate);

        System.out.println(
            "Item: " + itemName +
            " | Category: " + category +
            " | Quantity: " + quantity +
            " | Price: Rs. " + price +
            " | Expiry: " + expiryDate +
            " | Status: " + expiryStatus
        );
    }

    public void showExpiryAlert() {
        ExpiryChecker.displayExpiryAlert(itemName, expiryDate);
    }
}