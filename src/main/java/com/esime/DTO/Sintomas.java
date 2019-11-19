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
public class Sintomas {
    private BigDecimal id_sinto;
    private String nom_sinto;

    public Sintomas() {
        this.id_sinto = new BigDecimal(0);
        this.nom_sinto ="null";
    }

    public Sintomas(BigDecimal id_sinto, String nom_sinto) {
        this.id_sinto = id_sinto;
        this.nom_sinto = nom_sinto;
    }

    public BigDecimal getId_sinto() {
        return id_sinto;
    }

    public void setId_sinto(BigDecimal id_sinto) {
        this.id_sinto = id_sinto;
    }

    public String getNom_sinto() {
        return nom_sinto;
    }

    public void setNom_sinto(String nom_sinto) {
        this.nom_sinto = nom_sinto;
    }

    @Override
    public String toString() {
        return "Sintomas{" + "id_sinto=" + id_sinto + ", nom_sinto=" + nom_sinto + '}';
    }

       
}
