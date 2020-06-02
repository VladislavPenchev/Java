import implementations.SinglyLinkedList;
import interfaces.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> test = new SinglyLinkedList<>();

        test.addFirst(1);
        test.addFirst(2);
        test.addLast(3);
    }
}
