/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author Hai Anh
 */
public class DrinkSizePriceDTO {
    private String size;
    private int price;

    public DrinkSizePriceDTO() {
    }

    public DrinkSizePriceDTO(String size, int price) {
        this.size = size;
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DrinkSizePrice{" + "size=" + size + ", price=" + price + '}';
    }
    
    
}
