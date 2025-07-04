package entity;

import exception.GlobalSystemException;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) throws GlobalSystemException {
        if (quantity > product.getQuantity()) {
            throw new GlobalSystemException("Not enough stock available for " + product.getName());
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}