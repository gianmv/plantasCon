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
    private String nom_enfer;
    private String nom_cien_enfer;
    private Sintomas sintoma;

    public Enfermedad() {
        this.id_enfer = new BigDecimal(0);
        this.nom_enfer = "null";
        this.nom_cien_enfer = "null";
        this.sintoma = null;
    }

    public Enfermedad(BigDecimal id_enfer, String nom_enfer, String nom_cien_enfer, Sintomas sintoma) {
        this.id_enfer = id_enfer;
        this.nom_enfer = nom_enfer;
        this.nom_cien_enfer = nom_cien_enfer;
        this.sintoma = sintoma;
    }

    public BigDecimal getId_enfer() {
        return id_enfer;
    }

    public void setId_enfer(BigDecimal id_enfer) {
        this.id_enfer = id_enfer;
    }

    public String getNom_enfer() {
        return nom_enfer;
    }

    public void setNom_enfer(String nom_enfer) {
        this.nom_enfer = nom_enfer;
    }

    public String getNom_cien_enfer() {
        return nom_cien_enfer;
    }

    public void setNom_cien_enfer(String nom_cien_enfer) {
        this.nom_cien_enfer = nom_cien_enfer;
    }

    public Sintomas getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintomas sintoma) {
        this.sintoma = sintoma;
    }

    @Override
    public String toString() {
        return "Enfermedad{" + "id_enfer=" + id_enfer + ", nom_enfer=" + nom_enfer + ", nom_cien_enfer=" + nom_cien_enfer + ", sintoma=" + sintoma + '}';
    }
    
    

    
}
