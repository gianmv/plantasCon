/*
 *  Codigo fuente desarrollado en ESIME Culhuacan, se permite su distribución
 * solo entre alumnos de la ESIME Culhuacan con propositos academicos.
 * Prohibida su venta sin autorización de los autores
 */
package com.esime.DTO;

import java.math.BigDecimal;

/**
 *
 * @author Giancarlo Mo.Ve.
 */
public class Color {
    private BigDecimal id_color;
    private String nom_color;

    public Color() {
        this.id_color= new BigDecimal(0);
        this.nom_color="null";
        
    }

    
    public Color(BigDecimal id_color, String nom_color) {
        this.id_color = id_color;
        this.nom_color = nom_color;
    }

    public BigDecimal getId_color() {
        return id_color;
    }

    public void setId_color(BigDecimal id_color) {
        this.id_color = id_color;
    }

    public String getNom_color() {
        return nom_color;
    }

    public void setNom_color(String nom_color) {
        this.nom_color = nom_color;
    }

    @Override
    public String toString() {
        return "Color{" + "id_color=" + id_color + ", nom_color=" + nom_color + '}';
    }
    
}
