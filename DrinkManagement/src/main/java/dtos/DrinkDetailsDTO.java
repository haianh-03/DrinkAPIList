/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.List;

/**
 *
 * @author Hai Anh
 */
public class DrinkDetailsDTO extends DrinkDTO{
    private String topping;
    private String description;
    private List<DrinkSizePriceDTO> listSizePrice;

    public DrinkDetailsDTO() {
    }

    public DrinkDetailsDTO(String topping, String description, List<DrinkSizePriceDTO> listSizePrice) {
        this.topping = topping;
        this.description = description;
        this.listSizePrice = listSizePrice;
    }

    public DrinkDetailsDTO(String topping, String description, List<DrinkSizePriceDTO> listSizePrice, int drinkID, String name, int price) {
        super(drinkID, name);
        this.topping = topping;
        this.description = description;
        this.listSizePrice = listSizePrice;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DrinkSizePriceDTO> getListSizePrice() {
        return listSizePrice;
    }

    public void setListSizePrice(List<DrinkSizePriceDTO> listSizePrice) {
        this.listSizePrice = listSizePrice;
    }

    @Override
    public String toString() {
        return "DrinkDetailDTO{" + "topping=" + topping + ", description=" + description + ", listSizePrice=" + super.getDrinkName() + '}';
    }

    
    
}
