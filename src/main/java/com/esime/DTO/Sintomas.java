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
    private String nom_cien_enfer;

    public Sintomas() {
        this.id_sinto = new BigDecimal(0);
        this.nom_sinto ="null";
        this.nom_cien_enfer = "null";
    }

    public Sintomas(BigDecimal id_sinto, String nom_sinto, String nom_cien_enfer) {
        this.id_sinto = id_sinto;
        this.nom_sinto = nom_sinto;
        this.nom_cien_enfer = nom_cien_enfer;
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

    public String getNom_cien_enfer() {
        return nom_cien_enfer;
    }

    public void setNom_cien_enfer(String nom_cien_enfer) {
        this.nom_cien_enfer = nom_cien_enfer;
    }

    @Override
    public String toString() {
        return "Sintomas{" + "id_sinto=" + id_sinto + ", nom_sinto=" + nom_sinto + ", nom_cien_enfer=" + nom_cien_enfer + '}';
    }
    
    
}
