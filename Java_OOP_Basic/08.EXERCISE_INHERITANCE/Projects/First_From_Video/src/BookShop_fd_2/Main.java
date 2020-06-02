package BookShop_fd_2;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String author = scanner.nextLine();
            String title = scanner.nextLine();
            double price = Double.valueOf(scanner.nextLine());

            Book book = new Book(title, author, price);

            GoldenEditionBook goldenEditionBook =
                    new GoldenEditionBook(
                            title,
                            author,
                            price);

            Method[] goldenBookDeclaredMethods =
                    GoldenEditionBook.class.getDeclaredMethods();

            if (goldenBookDeclaredMethods.length > 1) {
                throw new IllegalClassFormatException(
                        "Code duplication in GoldenEditionBook!");
            }

            System.out.println(book.toString());
            System.out.println(goldenEditionBook.toString());

        } catch (IllegalArgumentException | IllegalClassFormatException error) {
            System.out.println(error.getMessage());
        }

    }
}
