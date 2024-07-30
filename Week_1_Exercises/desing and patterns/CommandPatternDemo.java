interface Action {
    void perform();
}

// Implement Concrete Commands
class TurnLightOn implements Action {
    private Bulb bulb;

    public TurnLightOn(Bulb bulb) {
        this.bulb = bulb;
    }

    @Override
    public void perform() {
        bulb.switchOn();
    }
}

class TurnLightOff implements Action {
    private Bulb bulb;

    public TurnLightOff(Bulb bulb) {
        this.bulb = bulb;
    }

    @Override
    public void perform() {
        bulb.switchOff();
    }
}

// Implement Receiver Class
class Bulb {
    public void switchOn() {
        System.out.println("The light is on");
    }

    public void switchOff() {
        System.out.println("The light is off");
    }
}

// Implement Invoker Class
class Controller {
    private Action action;

    public void setAction(Action action) {
        this.action = action;
    }

    public void pressButton() {
        action.perform();
    }
}

// Test the Command Implementation
public class CommandPatternDemo {
    public static void main(String[] args) {
        Bulb roomLight = new Bulb();

        Action turnOn = new TurnLightOn(roomLight);
        Action turnOff = new TurnLightOff(roomLight);

        Controller controller = new Controller();

        // Turn the light on
        controller.setAction(turnOn);
        controller.pressButton();

        // Turn the light off
        controller.setAction(turnOff);
        controller.pressButton();
    }
}
