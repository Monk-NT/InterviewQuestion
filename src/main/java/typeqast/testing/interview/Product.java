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

    public Product(Product p){
        this.name = p.name;
        this.price = p.price;
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

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof Product) {
                Product p = (Product) obj;
                 return this.name.equals(p.name);
            }
        }
        return false;
    }
}
