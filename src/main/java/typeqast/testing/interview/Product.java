package typeqast.testing.interview;

import java.math.BigDecimal;

/**
 * POJO representing single product
 */
public class Product {

    private String name;
    private float price;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
