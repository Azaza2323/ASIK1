import java.util.ArrayList;
import java.util.List;

class Shopping {
    private List<Product> products;
    private PaymentProcessor paymentProcessor;

    public Shopping() {
        this.products = new ArrayList<>();
    }

    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }

    public void checkout() {
        double total = calculateTotalPrice();
        if (paymentProcessor != null) {
            paymentProcessor.processPayment(total);
        } else {
            System.out.println("No payment processor set.");
        }
    }
}
public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.processPayment(amount);
        } else {
            System.out.println("No payment strategy set.");
        }
    }
}

