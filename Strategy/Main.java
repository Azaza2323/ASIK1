import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shopping cart = new Shopping();
        while (true) {
            System.out.println("Choose a product:");
            System.out.println("1. Laptop");
            System.out.println("2. Phone");
            System.out.println("0. Done");
            int productChoice = scanner.nextInt();
            if (productChoice == 0) {
                break;
            }
            String productName = "";
            double productPrice = 0;
            switch (productChoice) {
                case 1:
                    productName = "Laptop";
                    productPrice = 1000;
                    break;
                case 2:
                    productName = "Phone";
                    productPrice = 500;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    continue; // Restart the loop for invalid choice
            }
            System.out.println("Product chosen: " + productName + ", Price: " + productPrice);
            System.out.println("Enter quantity (type 0 to cancel): ");
            int quantity = scanner.nextInt();
            if (quantity == 0) {
                break;
            }
            Product product = new Product(productName, productPrice, quantity);
            cart.addProduct(product);
        }

        System.out.println("Select a payment:");
        System.out.println("1. Kaspi Bank");
        System.out.println("2. Jusan Bank");

        int choice = scanner.nextInt();
        PaymentStrategy paymentStrategy = null;
        switch (choice) {
            case 1:
                // Credit Card payment strategy
                System.out.println("Enter card numbers:");
                String Number=scanner.next();
                System.out.println("Enter card cvv(3 symbols):");
                int cvv=scanner.nextInt();
                paymentStrategy = new KaspiCard(Number,cvv);
                break;
            case 2:
                System.out.println("Enter Jusan ITN(12 symbols):");
                String ITN=scanner.next();
                paymentStrategy = new Jusan(ITN);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                System.exit(0);
        }
        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentStrategy);
        cart.setPaymentProcessor(paymentProcessor);
        cart.checkout();
        scanner.close();
    }
}
