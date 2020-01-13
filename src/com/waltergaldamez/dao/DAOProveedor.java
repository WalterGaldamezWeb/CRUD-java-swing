/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waltergaldamez.dao;

import com.waltergaldamez.conexion.Conexion;
import com.waltergaldamez.modelo.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Walter Gdmz
 */
public class DAOProveedor extends Conexion{
    
    public List<Proveedor> mostrarProveedor()throws Exception{
        ResultSet resultado;
        
        List<Proveedor> lista = new ArrayList();
        
        try{
            this.conectar();
            String sql = "SELECT * FROM proveedor";
            PreparedStatement stmt = this.getConexion().prepareStatement(sql);
            resultado = stmt.executeQuery();
            while (resultado.next()){
                Proveedor proveedor = new Proveedor();
                proveedor.setCodigoProveedor(resultado.getInt("codigoProveedor"));
                proveedor.setNombre(resultado.getString("nombre"));
                proveedor.setDireccion(resultado.getString("direccion"));
                proveedor.setTelefono(resultado.getString("telefono"));
                lista.add(proveedor);
            }
        }catch(Exception e){
                        throw e;
                    }
        finally{
            this.desconectar();
        }
        return lista;
    }
    
    public void insertarProveedor(Proveedor proveedor)throws Exception{
        try{
            this.conectar();
            String sql = "INSERT INTO proveedor (codigoProveedor,nombre,direccion,telefono)values(?,?,?,?)";
            PreparedStatement stmt = this.getConexion().prepareStatement(sql);
            
            stmt.setInt(1, proveedor.getCodigoProveedor());
            stmt.setString(2, proveedor.getNombre());
            stmt.setString(3, proveedor.getDireccion());
            stmt.setString(4, proveedor.getTelefono());                       
            stmt.executeUpdate();
                                    
        }catch(Exception e){
            throw e;
        }
        finally{
            this.desconectar();
        }
    }
    
    public void modificarProveedor(Proveedor proveedor)throws Exception{
        try{
            this.conectar();
            String sql = "UPDATE proveedor SET nombre=?,direccion=?,telefono=? WHERE codigoProveedor=?";
            PreparedStatement stmt = this.getConexion().prepareStatement(sql);
            int index=1;
            stmt.setString(index++, proveedor.getNombre());
            stmt.setString(index++, proveedor.getDireccion());
            stmt.setString(index++, proveedor.getTelefono());
            stmt.setInt(index, proveedor.getCodigoProveedor());           
            stmt.executeUpdate();
                                    
        }catch(Exception e){
            throw e;
        }
        finally{
            this.desconectar();
        }
    }
    
    public void eliminarProveedor(Proveedor proveedor)throws Exception{
        try{
            this.conectar();
            String sql = "DELETE FROM proveedor WHERE codigoProveedor=?";
            PreparedStatement stmt = this.getConexion().prepareStatement(sql);
            stmt.setInt(1, proveedor.getCodigoProveedor());           
            stmt.executeUpdate();
                                    
        }catch(Exception e){
            throw e;
        }
        finally{
            this.desconectar();
        }
    }    
}
