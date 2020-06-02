package ShoppingSpree_fd_4;

public class Product {

    private static final String INVALID_NAME_EXECEPTION_MESSAGE = "Name cannot be empty";

    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name.trim().isEmpty()|| name.equals(null)){
            throw new IllegalArgumentException(this.INVALID_NAME_EXECEPTION_MESSAGE);
        }
        this.name = name;
    }

    public double getCost() {
        return this.cost;
    }

}
