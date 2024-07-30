// Step 2: Define Strategy Interface
interface PaymentMethod {
    void processPayment(double amount);
}

// Step 3: Implement Concrete Strategies
class CardPayment implements PaymentMethod {
    private String cardHolder;
    private String cardNumber;
    private String securityCode;
    private String expirationDate;

    public CardPayment(String cardHolder, String cardNumber, String securityCode, String expirationDate) {
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
    }

    public void processPayment(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalMethod implements PaymentMethod {
    private String userEmail;
    private String userPassword;

    public PayPalMethod(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public void processPayment(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

// Step 4: Implement Context Class
class PaymentService {
    private PaymentMethod paymentMethod;

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void executePayment(double amount) {
        paymentMethod.processPayment(amount);
    }
}

// Step 5: Test the Strategy Implementation
public class StrategyPatternDemo {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        // Pay using Credit Card
        paymentService.setPaymentMethod(new CardPayment("Jane Doe", "6543210987654321", "456", "11/25"));
        paymentService.executePayment(150.0);

        // Pay using PayPal
        paymentService.setPaymentMethod(new PayPalMethod("jane.doe@example.com", "securePassword"));
        paymentService.executePayment(250.0);
    }
}
