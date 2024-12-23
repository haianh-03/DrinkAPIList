/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import dtos.DrinkDTO;
import dtos.DrinkDetailsDTO;
import dtos.DrinkSizePriceDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Hai Anh
 */
public class DrinkRepository {

    public List<DrinkDTO> getAllDrink() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<DrinkDTO> drinkDTOList = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                System.out.println("Đã kết nối!!!");
                String query = "select Drink.DrinkID, Drink.DrinkName from Drink";
                stm = con.prepareStatement(query);
                rs = stm.executeQuery();
                while (rs.next()) {
                    DrinkDTO drinkDTO = new DrinkDTO();
                    drinkDTO.setDrinkID(rs.getInt("DrinkID"));
                    drinkDTO.setDrinkName(rs.getNString("DrinkName"));
                    drinkDTOList.add(drinkDTO);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return drinkDTOList;
    }

    public DrinkDetailsDTO getDrinkDetails(int drinkIDDetail) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DrinkDetailsDTO drinkDTO = new DrinkDetailsDTO();
        List<DrinkSizePriceDTO> drinkSizePrice = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                System.out.println("Đã Kết Nối!!!");
                String query = "select Drink.DrinkID, Drink.DrinkName, Drink.[Description], Size.SizeName, Topping.ToppingName, Drink_Size.Price\n"
                        + "from Drink \n"
                        + "left join Drink_Topping\n"
                        + "on Drink.DrinkID = Drink_Topping.DrinkID\n"
                        + "inner join Drink_Size\n"
                        + "on Drink.DrinkID = Drink_Size.DrinkID\n"
                        + "inner join Size\n"
                        + "on Drink_Size.SizeID = Size.SizeID\n"
                        + "left join Topping\n"
                        + "on Drink_Topping.ToppingID = Topping.ToppingID\n"
                        + "where Drink.DrinkID = ?";
                stm = con.prepareStatement(query);
                stm.setInt(1, drinkIDDetail);
                rs = stm.executeQuery();

                while (rs.next()) {
                    drinkDTO.setDrinkID(rs.getInt("DrinkID"));
                    drinkDTO.setDrinkName(rs.getNString("DrinkName"));
                    drinkDTO.setDescription(rs.getNString("Description"));
                    drinkDTO.setTopping(rs.getNString("ToppingName"));
                    drinkSizePrice.add(new DrinkSizePriceDTO(rs.getNString("SizeName"), rs.getInt("Price")));
                    drinkDTO.setListSizePrice(drinkSizePrice);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return drinkDTO;
    }

}
