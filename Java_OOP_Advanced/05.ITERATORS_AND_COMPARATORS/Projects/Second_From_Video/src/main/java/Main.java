public class Main {
    public static void main(String[] args) {
        print("dsa");
        print("dsa", "dsa");
        print("dsa");
    }

    public static void print(String... values) {
        for(String value : values) {
            System.out.println(value);
        }
    }
}
