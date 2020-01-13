/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waltergaldamez.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Walter Gdmz
 */
public class Conexion {
    
    private Connection conexion;
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void  setConexio(Connection con){
        this.conexion = con;
    }

    public void conectar() throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/daojavaswing?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","admin");
                                   
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error al conectar"+ sqle.toString());
        }        
    }
    
    public void desconectar()throws Exception{ 
        try{
            if (conexion.isClosed()==false) {
                conexion.close();                
            }           
        }catch(SQLException sqle){
            throw sqle;
        } 
    }
}
