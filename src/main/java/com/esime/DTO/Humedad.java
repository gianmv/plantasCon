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
public class Humedad {
    private BigDecimal id_hume;
    private BigDecimal grad_hume;

    public Humedad() {
        this.grad_hume = new BigDecimal(0);
        this.id_hume = new BigDecimal(0);
    }

    public Humedad(BigDecimal id_hume, BigDecimal grad_hume) {
        this.id_hume = id_hume;
        this.grad_hume = grad_hume;
    }

    public BigDecimal getId_hume() {
        return id_hume;
    }

    public void setId_hume(BigDecimal id_hume) {
        this.id_hume = id_hume;
    }

    public BigDecimal getGrad_hume() {
        return grad_hume;
    }

    public void setGrad_hume(BigDecimal grad_hume) {
        this.grad_hume = grad_hume;
    }

    @Override
    public String toString() {
        return "Humedad{" + "id_hume=" + id_hume + ", grad_hume=" + grad_hume + '}';
    }
    
}
