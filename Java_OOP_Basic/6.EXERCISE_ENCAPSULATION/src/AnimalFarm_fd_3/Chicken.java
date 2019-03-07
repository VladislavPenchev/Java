package AnimalFarm_fd_3;

public class Chicken {
    private static final String INVALID_NAME_EXCEPTION_MESSAGE = "Name cannot be empty.";
    private static final String INVALID_AGE_EXCEPTION_MESSAGE = "Age should be between 0 and 15.";

    private String name;
    private int age;
    private String productPerDay;

    public Chicken(String name, int age) {
       this.setName(name);
       this.setAge(age);
    }


    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if(name.equals(null) || name.trim().isEmpty()){
            throw new IllegalArgumentException(this.INVALID_NAME_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if(age < 0 || age > 15){
            throw new IllegalArgumentException(this.INVALID_AGE_EXCEPTION_MESSAGE);
        }
        this.age = age;
    }

    public String getproductPerDay() {
        this.calculateProductPerDay();
        return this.productPerDay;
    }

    private void setProductPerDay(String productPerDay) {
        this.productPerDay = productPerDay;
    }

    private void calculateProductPerDay(){
        if(this.getAge() >= 0 && this.getAge() <= 5){
            this.setProductPerDay("2");
        }else if(this.getAge() >= 6 && this.getAge() <= 11){
            this.setProductPerDay("1");
        }else{
            this.setProductPerDay("0.75");
        }
    }

    @Override
    public String toString() {

        String result = String.format("Chicken %s (age %d) can produce %s eggs per day.",this.getName(),this.getAge(),this.getproductPerDay());


        return result;
    }
}
