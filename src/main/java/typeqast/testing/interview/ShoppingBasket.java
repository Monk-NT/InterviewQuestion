package typeqast.testing.interview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Function;

/**
 * Class representing ShoppingBasket. Currently, discounts are represented as anonymus functions, since it's the most
 * elegant solution for the current constrains. However, this means that each shopping basket needs to have discounts
 * applied every time. This can be seen as a problem, but then again, some shops sometimes do apply special discounts
 * which depend form user to user.
 */
public class ShoppingBasket {

    private ArrayList<Product> products;
    private ArrayList<Function<ArrayList<Product>, ArrayList<Product>>> discounts;

    public ShoppingBasket(){
        this.products = new ArrayList<>();
        this.discounts = new ArrayList<>();
    }

    public void addProduct(Product p) {
        this.products.add(new Product(p));
    }

    public void addDiscount(Function<ArrayList<Product>,ArrayList<Product>> discount){
        this.discounts.add(discount);
    }

    public float getTotal(){
        float total = 0.0f;
        for (Function<ArrayList<Product>, ArrayList<Product>> f : discounts){
            products = f.apply(products);
        }
        for (Product p : products) total += p.getPrice();
        return total;
    }

}
