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
        EnfermedadDAO example = new EnfermedadDAO();
        ArrayList<Enfermedad> res = (ArrayList<Enfermedad>) example.getTodos();
        for(Enfermedad i: res){
            System.out.println(i);
        }
        
        ArrayList<Enfermedad> inser = new ArrayList<>();
        Enfermedad x1 = res.get(0);
        x1.setId_enfer(new BigDecimal(111));
        x1.setNom_enfer("Gatos con patas");
        x1.setNom_cien_enfer("G");
        Enfermedad x2 = res.get(3);
        x2.setId_enfer(new BigDecimal(112));
        x2.setNom_enfer("Perros con garras");
        inser.add(x1);
        inser.add(x2);
        
        example.insertConjunto(inser);
        
        
        
        /*
        try {
            PropertiesConfiguration properties = new PropertiesConfiguration("jdbc.properties");
        } catch (ConfigurationException e) {
            System.out.println(e.getMessage());
        }*/
        
    }
    
}
