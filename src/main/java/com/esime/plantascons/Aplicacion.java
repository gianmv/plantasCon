/*
 *  Codigo fuente desarrollado en ESIME Culhuacan, se permite su distribución
 * solo entre alumnos de la ESIME Culhuacan con propositos academicos.
 * Prohibida su venta sin autorización de los autores
 */
package com.esime.plantascons;


import com.esime.DAO.*;
import com.esime.DTO.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Giancarlo Mo.Ve.
 */
public class Aplicacion {
    public static void main(String[] args) {
        SintomasDAO example = new SintomasDAO();
        ArrayList<Sintomas> res = (ArrayList<Sintomas>) example.getTodos();
        for(Sintomas i: res){
            System.out.println(i);
        }
        
        res.get(0).setNom_sinto("Calambre abdominal");
        res.get(3).setNom_sinto("Miedo a aumentar de peso");      
        boolean verdad =example.setConjunto(res);
        System.out.println(verdad);
        
        /*
        try {
            PropertiesConfiguration properties = new PropertiesConfiguration("jdbc.properties");
        } catch (ConfigurationException e) {
            System.out.println(e.getMessage());
        }*/
        
    }
    
}
