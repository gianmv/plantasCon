/*
 *  Codigo fuente desarrollado en ESIME Culhuacan, se permite su distribución
 * solo entre alumnos de la ESIME Culhuacan con propositos academicos.
 * Prohibida su venta sin autorización de los autores
 */
package com.esime.DAO;

import com.esime.DTO.Clima;
import com.esime.DTO.Color;
import com.esime.DTO.Enfermedad;
import com.esime.DTO.Humedad;
import com.esime.DTO.Planta;
import com.esime.DTO.Region;
import com.esime.DTO.TemporadaCrecimiento;
import com.esime.DTO.Textura;
import com.esime.plantascons.UConnection;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Giancarlo Mo.Ve.
 */
public class PlantaDAO extends Extraer<Planta>{

    @Override
    public Collection<Planta> getTodos() {
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_PLAN,NOM_PLAN,NOM_CIEN_PLAN,";
            sql+="FAM_PLAN,IMG_PLAN,CAT_PLAN,ALT_SUELO,USO_PLAN,";
            sql+="TAM_PLAN,TIEM_CRECI,ID_CLIMA,ID_REG,ID_HUME,ID_TEMPO,";
            sql+="ID_COLOR,ID_TEXT,ID_ENFER ";
            sql+="FROM PLANTA";
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            List<Planta> ret = new ArrayList<>();
            
            Planta planta =null;
            while(rs.next()){
                int idClima,idReg,idHume,idTempo,idColor,idText,idEnf;
                planta = new Planta();
                planta.setId_plan(rs.getBigDecimal("ID_PLAN"));
                planta.setNom_plan(rs.getString("NOM_PLAN"));
                planta.setNom_cien_plan(rs.getString("NOM_CIEN_PLAN"));
                planta.setFam_plan(rs.getString("FAM_PLAN"));
                planta.setImg_plan(rs.getBlob("IMG_PLAN"));
                planta.setCat_plan(rs.getString("CAT_PLAN"));
                planta.setAlt_suelo(rs.getBigDecimal("ALT_SUELO"));
                planta.setUso_plan(rs.getString("USO_PLAN"));
                planta.setTam_plan(rs.getBigDecimal("TAM_PLAN"));
                planta.setTiem_creci(rs.getString("TIEM_CRECI"));
                //Se tiene que crear el objeto Clima
                idClima = rs.getBigDecimal("ID_CLIMA").intValue();
                planta.setClim(getClima(idClima));
                //Se tiene que crear el objeto region
                idReg = rs.getBigDecimal("ID_REG").intValue();
                planta.setRegi(getRegion(idReg));
                //Se tiene que crear el objeto humedad
                idHume = rs.getBigDecimal("ID_HUME").intValue();
                planta.setHume(getHumedad(idHume));
                //Se tiene que crear el objeto teporadacrecimiento
                idTempo = rs.getBigDecimal("ID_TEMPO").intValue();
                planta.setTempo(getTemporadaCrecimiento(idTempo));
                //Se tiene que crear el objeto Color
                idColor = rs.getBigDecimal("ID_COLOR").intValue();
                planta.setColor(getColor(idColor));
                //Se tiene que crear el objeto textura
                idText = rs.getBigDecimal("ID_TEXT").intValue();
                planta.setText(getTextura(idText));
                //Se tiene que crear el objeto enfermedad
                idEnf = rs.getBigDecimal("ID_ENFER").intValue();
                planta.setEnf(getEnfermedad(idEnf));
                ret.add(planta);
            }
            return ret;            
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }finally{
                try {
                    if(rs!=null) rs.close();
                    if(pstm!=null) pstm.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
        }
    }

    @Override
    public Collection<Planta> getPorID(int id) {
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_PLAN,NOM_PLAN,NOM_CIEN_PLAN,";
            sql+="FAM_PLAN,IMG_PLAN,CAT_PLAN,ALT_SUELO,USO_PLAN,";
            sql+="TAM_PLAN,TIEM_CRECI,ID_CLIMA,ID_REG,ID_HUME,ID_TEMPO,";
            sql+="ID_COLOR,ID_TEXT,ID_ENFER ";
            sql+="FROM PLANTA WHERE ID_PLAN = ?";
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, new BigDecimal(id));
            rs = pstm.executeQuery();
            
