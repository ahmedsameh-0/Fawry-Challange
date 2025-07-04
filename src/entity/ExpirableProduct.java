package entity;

import java.util.Date;

public class ExpirableProduct extends Product{

    private Date expireDate;

    public ExpirableProduct(String name, double price, int quantity, Date expiryDate) {
        super(name, price, quantity);
        this.expireDate = expiryDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
    public boolean isExpired() {
        return new Date().after(expireDate);
    }
}