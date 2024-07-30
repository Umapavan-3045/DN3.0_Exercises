interface PaymentHandler {
    void handlePayment(double amount);
}

class PayU {
    public void executePayment(double amount) {
        System.out.println("Processing payment of Rs." + amount + " through PayU.");
    }
}

class RazorPay {
    public void payAmount(double amount) {
        System.out.println("Processing payment of Rs." + amount + " through RazorPay.");
    }
}

class PhonePe {
    public void initiateTransaction(double amount) {
        System.out.println("Processing payment of Rs." + amount + " through PhonePe.");
    }
}

class PayUAdapter implements PaymentHandler {
    private PayU payU;

    public PayUAdapter(PayU payU) {
        this.payU = payU;
    }

    public void handlePayment(double amount) {
        payU.executePayment(amount);
    }
}

class RazorPayAdapter implements PaymentHandler {
    private RazorPay razorPay;

    public RazorPayAdapter(RazorPay razorPay) {
        this.razorPay = razorPay;
    }

    public void handlePayment(double amount) {
        razorPay.payAmount(amount);
    }
}

class PhonePeAdapter implements PaymentHandler {
    private PhonePe phonePe;

    public PhonePeAdapter(PhonePe phonePe) {
        this.phonePe = phonePe;
    }

    public void handlePayment(double amount) {
        phonePe.initiateTransaction(amount);
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        PayU payU = new PayU();
        RazorPay razorPay = new RazorPay();
        PhonePe phonePe = new PhonePe();
        
        PaymentHandler payUAdapter = new PayUAdapter(payU);
        PaymentHandler razorPayAdapter = new RazorPayAdapter(razorPay);
        PaymentHandler phonePeAdapter = new PhonePeAdapter(phonePe);
        
        payUAdapter.handlePayment(150.00);
        razorPayAdapter.handlePayment(250.00);
        phonePeAdapter.handlePayment(350.00);
    }
}
