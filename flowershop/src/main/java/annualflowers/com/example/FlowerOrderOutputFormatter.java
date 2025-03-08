package annualflowers.com.example;

 import java.time.LocalDate;

public class FlowerOrderOutputFormatter {
    private final String[] flowers;
    private final int[][] orders;
    private final int[] totals;
    private final double[] costs;
    private final int orderCount;

      public FlowerOrderOutputFormatter(String[] flowerTypes, int[][] customerOrders,
            int[] mergedOrders, double[] costs, int customerCount) {
        this.flowers = flowerTypes;
        this.orders = customerOrders;
        this.totals = mergedOrders;
        this.costs = costs;
        this.orderCount = customerCount;
    }

      public String formatOrderSummary() {
        StringBuilder output = new StringBuilder();
        appendHeader(output);
        appendFlowerSummary(output);
        appendCombinedOrders(output);
        appendTotalCost(output);
        return output.toString();
    }

       private void appendHeader(StringBuilder output) {
        output.append("Order Date: ")
              .append(LocalDate.now())
              .append("\n\nOrder Summary:\n\n");
    }

       private void appendFlowerSummary(StringBuilder output) {
        for (int i = 0; i < flowers.length; i++) {
            output.append(flowers[i])
                  .append("\nTotal Stems: ")
                  .append(totals[i])
                  .append("\n\n");
        }
    }

    private void appendCombinedOrders(StringBuilder output) {
        output.append("=============================\n");
        output.append("Combined Order Details\n");
        output.append("=============================\n\n");

        for (int i = 0; i < flowers.length; i++) {
            output.append(flowers[i]).append(":\n");
            for (int customer = 0; customer < orderCount; customer++) {
                if (orders[customer][i] > 0) {
                    output.append("  Customer ").append(customer + 1)
                          .append(": ").append(orders[customer][i])
                          .append(" stems\n");
                }
            }
            output.append("\n");
        }
    }

    private void appendTotalCost(StringBuilder output) {
        double totalCost = 0;
        for (double cost : costs) {
            totalCost += cost;
        }
        
        output.append("-----------------------------\n");
        output.append(String.format("Total Order Cost: $%.2f\n", totalCost));
        output.append("Number of Customers: ").append(orderCount);
    }
}
