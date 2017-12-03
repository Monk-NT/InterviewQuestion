package typeqast.testing.interview;

import java.math.BigDecimal;

/**
 * POJO representing single product
 */
public class Product {

    private String name;
    private BigDecimal price;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
