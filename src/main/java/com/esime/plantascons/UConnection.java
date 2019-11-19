/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esime.plantascons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

/**
 *
 * @author Giancarlo Mo.Ve.
 */
public class UConnection {
    private static Connection con = null;
    
    public static Connection getConnection(){
        try{
            if(con == null){
                Runtime.getRuntime().addShutdownHook(new MiShDwHook());
                ResourceBundle rb =ResourceBundle.getBundle("jdbc");
                String driver = rb.getString("driver");
                String url = rb.getString("url");
                String pwd = rb.getString("pwd");
                String usr = rb.getString("usr");
                Class.forName(driver);
                
                con = DriverManager.getConnection(url, usr, pwd);
            }
            return con;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al crear la conexión",e);
        }
    }
    
    static class MiShDwHook extends Thread{
        
        @Override
        public void run(){
            try {
                Connection con = UConnection.getConnection();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}