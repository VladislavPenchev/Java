package Examples_00;

public enum  MyEnum {
    DAY, NIGHT;


    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
