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
public class Clima {
    private BigDecimal id_clima;
    private String nom_clima;

    public Clima() {
        this.id_clima= new BigDecimal(0);
        this.nom_clima = "null";
    }

    public Clima(BigDecimal id_clima, String nom_clima) {
        this.id_clima = id_clima;
        this.nom_clima = nom_clima;
    }
    
    public BigDecimal getId_clima() {
        return id_clima;
    }

    public void setId_clima(BigDecimal id_clima) {
        this.id_clima = id_clima;
    }

    public String getNom_clima() {
        return nom_clima;
    }

    public void setNom_clima(String nom_clima) {
        this.nom_clima = nom_clima;
    }

    @Override
    public String toString() {
        return "Clima{" + "id_clima=" + id_clima + ", nom_clima=" + nom_clima + '}';
    }
}
