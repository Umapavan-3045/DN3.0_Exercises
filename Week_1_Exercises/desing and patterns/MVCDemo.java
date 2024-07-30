class Pupil {
    private String rollNumber;
    private String fullName;
    private String mark;

    public Pupil(String rollNumber, String fullName, String mark) {
        this.rollNumber = rollNumber;
        this.fullName = fullName;
        this.mark = mark;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}

// Define View Class
class PupilView {
    public void showPupilDetails(String pupilName, String pupilRollNumber, String pupilMark) {
        System.out.println("Pupil Details:");
        System.out.println("Name: " + pupilName);
        System.out.println("Roll Number: " + pupilRollNumber);
        System.out.println("Mark: " + pupilMark);
    }
}

// Define Controller Class
class PupilController {
    private Pupil model;
    private PupilView view;

    public PupilController(Pupil model, PupilView view) {
        this.model = model;
        this.view = view;
    }

    public void setPupilName(String name) {
        model.setFullName(name);
    }

    public String getPupilName() {
        return model.getFullName();
    }

    public void setPupilRollNumber(String rollNumber) {
        model.setRollNumber(rollNumber);
    }

    public String getPupilRollNumber() {
        return model.getRollNumber();
    }

    public void setPupilMark(String mark) {
        model.setMark(mark);
    }

    public String getPupilMark() {
        return model.getMark();
    }

    public void refreshView() {
        view.showPupilDetails(model.getFullName(), model.getRollNumber(), model.getMark());
    }
}

// Test the MVC Implementation
public class MVCDemo {
    public static void main(String[] args) {
        // Create a Pupil model
        Pupil model = new Pupil("101", "Alice Smith", "A+");

        // Create a Pupil view
        PupilView view = new PupilView();

        // Create a Pupil controller
        PupilController controller = new PupilController(model, view);

        // Display initial pupil details
        controller.refreshView();

        // Update pupil details
        controller.setPupilName("Bob Johnson");
        controller.setPupilMark("B");

        // Display updated pupil details
        controller.refreshView();
    }
}
