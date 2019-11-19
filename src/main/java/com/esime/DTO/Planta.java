/*
 *  Codigo fuente desarrollado en ESIME Culhuacan, se permite su distribución
 * solo entre alumnos de la ESIME Culhuacan con propositos academicos.
 * Prohibida su venta sin autorización de los autores
 */
package com.esime.DTO;

import java.math.BigDecimal;
import java.sql.Blob;

/**
 *
 * @author Giancarlo Mo.Ve.
 */
public class Planta {
    private BigDecimal id_plan;
    private String nom_plan;
    private String nom_cien_plan;
    private String fam_plan;
    private Blob img_plan;
    private String cat_plan;
    private BigDecimal alt_suelo;
    private String uso_plan;
    private BigDecimal tam_plan;
    private String tiem_creci;
    private Clima clim;
    private Region regi;
    private Humedad hume;
    private TemporadaCrecimiento tempo;
    private Color color;
    private Textura text;
    private Enfermedad enf;

    public Planta() {
        this.alt_suelo = new BigDecimal(0);
        this.cat_plan = "null";
        this.clim = null;
        this.color = null;
        this.fam_plan = "";
        this.hume = null;
        this.id_plan = new BigDecimal(0);
        this.img_plan = null;
        this.nom_cien_plan = "null";
        this.nom_plan = "null";
        this.regi = null;
        this.tam_plan = new BigDecimal(0);
        this.tempo = null;
        this.text = null;
        this.tiem_creci = "null";
        this.uso_plan = "null";
        this.enf = null;
    }

    public Planta(BigDecimal id_plan, String nom_plan, String nom_cien_plan, String fam_plan,
            Blob img_plan, String cat_plan, BigDecimal alt_suelo, String uso_plan, 
            BigDecimal tam_plan, String tiem_creci, BigDecimal id_clima, BigDecimal id_reg,
            BigDecimal id_hume, BigDecimal id_tempo, BigDecimal id_color, BigDecimal id_text) {
        this.id_plan = id_plan;
        this.nom_plan = nom_plan;
        this.nom_cien_plan = nom_cien_plan;
        this.fam_plan = fam_plan;
        this.img_plan = img_plan;
        this.cat_plan = cat_plan;
        this.alt_suelo = alt_suelo;
        this.uso_plan = uso_plan;
        this.tam_plan = tam_plan;
        this.tiem_creci = tiem_creci;
    }

    public BigDecimal getId_plan() {
        return id_plan;
    }

    public Clima getClim() {
        return clim;
    }

    public void setClim(Clima clim) {
        this.clim = clim;
    }

    public Humedad getHume() {
        return hume;
    }

    public void setHume(Humedad hume) {
        this.hume = hume;
    }

    public TemporadaCrecimiento getTempo() {
        return tempo;
    }

    public void setTempo(TemporadaCrecimiento tempo) {
        this.tempo = tempo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Textura getText() {
        return text;
    }

    public void setText(Textura text) {
        this.text = text;
    }

    public void setId_plan(BigDecimal id_plan) {
        this.id_plan = id_plan;
    }

    public String getNom_plan() {
        return nom_plan;
    }

    public void setNom_plan(String nom_plan) {
        this.nom_plan = nom_plan;
    }

    public String getNom_cien_plan() {
        return nom_cien_plan;
    }

    public void setNom_cien_plan(String nom_cien_plan) {
        this.nom_cien_plan = nom_cien_plan;
    }

    public String getFam_plan() {
        return fam_plan;
    }

    public void setFam_plan(String fam_plan) {
        this.fam_plan = fam_plan;
    }

    public Blob getImg_plan() {
        return img_plan;
    }

    public void setImg_plan(Blob img_plan) {
        this.img_plan = img_plan;
    }

    public String getCat_plan() {
        return cat_plan;
    }

    public void setCat_plan(String cat_plan) {
        this.cat_plan = cat_plan;
    }

    public BigDecimal getAlt_suelo() {
        return alt_suelo;
    }

    public void setAlt_suelo(BigDecimal alt_suelo) {
        this.alt_suelo = alt_suelo;
    }

    public String getUso_plan() {
        return uso_plan;
    }

    public void setUso_plan(String uso_plan) {
        this.uso_plan = uso_plan;
    }

    public BigDecimal getTam_plan() {
        return tam_plan;
    }

    public void setTam_plan(BigDecimal tam_plan) {
        this.tam_plan = tam_plan;
    }

    public String getTiem_creci() {
        return tiem_creci;
    }

    public void setTiem_creci(String tiem_creci) {
        this.tiem_creci = tiem_creci;
    }

    public Region getRegi() {
        return regi;
    }

    public void setRegi(Region regi) {
        this.regi = regi;
    }

    public Enfermedad getEnf() {
        return enf;
    }

    public void setEnf(Enfermedad enf) {
        this.enf = enf;
    }
    
    
    @Override
    public String toString() {
        return "Planta{" + "id_plan=" + id_plan + ", nom_plan=" + nom_plan + ", nom_cien_plan=" + nom_cien_plan + ",\n fam_plan=" + fam_plan + ", cat_plan=" + cat_plan + ", alt_suelo=" + alt_suelo + ", uso_plan=" + uso_plan + ", tam_plan=" + tam_plan + ",\n tiem_creci=" + tiem_creci + ", clim=" + clim + ", regi=" + regi + ",\n hume=" + hume + ", tempo=" + tempo + ", color=" + color + ",\n text=" + text +",enfermedad="+enf+ '}';
    }
    
    
    
}
