package BookShop_fd_2;

public class Book {
    private static final String INVALID_SECOND_NAME_START_DIGIT_EXCEPTION_MESSAGE = "Author not valid!";
    private static final String INVALID_TITLE_LESS_THEN_3_EXCEPTION_MESSAGE = "Title not valid!";
    private static final String INVALID_PRICE_NOT_NEGATIVE_OR_ZERO_EXCEPTION_MESSAGE = "Price not valid!";

    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    private String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        if(title.length() < 3)
            throw new IllegalArgumentException(this.INVALID_TITLE_LESS_THEN_3_EXCEPTION_MESSAGE);
        this.title = title;
    }

    private String getAuthor() {
        return this.author;
    }

    private void setAuthor(String author) {

        if(Character.isDigit(this.getSecondName(author).charAt(0)))
            throw new IllegalArgumentException(this.INVALID_SECOND_NAME_START_DIGIT_EXCEPTION_MESSAGE);

        this.author = author;
    }

    protected double getPrice() {
        return this.price;
    }

    protected void setPrice(double price) {
        if(price < 1)
            throw new IllegalArgumentException(this.INVALID_PRICE_NOT_NEGATIVE_OR_ZERO_EXCEPTION_MESSAGE);
        this.price = price;
    }

    private String getSecondName(String authorName){
        int startIndexOfSecondName = authorName.indexOf(" ");

        String result = authorName.substring(startIndexOfSecondName + 1);


     return result;
    }
//
//    @Override
//    public String toString() {
//        StringBuilder book = new StringBuilder();
//
//        book.append(String.format("Type: %s",this.getClass().getSimpleName()))
//                .append(System.lineSeparator())
//                .append(String.format("Title: %s",this.getTitle()))
//                .append(System.lineSeparator())
//                .append(String.format("Author %s",this.getAuthor()))
//                .append(System.lineSeparator())
//                .append(String.format("Price: %1.f",this.getPrice()))
//                .append(System.lineSeparator());
//
//        return book.toString();

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Type: ").append(this.getClass().getSimpleName())
                    .append(System.lineSeparator())
                    .append("Title: ").append(this.getTitle())
                    .append(System.lineSeparator())
                    .append("Author: ").append(this.getAuthor())
                    .append(System.lineSeparator())
                    .append("Price: ").append(this.getPrice())
                    .append(System.lineSeparator());
            return sb.toString();
    }
}
