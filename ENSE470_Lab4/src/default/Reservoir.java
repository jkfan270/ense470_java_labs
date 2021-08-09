/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jkfan
 */
public class Reservoir {
    private String name;
    private double price;
    private int capacity;
    private int quantity;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0)
            this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if(capacity > 0) {
            this.capacity = capacity;
            this.quantity = capacity;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int remaining) {
        if(remaining >= 0 && remaining <= capacity)
            this.quantity = remaining;
    }
}
