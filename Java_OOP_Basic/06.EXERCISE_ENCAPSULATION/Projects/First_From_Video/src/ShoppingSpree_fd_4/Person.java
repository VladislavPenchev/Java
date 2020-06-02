package ShoppingSpree_fd_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private static final String INVALID_NAME_EXECEPTION_MESSAGE = "Name cannot be empty";
    private static final String INVALID_MONEY_EXECEPTION_MESSAGE = "Money cannot be negative";
    private static final String INVALID_CANT_AFFORD_EXECEPTION_MESSAGE = "%s can't afford %s";

    private String name;
    private double money;
    List<Product> bagOfProducts;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<Product>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if(name.trim().isEmpty()|| name.equals(null))
            throw new IllegalArgumentException(this.INVALID_NAME_EXECEPTION_MESSAGE);
        this.name = name;
    }

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) {
        if(money < 0)
            throw new IllegalArgumentException(this.INVALID_MONEY_EXECEPTION_MESSAGE);
        this.money = money;
    }

    public List<Product> getBagOfProducts() {
        return this.bagOfProducts;
    }

    public void setBagOfProducts(Product product) {
        this.bagOfProducts.add(product);
    }


    public void checkIsAffordToBuy(double costOfProduct, String nameOfProduct){
        if(this.getMoney() >= costOfProduct){
            this.setMoney(this.getMoney() - costOfProduct);
        }else{
            throw new IllegalArgumentException(String.format(this.INVALID_CANT_AFFORD_EXECEPTION_MESSAGE,this.getName(),nameOfProduct));
        }
    }

    @Override
    public String toString() {

        String result = String.format("%s - %s",
                this.getName(),
                this.getBagOfProducts().size() == 0 ?
                "Nothing bought" :
                this.getBagOfProducts().stream().map(Product::getName)
                        .collect(Collectors.joining(", ")));

        return result;
    }
}
