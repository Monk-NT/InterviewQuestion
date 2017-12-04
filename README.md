#Java job interview assignment
This is a simple job interview assignment task.

##Explanations
Although assignment text asked for "to show a good understanding of 
object oriented programming and SOLID principles" it also asked to code as if coding for myself.

This led me to following conclusions:
```Product``` and ```ShoppingBasket``` are straightforward. However, what is a Discount?

A discount is something that looks upon the ```ShoppingBasket``` state and changes it. This
something sounds exactly like a function! This led me to decision to use higher order functions
as discount description.

Of course, there were other ways to do this. For example, we could do something like this:
```java
interface IDiscount{
    /**
    * returns basket total after applying discount. 
    */
    BigDecimal applyDiscount(ShoppingBasket basket);
}
```
and then have concrete classes implementing each Discount. However, this sounds like something 
that is steering me away form my favorite principle: KISS.