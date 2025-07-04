package service;

import entity.*;
import entity.interfaces.Shippable;
import exception.GlobalSystemException;
import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    private static final double shippingCostPerKG = 30.0;

    public static void checkout(Customer customer, Cart cart) throws GlobalSystemException {

        if (cart.isEmpty())
            throw new GlobalSystemException("CheckoutService:checkout Cart is empty!");

        double subtotal = 0;
        double shippingFees = 0;
        List<Shippable> shippables = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product instanceof ExpirableProduct && ((ExpirableProduct) product).isExpired()) {
                throw new GlobalSystemException("CheckoutService:checkout Product " + product.getName() + " is expired!");
            }
            subtotal += product.getPrice() * item.getQuantity();
            product.reduceQuantity(item.getQuantity());

            if (product instanceof ShippableProduct) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippables.add((ShippableProduct) product);
                }
            }
        }

        shippingFees = shippables.size() * shippingCostPerKG;
        double total = subtotal + shippingFees;

        if (!customer.isBuy(total)) {
            throw new GlobalSystemException("CheckoutService:checkout Insufficient balance!");
        }

        customer.reduceBalance(total);

        if (!shippables.isEmpty()) ShippingService.ship(shippables);

        System.out.println("** Checkout Receipt **");

        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + (item.getProduct().getPrice() * item.getQuantity()));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippingFees);
        System.out.println("Amount: " + total);
    }
}