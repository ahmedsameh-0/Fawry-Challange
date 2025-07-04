package service;

import entity.interfaces.Shippable;
import java.util.List;

public class ShippingService {

    public static void ship(List<Shippable> items) {

        double totalWeight = 0;
        System.out.println("\n** Shipment Notice **");

        for (Shippable item : items) {
            System.out.println(item.getName() + " " + item.getWeight() + "kg");
            totalWeight += item.getWeight();
        }
        System.out.println("ShippingService:ship Total package weight: " + totalWeight + "kg\n");
    }
}