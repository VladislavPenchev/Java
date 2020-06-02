package Examples_00;

public class Main {
    public static void main(String[] args) {
        MyEnum[] enums = MyEnum.values();

        for (MyEnum myEnum : enums) {
            System.out.println(myEnum.ordinal());
        }
    }
}
