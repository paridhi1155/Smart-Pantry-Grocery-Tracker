import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ExpiryChecker {

    public static String getExpiryStatus(LocalDate expiryDate) {

        LocalDate today = LocalDate.now();

        long daysLeft = ChronoUnit.DAYS.between(today, expiryDate);

        if (daysLeft < 0) {
            return "Expired";
        } else if (daysLeft <= 3) {
            return "Expiring Soon";
        } else {
            return "Fresh";
        }
    }

    public static void displayExpiryAlert(String itemName, LocalDate expiryDate) {

        LocalDate today = LocalDate.now();

        long daysLeft = ChronoUnit.DAYS.between(today, expiryDate);

        if (daysLeft < 0) {
            System.out.println("ALERT: " + itemName + " has expired!");
        } else if (daysLeft <= 3) {
            System.out.println(
                "WARNING: " + itemName +
                " will expire in " + daysLeft + " day(s)."
            );
        }
    }
}