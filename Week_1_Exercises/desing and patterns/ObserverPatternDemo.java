import java.util.ArrayList;
import java.util.List;

interface Subject {
    void addObserver(Subscriber s);
    void removeObserver(Subscriber s);
    void notifySubscribers();
}

class Market implements Subject {
    private List<Subscriber> subscribers;
    private double price;

    public Market() {
        this.subscribers = new ArrayList<>();
    }

    public void addObserver(Subscriber s) {
        subscribers.add(s);
    }

    public void removeObserver(Subscriber s) {
        subscribers.remove(s);
    }

    public void notifySubscribers() {
        for (Subscriber s : subscribers) {
            s.update(price);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifySubscribers();
    }
}

interface Subscriber {
    void update(double price);
}

class MobileClient implements Subscriber {
    private String clientName;

    public MobileClient(String clientName) {
        this.clientName = clientName;
    }

    public void update(double price) {
        System.out.println(clientName + " received price update: " + price);
    }
}

class WebClient implements Subscriber {
    private String clientName;

    WebClient(String clientName) {
        this.clientName = clientName;
    }

    public void update(double price) {
        System.out.println(clientName + " received price update: " + price);
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Market market = new Market();

        Subscriber mobileClient = new MobileClient("MobileClient");
        Subscriber webClient = new WebClient("WebClient");

        market.addObserver(mobileClient);
        market.addObserver(webClient);

        market.setPrice(100.00);
        market.setPrice(101.50);

        market.removeObserver(webClient);
        market.setPrice(102.75);
    }
}
