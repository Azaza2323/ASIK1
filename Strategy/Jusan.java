public class Jusan implements PaymentStrategy {
    private String ITN;

    public Jusan(String ITN) {
        this.ITN = ITN;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Jusan payment in Tenge:" + amount);
    }
}
