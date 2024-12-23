/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dtos.DrinkDTO;
import dtos.DrinkDetailsDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import repositories.DrinkRepository;

/**
 *
 * @author Hai Anh
 */
public class DrinkService {
    private final DrinkRepository drinkRepository;

    public DrinkService() {
        drinkRepository = new DrinkRepository();
    }
    
    public List<DrinkDTO> getAllDrink() throws SQLException, ClassNotFoundException{
        List<DrinkDTO> drinkDTOList = drinkRepository.getAllDrink();
        return drinkDTOList;
    }
    
    public DrinkDetailsDTO getDrinkDetails(int drinkIDDetail) throws SQLException, ClassNotFoundException{
        DrinkDetailsDTO drinkDetailsDTO = new DrinkDetailsDTO();
        drinkDetailsDTO = drinkRepository.getDrinkDetails(drinkIDDetail);
        return drinkDetailsDTO;
    }
}
