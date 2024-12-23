/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author Hai Anh
 */
public class DrinkDTO {
    private int drinkID;
    private String drinkName;

    public DrinkDTO() {
    }

    public DrinkDTO(int drinkID, String name) {
        this.drinkID = drinkID;
        this.drinkName = name;
    }

    public int getDrinkID() {
        return drinkID;
    }

    public void setDrinkID(int drinkID) {
        this.drinkID = drinkID;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    @Override
    public String toString() {
        return "Drink{" + "drinkID=" + drinkID + ", name=" + drinkName + '}';
    }
    
}

    