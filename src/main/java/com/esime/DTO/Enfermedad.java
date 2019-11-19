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
public class Enfermedad {
    private BigDecimal id_enfer;
    private String nom_efer;
    private String nom_cien_enfer;

    public Enfermedad() {
        this.id_enfer = new BigDecimal(0);
        this.nom_cien_enfer = "null";
        this.nom_efer = "null";
    }
    
    public Enfermedad(BigDecimal id_enfer, String nom_efer, String nom_cien_enfer) {
        this.id_enfer = id_enfer;
        this.nom_efer = nom_efer;
        this.nom_cien_enfer = nom_cien_enfer;
    }
    
    

    public BigDecimal getId_enfer() {
        return id_enfer;
    }

    public void setId_enfer(BigDecimal id_enfer) {
        this.id_enfer = id_enfer;
    }

    public String getNom_efer() {
        return nom_efer;
    }

    public void setNom_efer(String nom_efer) {
        this.nom_efer = nom_efer;
    }

    public String getNom_cien_enfer() {
        return nom_cien_enfer;
    }

    public void setNom_cien_enfer(String nom_cien_enfer) {
        this.nom_cien_enfer = nom_cien_enfer;
    }

    @Override
    public String toString() {
        return "Enfermedad{" + "id_enfer=" + id_enfer + ", nom_efer=" + nom_efer + ", nom_cien_enfer=" + nom_cien_enfer +'}';
    }    
}
