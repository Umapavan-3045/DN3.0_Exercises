interface Messenger {
    void notify(String message);
}

class MailMessenger implements Messenger {
    public void notify(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

abstract class MessengerDecorator implements Messenger {
    protected Messenger messenger;

    public MessengerDecorator(Messenger messenger) {
        this.messenger = messenger;
    }

    public void notify(String message) {
        messenger.notify(message);
    }
}

class TextMessengerDecorator extends MessengerDecorator {
    public TextMessengerDecorator(Messenger messenger) {
        super(messenger);
    }

    public void notify(String message) {
        messenger.notify(message);
        sendText(message);
    }

    private void sendText(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}

class TeamsMessengerDecorator extends MessengerDecorator {
    public TeamsMessengerDecorator(Messenger messenger) {
        super(messenger);
    }

    public void notify(String message) {
        messenger.notify(message);
        sendTeams(message);
    }

    private void sendTeams(String message) {
        System.out.println("Sending Teams notification: " + message);
    }
}

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Messenger mailMessenger = new MailMessenger();
        Messenger textMessenger = new TextMessengerDecorator(mailMessenger);
        Messenger teamsMessenger = new TeamsMessengerDecorator(textMessenger);

        teamsMessenger.notify("Hello, this is a test notification!");
    }
}
