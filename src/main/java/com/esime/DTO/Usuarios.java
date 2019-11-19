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
public class Usuarios {
    private BigDecimal id_usua;
    private String nom_usua;
    private String priape_usua;
    private String segape_usua;
    private String nom_adminis;
    private String contrasenia;
    private String correo;

    public Usuarios() {
        this.contrasenia = "null";
        this.correo = "null";
        this.id_usua = new BigDecimal(0);
        this.nom_adminis = "null";
        this.nom_usua = "null";
        this.priape_usua = "null";
        this.segape_usua = "null";
    }

    public Usuarios(BigDecimal id_usua, String nom_usua, String priape_usua, String segape_usua, String nom_adminis, String contrasenia, String correo) {
        this.id_usua = id_usua;
        this.nom_usua = nom_usua;
        this.priape_usua = priape_usua;
        this.segape_usua = segape_usua;
        this.nom_adminis = nom_adminis;
        this.contrasenia = contrasenia;
        this.correo = correo;
    }

    public BigDecimal getId_usua() {
        return id_usua;
    }

    public void setId_usua(BigDecimal id_usua) {
        this.id_usua = id_usua;
    }

    public String getNom_usua() {
        return nom_usua;
    }

    public void setNom_usua(String nom_usua) {
        this.nom_usua = nom_usua;
    }

    public String getPriape_usua() {
        return priape_usua;
    }

    public void setPriape_usua(String priape_usua) {
        this.priape_usua = priape_usua;
    }

    public String getSegape_usua() {
        return segape_usua;
    }

    public void setSegape_usua(String segape_usua) {
        this.segape_usua = segape_usua;
    }

    public String getNom_adminis() {
        return nom_adminis;
    }

    public void setNom_adminis(String nom_adminis) {
        this.nom_adminis = nom_adminis;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id_usua=" + id_usua + ", nom_usua=" + nom_usua + ", priape_usua=" + priape_usua + ", segape_usua=" + segape_usua + ",\n nom_adminis=" + nom_adminis + ", contrasenia=" + contrasenia + ", correo=" + correo + '}';
    }
    
}
