// Interface for enum implementation
interface Describable {
    String getDescription();
}

// Advanced Enum
enum OrderStatus implements Describable {

    PLACED("Order has been placed"),
    SHIPPED("Order is shipped"),
    DELIVERED("Order delivered successfully"),
    CANCELLED("Order was cancelled");

    private String description;

    // Constructor (always private)
    OrderStatus(String description) {
        this.description = description;
    }

    // Method inside enum
    public String getDescription() {
        return description;
    }
}

public class RealWorldEnumDemo {

    public static void main(String[] args) {

        // Basic usage
        OrderStatus status = OrderStatus.PLACED;

        System.out.println("Current Status: " + status);
        System.out.println("Description: " + status.getDescription());

        // Switch with enum
        switch (status) {
            case PLACED:
                System.out.println("Processing order...");
                break;
            case SHIPPED:
                System.out.println("In transit...");
                break;
            case DELIVERED:
                System.out.println("Order completed.");
                break;
            case CANCELLED:
                System.out.println("Order cancelled.");
                break;
        }

        System.out.println("\nAll Order Statuses:");

        // values() method
        for (OrderStatus s : OrderStatus.values()) {
            System.out.println(
                s.name() +
                " | Ordinal: " + s.ordinal() +
                " | Description: " + s.getDescription()
            );
        }

        // valueOf() method
        OrderStatus newStatus = OrderStatus.valueOf("SHIPPED");
        System.out.println("\nConverted from String: " + newStatus);
    }
}