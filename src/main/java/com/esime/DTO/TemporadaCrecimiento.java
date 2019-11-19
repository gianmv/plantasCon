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
public class TemporadaCrecimiento {
    private BigDecimal id_tempo;
    private String nom_tempo;

    public TemporadaCrecimiento() {
        this.id_tempo = new BigDecimal(0);
        this.nom_tempo = "null";
    }

    public TemporadaCrecimiento(BigDecimal id_tempo, String nom_tempo) {
        this.id_tempo = id_tempo;
        this.nom_tempo = nom_tempo;
    }

    public BigDecimal getId_tempo() {
        return id_tempo;
    }

    public void setId_tempo(BigDecimal id_tempo) {
        this.id_tempo = id_tempo;
    }

    public String getNom_tempo() {
        return nom_tempo;
    }

    public void setNom_tempo(String nom_tempo) {
        this.nom_tempo = nom_tempo;
    }

    @Override
    public String toString() {
        return "TemporadaCrecimiento{" + "id_tempo=" + id_tempo + ", nom_tempo=" + nom_tempo + '}';
    }
    
}
