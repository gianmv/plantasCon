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
public class Textura {
    private BigDecimal id_text;
    private String nom_text;

    public Textura() {
        this.id_text = new BigDecimal(0);
        this.nom_text = "null";
    }

    public Textura(BigDecimal id_text, String nom_text) {
        this.id_text = id_text;
        this.nom_text = nom_text;
    }

    public BigDecimal getId_text() {
        return id_text;
    }

    public void setId_text(BigDecimal id_text) {
        this.id_text = id_text;
    }

    public String getNom_text() {
        return nom_text;
    }

    public void setNom_text(String nom_text) {
        this.nom_text = nom_text;
    }

    

    @Override
    public String toString() {
        return "Textura{" + "id_text=" + id_text + ", nom_text=" + nom_text + '}';
    }
    
    
}
