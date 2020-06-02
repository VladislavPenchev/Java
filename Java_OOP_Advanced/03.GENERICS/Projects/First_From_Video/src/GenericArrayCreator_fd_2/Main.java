package GenericArrayCreator_fd_2;

public class Main {
    public static void main(String[] args) {

        String[] arr = ArrayCreator.create(String.class, 10, "Stringa");

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
