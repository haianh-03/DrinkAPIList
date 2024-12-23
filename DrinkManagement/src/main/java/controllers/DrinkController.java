/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dtos.DrinkDTO;
import dtos.DrinkDetailsDTO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.DrinkService;

/**
 *
 * @author Hai Anh
 */
@WebServlet(value = "/drink/*")
public class DrinkController extends HttpServlet{
    
    private final DrinkService drinkService;

    public DrinkController() {
        drinkService = new DrinkService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        String path = request.getPathInfo();
        System.out.println("Path: " + path);
        
        try {
            switch (path) {
                case "/all":{
                    System.out.println("hihi");
                    List<DrinkDTO> drinkDTOList = new ArrayList<>();
                    drinkDTOList = drinkService.getAllDrink();
                    
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonResponse = objectMapper.writeValueAsString(drinkDTOList);
                    System.out.println(jsonResponse);
                    
                    PrintWriter out = response.getWriter();
                    out.print(jsonResponse);
                    out.flush();
                    break;
                }
                case "/details":{
                    System.out.println("haha");
                    int drinkID = Integer.parseInt(request.getParameter("drinkID"));
                    System.out.println("DrinkID nè:" + drinkID);
                    DrinkDetailsDTO drinkDetailDTO = drinkService.getDrinkDetails(drinkID);
                    
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonResponse = objectMapper.writeValueAsString(drinkDetailDTO);
                    System.out.println(jsonResponse);
                    
                    PrintWriter out = response.getWriter();
                    out.print(jsonResponse);
                    out.flush();
                    break;
                }
                default:{
                    
                }
            }
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(DrinkController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
}
