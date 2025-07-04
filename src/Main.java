import entity.*;
import exception.GlobalSystemException;
import service.CheckoutService;

import java.util.Date;

public class Main {

    private static final String PASSWORD_LOGIN = "2011";

    public static void main(String[] args) {
        /*
         * =======================================
         *  NOTE: This logic it is just simulate
         *  a real shaping in a e-commerce, and the
         *  exception is :
                Exception in thread "main" exception.GlobalSystemException: Customer:checkPassword invalid credentials please try again.
         * =======================================
         */
/*
        Customer customer = new Customer("Ahmed Sameh Ahmed", 2000);

        try {
            if (customer.isPasswordValid(PASSWORD_LOGIN)) {

                ShippableProduct cheese = new ShippableProduct("Cheese", 200, 5, 1.9);
                // 86400 == 24 hours
                ExpirableProduct biscuits = new ExpirableProduct("Biscuits", 150, 2, new Date(System.currentTimeMillis() + 86400));
                Product scratchCard = new Product("Mobile scratch card", 5000, 10);
                Product tv = new Product("Samsung TV 30 inch", 9000, 5);

                Cart cart = new Cart();
                cart.add(cheese, 2);
                cart.add(tv, 3);
                cart.add(scratchCard, 1);
                cart.add(biscuits, 2);

                CheckoutService.checkout(customer, cart);
            } else {
                System.out.println("invalid credentials please try again.");
            }
        } catch (GlobalSystemException e) {
            throw new GlobalSystemException(e.getMessage());
        }
*/

        Customer customer = new Customer("Ahmed Sameh Ahmed", 1500);
        try {
            if (customer.isPasswordValid(PASSWORD_LOGIN)) {

                ShippableProduct cheese = new ShippableProduct("Cheese", 10, 5, 1.9);
                // 86400 == 24 hours
                ExpirableProduct biscuits = new ExpirableProduct("Biscuits", 2, 2, new Date(System.currentTimeMillis() + 86400));
                Product scratchCard = new Product("Mobile scratch card", 90, 10);
                Product tv = new Product("Samsung TV 30 inch", 300, 5);

                Cart cart = new Cart();
                cart.add(cheese, 2);
                cart.add(tv, 3);
                cart.add(biscuits, 1);
                cart.add(scratchCard, 1);

                CheckoutService.checkout(customer, cart);
            } else {
                System.out.println("invalid credentials please try again.");
            }
        } catch (GlobalSystemException e) {
            throw new GlobalSystemException(e.getMessage());
        }
    }
}