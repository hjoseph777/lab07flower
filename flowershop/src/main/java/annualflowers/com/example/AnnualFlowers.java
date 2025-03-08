package annualflowers.com.example;

public class AnnualFlowers {
    // Quick lookup table for flower info
    private final String[][] flowers = {
        // Name, Price
        {"Marigold", "2.30"},
        {"Pansy", "1.50"},
        {"Zinnias", "5.12"},
        {"Petunia", "3.25"}
    };

    private String name;    // Current flower name
    private double price;   // Current flower price

    // Basic getters/setters
    public String getFlowerName() { return name; }
    public void setFlowerName(String name) { this.name = name; }
    public double getFlowerPrice() { return price; }
     public void setFlowerPrice(double price) { this.price = price; }

    // Lookup price for a specific flower
        public double getPrice(String flowerName) {
        // Loop through our flower list
        for (String[] flower : flowers) {
            if (flower[0].equalsIgnoreCase(flowerName)) {
                return Double.parseDouble(flower[1]);
            }
        }
        
        // Nothing found
        return 0.0;
    }

     @Override
       public String toString() {
        // Build a nice formatted list of flowers
        StringBuilder list = new StringBuilder("Available Flowers:\n");
        
        for (String[] flower : flowers) {
            list.append(flower[0])
                .append(" - $")
                .append(flower[1])
                .append(" per stem\n");
        }
        
        return list.toString();
    }
}