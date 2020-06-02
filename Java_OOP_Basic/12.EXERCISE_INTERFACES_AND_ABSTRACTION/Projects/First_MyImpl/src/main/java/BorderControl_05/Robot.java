package BorderControl_05;

public class Robot extends BaseEntity{
    private String model;

    public Robot(String id, String model) {
        super(id);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
