package BookShop_02;

import java.math.BigDecimal;

public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String author, String title, BigDecimal price) {
        super(title, author, price);
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal golderPrice = super.getPrice();
        BigDecimal thirtyPercentOfGoldenPrice = golderPrice.multiply(new BigDecimal(30)).divide(new BigDecimal(100));
        BigDecimal result = golderPrice.add(thirtyPercentOfGoldenPrice);
        return result;
    }
}
