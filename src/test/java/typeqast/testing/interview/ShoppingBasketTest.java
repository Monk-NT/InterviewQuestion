package typeqast.testing.interview;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ShoppingBasketTest {
    private ShoppingBasket basket;
    private Product butter;
    private Product milk;
    private Product bread;


    @Before
    public void setUp() {
        basket = new ShoppingBasket();
        butter = new Product("Butter");
        butter.setPrice(new BigDecimal(0.8));
        milk = new Product("Milk");
        milk.setPrice(new BigDecimal(1.15));
        bread = new Product("Bread");
        bread.setPrice(new BigDecimal(1.0));

        basket.addDiscount(this::milkDiscount);
    }

    @Test
    public void noAppliedDiscountsTest() {
        basket.addProduct(butter);
        basket.addProduct(milk);
        basket.addProduct(bread);

        assertEquals(new BigDecimal(2.95),basket.getTotal());
    }

    @Test
    public void noProductsTest() {
        assertEquals(new BigDecimal(0),basket.getTotal());
    }

    @Test
    public void withAppliedDiscount(){
        basket.addProduct(milk);
        basket.addProduct(milk);
        basket.addProduct(milk);
        basket.addProduct(milk);
        basket.addProduct(milk);
        basket.addProduct(milk);
        basket.addProduct(milk);

        assertEquals(new BigDecimal(6.9),basket.getTotal());

    }

    private ArrayList<Product> milkDiscount(ArrayList<Product> products){
        int milkCount = 0;
        ArrayList<Product> discountedProducts = new ArrayList<>();
        for (Product p : products) {
            if (p.equals(milk)){
                milkCount++;
                if (milkCount > 3 && milkCount % 3 == 1 ){
                    p.setPrice(new BigDecimal(0));
                }
            }
            discountedProducts.add(p);
        }
        return discountedProducts;
    }

}