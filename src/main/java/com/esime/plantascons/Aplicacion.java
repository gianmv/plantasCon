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
        UsuariosDAO example = new UsuariosDAO();
        ArrayList<Usuarios> res = (ArrayList<Usuarios>) example.getTodos();
        for(Usuarios i: res){
            System.out.println(i);
        }
        
        ArrayList<Usuarios> inser = new ArrayList<>();
        Usuarios x1 = res.get(0);
        x1.setId_usua(new BigDecimal(111));
        x1.setNom_usua("Gatos con patas");
        Usuarios x2 = res.get(3);
        x2.setId_usua(new BigDecimal(112));
        x2.setNom_usua("perros con cola");
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
