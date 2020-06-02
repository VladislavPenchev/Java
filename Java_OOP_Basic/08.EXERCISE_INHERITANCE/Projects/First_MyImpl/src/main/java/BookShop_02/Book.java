package BookShop_02;

import java.math.BigDecimal;

public class Book {
    private String author;
    private String title;
    private BigDecimal price;

    public Book(String author, String title, BigDecimal price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }

        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        String[] authorsArgs = author.split("\\s+");
        if (Character.isDigit(authorsArgs[1].charAt(0))) {
            throw new IllegalArgumentException("Author not valid!");
        }

        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) == 0 || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

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
