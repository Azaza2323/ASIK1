public class KaspiCard implements PaymentStrategy {
    private String kaspiNumber;
    private int cvv;
    public KaspiCard(String kaspiNumber,int cvv) {
        this.kaspiNumber = kaspiNumber;
        this.cvv=cvv;
    }
    @Override
    public void processPayment(double amount) {
    System.out.println("Kaspi payment in Tenge:" + amount);
    }
}
