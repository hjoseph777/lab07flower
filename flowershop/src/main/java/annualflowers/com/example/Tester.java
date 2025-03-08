package annualflowers.com.example;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FlowerOrderManager orders = new FlowerOrderManager();
        
        showWelcome();
        processOrders(input, orders);
        
        System.out.println("\n" + orders.generateOrderSummary());
        input.close();
    }
    
    private static void processOrders(Scanner input, FlowerOrderManager orders) {
        while (true) {
            String userInput = promptForOrder(input);
            
              if (userInput.equalsIgnoreCase("exit")) {
                break;
            }
            
            if (!orders.addOrder(userInput)) {
                System.out.println("Whoops! Something went wrong. Give it another shot.");
                // TODO: Maybe add retry logic here later
            }
        }
    }
    
    private static String promptForOrder(Scanner input) {
        System.out.print("\nEnter flower order (Marigold,Pansy,Zinnias,Petunia): ");
        return input.nextLine().trim();
    }

    private static void showWelcome() {
        System.out.println("Welcome to the Flower Shop Order Management System!");
        System.out.println("Available flowers: Marigold, Pansy, Zinnias, Petunia");
        System.out.println("Enter quantities for each flower type separated by commas.");
        System.out.println("Example: 2,3,1,5 means 2 Marigold, 3 Pansy, 1 Zinnias, 5 Petunia");
        System.out.println("You can enter partial orders (e.g., 2,3) and missing values will be 0.");
        System.out.println("Type 'exit' when you're done.\n");
    }
}
