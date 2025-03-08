package annualflowers.com.example;

import java.time.LocalDate;

  public class OrderFlowers {
    private int qty;
    private final AnnualFlowers db;

    public OrderFlowers() {
        db = new AnnualFlowers();
    }

    // Parse "flowername,quantity" format
    public void splitInput(String input) {
        String[] parts = input.split(",");
        
        if (parts.length == 2) {
            // Try to extract flower info
            String flower = parts[0].trim();
            qty = Integer.parseInt(parts[1].trim());
            
            // Update our flower details
            db.setFlowerName(flower);
            db.setFlowerPrice(db.getPrice(flower));
        }
    }

    // Figure out how much this order costs
               public double calculateTotalCost() {
                 return db.getFlowerPrice() * qty;
    }

    @Override
    public String toString() {
        LocalDate today = LocalDate.now();
        
        return String.format(
            "----------------------------\n" +
            "Purchase date: %s\n" +
            "Flower: %s\n" +
            "Quantity: %d\n" +
            "Price per stem: $%.2f\n" +
            "Total Cost: $%.2f\n" +
            "----------------------------",
            today,
            db.getFlowerName(),
            qty,
            db.getFlowerPrice(),
            calculateTotalCost()
        );
    }
}