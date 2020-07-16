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
public class Fruit {
    private String FID,FName;
    private float FPrice;
    private int FQuantity;
    private String FOrigin;

    public Fruit() {
    }

    public Fruit(String FID, String FName, float FPrice, int FQuantity, String FOrigin) {
        this.FID = FID;
        this.FName = FName;
        this.FPrice = FPrice;
        this.FQuantity = FQuantity;
        this.FOrigin = FOrigin;
    }

    public String getFID() {
        return FID;
    }

    public void setFID(String FID) {
        this.FID = FID;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public float getFPrice() {
        return FPrice;
    }

    public void setFPrice(float FPrice) {
        this.FPrice = FPrice;
    }

    public int getFQuantity() {
        return FQuantity;
    }

    public void setFQuantity(int FQuantity) {
        this.FQuantity = FQuantity;
    }

    public String getFOrigin() {
        return FOrigin;
    }

    public void setFOrigin(String FOrigin) {
        this.FOrigin = FOrigin;
    }
    @Override
    public String toString(){
        return FID+" "+FName+" "+FOrigin+" "+FPrice+" "+FQuantity;
    }
}
