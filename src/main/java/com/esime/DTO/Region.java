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
public class Region {
    private BigDecimal id_reg;
    private String nom_reg;

    public Region() {
        this.id_reg = new BigDecimal(0);
        this.nom_reg = "null";
    }

    public Region(BigDecimal id_reg, String nom_reg) {
        this.id_reg = id_reg;
        this.nom_reg = nom_reg;
    }

    public BigDecimal getId_reg() {
        return id_reg;
    }

    public void setId_reg(BigDecimal id_reg) {
        this.id_reg = id_reg;
    }

    public String getNom_reg() {
        return nom_reg;
    }

    public void setNom_reg(String nom_reg) {
        this.nom_reg = nom_reg;
    }

    @Override
    public String toString() {
        return "Region{" + "id_reg=" + id_reg + ", nom_reg=" + nom_reg + '}';
    }
    
    
}
