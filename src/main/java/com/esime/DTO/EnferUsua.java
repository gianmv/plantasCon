/*
 *  Codigo fuente desarrollado en ESIME Culhuacan, se permite su distribución
 * solo entre alumnos de la ESIME Culhuacan con propositos academicos.
 * Prohibida su venta sin autorización de los autores
 */
package com.esime.DTO;


/**
 *
 * @author Giancarlo Mo.Ve.
 */
public class EnferUsua {
    private Enfermedad enfer;
    private Usuarios usua;

    public EnferUsua() {
        this.enfer = null;
        this.usua =  null;
    }

    public EnferUsua(Enfermedad enfer, Usuarios usua) {
        this.enfer = enfer;
        this.usua = usua;
    }

    public Enfermedad getEnfer() {
        return enfer;
    }

    public void setEnfer(Enfermedad enfer) {
        this.enfer = enfer;
    }

    public Usuarios getUsua() {
        return usua;
    }

    public void setUsua(Usuarios usua) {
        this.usua = usua;
    }

    
    
    
    @Override
    public String toString() {
        return "enfer_usua{" + "enfer=" + enfer + ",\n usua=" + usua + '}';
    }    
}
