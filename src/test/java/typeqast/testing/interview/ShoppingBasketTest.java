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

    final static private float EPSILON = 1e-3f;


    @Before
    public void setUp() {
        basket = new ShoppingBasket();
        butter = new Product("Butter");
        butter.setPrice(0.8f);
        milk = new Product("Milk");
        milk.setPrice(1.15f);
        bread = new Product("Bread");
        bread.setPrice(1.0f);

        basket.addDiscount(this::milkDiscount);
    }

    @Test
    public void noAppliedDiscountsTest() {
        basket.addProduct(butter);
        basket.addProduct(milk);
        basket.addProduct(bread);

        assertEquals(2.95f,basket.getTotal(),EPSILON);
    }

    @Test
    public void noProductsTest() {
        assertEquals(0f,basket.getTotal(),EPSILON);
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

        assertEquals(6.9f,basket.getTotal(),EPSILON);

    }

    /**
     * This is a basic example of discount function.
     * @param products - product list
     * @return mutated products
     */
    private ArrayList<Product> milkDiscount(ArrayList<Product> products){
        int milkCount = 0;
        ArrayList<Product> discountedProducts = new ArrayList<>();
        for (Product p : products) {
            if (p.equals(milk)){
                milkCount++;
                if (milkCount > 3 && milkCount % 3 == 1 ){
                    p.setPrice(0f);
                }
            }
            discountedProducts.add(p);
        }
        return discountedProducts;
    }

}