            List<Planta> ret = new ArrayList<>();
            
            Planta planta =null;
            while(rs.next()){
                int idClima,idReg,idHume,idTempo,idColor,idText,idEnf;
                planta = new Planta();
                planta.setAlt_suelo(rs.getBigDecimal("ALT_SUELO"));
                planta.setCat_plan(rs.getString("CAT_PLAN"));
                //Se tiene que crear el objeto Clima
                idClima = rs.getBigDecimal("ID_CLIMA").intValue();
                planta.setClim(getClima(idClima));
                //Se tiene que crear el objeto Color
                idColor = rs.getBigDecimal("ID_COLOR").intValue();
                planta.setColor(getColor(idColor));
                planta.setFam_plan(rs.getString("FAM_PLAN"));
                //Se tiene que crear el objeto humedad
                idHume = rs.getBigDecimal("ID_HUME").intValue();
                planta.setHume(getHumedad(idHume));
                planta.setId_plan(rs.getBigDecimal("ID_PLAN"));
                planta.setImg_plan(rs.getBlob("IMG_PLAN"));
                planta.setNom_cien_plan(rs.getString("NOM_CIEN_PLAN"));
                planta.setNom_plan(rs.getString("NOM_PLAN"));
                //Se tiene que crear el objeto region
                idReg = rs.getBigDecimal("ID_REG").intValue();
                planta.setRegi(getRegion(idReg));
                //Se tiene que crear el objeto teporadacrecimiento
                idTempo = rs.getBigDecimal("ID_TEMPO").intValue();
                planta.setTempo(getTemporadaCrecimiento(idTempo));
                //Se tiene que crear el objeto textura
                idText = rs.getBigDecimal("ID_TEXT").intValue();
                planta.setText(getTextura(idText));
                planta.setTiem_creci(rs.getString("TIEM_CRECI"));
                planta.setUso_plan(rs.getString("USO_PLAN"));
                //Se tiene que crear el objeto enfermedad
                idEnf = rs.getBigDecimal("ID_ENFER").intValue();
                planta.setEnf(getEnfermedad(idEnf));
                ret.add(planta);
            }
            return ret;            
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }finally{
                try {
                    if(rs!=null) rs.close();
                    if(pstm!=null) pstm.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
        }
    }
    
    private Clima getClima(int id){
       ArrayList<Clima> temp;
       ClimaDAO t = new ClimaDAO();
       temp = (ArrayList<Clima>) t.getPorID(id);
       return temp.get(0);
    }
    
    private Color getColor(int id){
       ArrayList<Color> temp;
       ColorDAO t = new ColorDAO();
       temp = (ArrayList<Color>) t.getPorID(id);
       return temp.get(0);
    }
    
    private Humedad getHumedad(int id){
       ArrayList<Humedad> temp;
       HumedadDAO t = new HumedadDAO();
       temp = (ArrayList<Humedad>) t.getPorID(id);
       return temp.get(0);
    }
    
    private Region getRegion(int id){
       ArrayList<Region> temp;
       RegionDAO t = new RegionDAO();
       temp = (ArrayList<Region>) t.getPorID(id);
       return temp.get(0);
    }
    
    private TemporadaCrecimiento getTemporadaCrecimiento(int id){
       ArrayList<TemporadaCrecimiento> temp;
       TemporadaCrecimientoDAO t = new TemporadaCrecimientoDAO();
       temp = (ArrayList<TemporadaCrecimiento>) t.getPorID(id);
       return temp.get(0);
    }
    
    private Textura getTextura(int id){
       ArrayList<Textura> temp;
       TexturaDAO t = new TexturaDAO();
       temp = (ArrayList<Textura>) t.getPorID(id);
       return temp.get(0);
    }
    
    private Enfermedad getEnfermedad(int id){
       ArrayList<Enfermedad> temp;
       EnfermedadDAO t = new EnfermedadDAO();
       temp = (ArrayList<Enfermedad>) t.getPorID(id);
       return temp.get(0);
    }

    @Override
    public boolean setElemento(Planta ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE PLANTA SET "
                    + "ID_PLAN = ?, "
                    + "NOM_PLAN = ?, "
                    + "NOM_CIEN_PLAN = ?, "
                    + "FAM_PLAN = ?, "
                    + "CAT_PLAN = ?, "
                    + "ALT_SUELO = ?, "
                    + "USO_PLAN = ?, "
                    + "TAM_PLAN = ?, "
                    + "TIEM_CRECI = ?, "
                    + "ID_CLIMA = ?, "
                    + "ID_REG = ?, "
                    + "ID_HUME = ?, "
                    + "ID_TEMPO = ?, "
                    + "ID_COLOR = ?, "
                    + "ID_TEXT = ?, "
                    + "ID_ENFER = ? "
                    + "WHERE ID_PLAN = ?";

            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_plan());
            pstm.setString(2, ele.getNom_plan());
            pstm.setString(3, ele.getNom_cien_plan());
            pstm.setString(4, ele.getFam_plan());
            pstm.setString(5, ele.getCat_plan());
            pstm.setBigDecimal(6, ele.getAlt_suelo());
            pstm.setString(7, ele.getUso_plan());
            pstm.setBigDecimal(8, ele.getTam_plan());
            pstm.setString(9, ele.getTiem_creci());
            pstm.setBigDecimal(10, ele.getClim().getId_clima());
            pstm.setBigDecimal(11, ele.getRegi().getId_reg());
            pstm.setBigDecimal(12, ele.getHume().getId_hume());
            pstm.setBigDecimal(13, ele.getTempo().getId_tempo());
            pstm.setBigDecimal(14, ele.getColor().getId_color());
            pstm.setBigDecimal(15, ele.getText().getId_text());
            pstm.setBigDecimal(16, ele.getEnf().getId_enfer());
            pstm.setBigDecimal(17, ele.getId_plan());
            int filasAfectadas = pstm.executeUpdate();
            if(filasAfectadas == 1){
                con.commit();
                return true;
            }else{
                throw new SQLException();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al actualizar");
            return false;
        }finally{
                try {
                    if(con!=null) con.rollback();
                    if(pstm!=null) pstm.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            
        }
    }

    @Override
    public boolean setConjunto(Collection<Planta> elementos) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE PLANTA SET "
                    + "ID_PLAN = ?, "
                    + "NOM_PLAN = ?, "
                    + "NOM_CIEN_PLAN = ?, "
                    + "FAM_PLAN = ?, "
                    + "CAT_PLAN = ?, "
                    + "ALT_SUELO = ?, "
                    + "USO_PLAN = ?, "
                    + "TAM_PLAN = ?, "
                    + "TIEM_CRECI = ?, "
                    + "ID_CLIMA = ?, "
                    + "ID_REG = ?, "
                    + "ID_HUME = ?, "
                    + "ID_TEMPO = ?, "
                    + "ID_COLOR = ?, "
                    + "ID_TEXT = ?, "
                    + "ID_ENFER = ? "
                    + "WHERE ID_PLAN = ?";
            pstm = con.prepareStatement(sql);
            for(Planta ele: elementos){
                pstm = con.prepareStatement(sql);
                pstm.setBigDecimal(1, ele.getId_plan());
                pstm.setString(2, ele.getNom_plan());
                pstm.setString(3, ele.getNom_cien_plan());
                pstm.setString(4, ele.getFam_plan());
                pstm.setString(5, ele.getCat_plan());
                pstm.setBigDecimal(6, ele.getAlt_suelo());
                pstm.setString(7, ele.getUso_plan());
                pstm.setBigDecimal(8, ele.getTam_plan());
                pstm.setString(9, ele.getTiem_creci());
                pstm.setBigDecimal(10, ele.getClim().getId_clima());
                pstm.setBigDecimal(11, ele.getRegi().getId_reg());
                pstm.setBigDecimal(12, ele.getHume().getId_hume());
                pstm.setBigDecimal(13, ele.getTempo().getId_tempo());
                pstm.setBigDecimal(14, ele.getColor().getId_color());
                pstm.setBigDecimal(15, ele.getText().getId_text());
                pstm.setBigDecimal(16, ele.getEnf().getId_enfer());
                pstm.setBigDecimal(17, ele.getId_plan());
                int filasAfectadas = pstm.executeUpdate();

                if (filasAfectadas == 1) {
                    con.commit();
                } else {
                    throw new SQLException();
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al actualizar");
            return false;
        }finally{
                try {
                    if(con!=null) con.rollback();
                    if(pstm!=null) pstm.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
        }
    }

    @Override
    public boolean insertElemento(Planta ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO PLANTA VALUES( ?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?) ";

            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_plan());
            pstm.setString(2, ele.getNom_plan());
            pstm.setString(3, ele.getNom_cien_plan());
            pstm.setString(4, ele.getFam_plan());
            pstm.setBlob(5, ele.getImg_plan());
            pstm.setString(6, ele.getCat_plan());
            pstm.setBigDecimal(7, ele.getAlt_suelo());
            pstm.setString(8, ele.getUso_plan());
            pstm.setBigDecimal(9, ele.getTam_plan());
            pstm.setString(10, ele.getTiem_creci());
            pstm.setBigDecimal(11, ele.getClim().getId_clima());
            pstm.setBigDecimal(12, ele.getRegi().getId_reg());
            pstm.setBigDecimal(13, ele.getHume().getId_hume());
            pstm.setBigDecimal(14, ele.getTempo().getId_tempo());
            pstm.setBigDecimal(15, ele.getColor().getId_color());
            pstm.setBigDecimal(16, ele.getText().getId_text());
            pstm.setBigDecimal(17, ele.getEnf().getId_enfer());
            pstm.executeUpdate();
            con.commit();
            return true;
            }catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al actualizar");
            return false;
        }finally{
                try {
                    if(con!=null) con.rollback();
                    if(pstm!=null) pstm.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
        }
    }

    @Override
    public boolean insertConjunto(Collection<Planta> ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO PLANTA VALUES( ?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?) ";
            
            for(Planta x : ele){
                pstm = con.prepareStatement(sql);
                pstm.setBigDecimal(1, x.getId_plan());
                pstm.setString(2, x.getNom_plan());
                pstm.setString(3, x.getNom_cien_plan());
                pstm.setString(4, x.getFam_plan());
                pstm.setBlob(5, x.getImg_plan());
                pstm.setString(6, x.getCat_plan());
                pstm.setBigDecimal(7, x.getAlt_suelo());
                pstm.setString(8, x.getUso_plan());
                pstm.setBigDecimal(9, x.getTam_plan());
                pstm.setString(10, x.getTiem_creci());
                pstm.setBigDecimal(11, x.getClim().getId_clima());
                pstm.setBigDecimal(12, x.getRegi().getId_reg());
                pstm.setBigDecimal(13, x.getHume().getId_hume());
                pstm.setBigDecimal(14, x.getTempo().getId_tempo());
                pstm.setBigDecimal(15, x.getColor().getId_color());
                pstm.setBigDecimal(16, x.getText().getId_text());
                pstm.setBigDecimal(17, x.getEnf().getId_enfer());
                pstm.executeUpdate();
                con.commit();
            }
            return true;
            }catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al actualizar");
            return false;
        }finally{
                try {
                    if(con!=null) con.rollback();
                    if(pstm!=null) pstm.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
        }
    }

    @Override
    public boolean deleteElemento(Planta ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteConjunto(Collection<Planta> ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
