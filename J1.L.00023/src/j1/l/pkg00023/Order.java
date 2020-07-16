/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.pkg00023;

/**
 *
 * @author Uchiha Obito
 */
public class Order {
    private String OrName,OrProduct;
    private int OrQuantity;
    private float OrPrice,OrAmount;

    public Order() {
    }

    public Order(String OrName, String OrProduct, int OrQuantity, float OrPrice, float OrAmount) {
        this.OrName = OrName;
        this.OrProduct = OrProduct;
        this.OrQuantity = OrQuantity;
        this.OrPrice = OrPrice;
        this.OrAmount = OrAmount;
    }

    public String getOrName() {
        return OrName;
    }

    public void setOrName(String OrName) {
        this.OrName = OrName;
    }

    public String getOrProduct() {
        return OrProduct;
    }

    public void setOrProduct(String OrProduct) {
        this.OrProduct = OrProduct;
    }

    public int getOrQuantity() {
        return OrQuantity;
    }

    public void setOrQuantity(int OrQuantity) {
        this.OrQuantity = OrQuantity;
    }

    public float getOrPrice() {
        return OrPrice;
    }

    public void setOrPrice(float OrPrice) {
        this.OrPrice = OrPrice;
    }

    public float getOrAmount() {
        return OrAmount;
    }

    public void setOrAmount(float OrAmount) {
        this.OrAmount = OrAmount;
    }
    @Override
    public String toString(){
        return OrName + "|  " +OrProduct + "|  " + OrQuantity + "|  " + OrPrice + "|  " + OrAmount;
    }
}
