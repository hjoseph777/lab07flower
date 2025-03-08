package annualflowers.com.example;

 public class FlowerOrderManager {
    // Store up to 10 customer orders
    private final int[][] orders = new int[10][4];
    private int numOrders = 0;
    
    // Keep track of our flower info
    private final AnnualFlowers flowerDb;
    private final String[] flowerTypes = {
        "Marigold", "Pansy", "Zinnias", "Petunia"
    };

    public FlowerOrderManager() {
        flowerDb = new AnnualFlowers();
    }

          public boolean addOrder(String orderInput) {
        // Check if we're full
        if (numOrders >= 10) {
            System.out.println("Sorry, we're at max capacity! Can't take more orders.");
            return false;
        }

        try {
            // Split the input into quantities
            String[] nums = orderInput.split(",");
            
            // Reset this order slot
            for (int i = 0; i < 4; i++) {
                orders[numOrders][i] = 0;
            }

            // Fill in whatever quantities were provided
            for (int i = 0; i < nums.length && i < 4; i++) {
                orders[numOrders][i] = Integer.parseInt(nums[i].trim());
            }

            numOrders++;
            return true;

        } catch (NumberFormatException e) {
            System.out.println("Oops! Numbers only please!");
            return false;
        }
    }

    // Get total quantities for each flower type
    public int[] getMergedOrders() {
        int[] totals = new int[4];
        
        for (int i = 0; i < 4; i++) {
            totals[i] = StringUtility.getColumnTotal(orders, i);
        }
        
        return totals;
    }

    // Calculate cost breakdown by flower type
    public double[] calculateCostPerFlowerType() {
        int[] totals = getMergedOrders();
        double[] costs = new double[4];

        for (int i = 0; i < 4; i++) {
            costs[i] = totals[i] * flowerDb.getPrice(flowerTypes[i]);
        }

        return costs;
    }

    // Generate a nice summary of all orders
    public String generateOrderSummary() {
        int[] totals = getMergedOrders();
        double[] costs = calculateCostPerFlowerType();

        FlowerOrderOutputFormatter formatter = new FlowerOrderOutputFormatter(
            flowerTypes, orders, totals, costs, numOrders);

        return formatter.formatOrderSummary();
    }

    // Basic getters
    public int getCustomerCount() { return numOrders; }
    public int[][] getCustomerOrders() { return orders; }
}