/*
 *  Codigo fuente desarrollado en ESIME Culhuacan, se permite su distribución
 * solo entre alumnos de la ESIME Culhuacan con propositos academicos.
 * Prohibida su venta sin autorización de los autores
 */
package com.esime.DAO;

import com.esime.DTO.TemporadaCrecimiento;
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
public class TemporadaCrecimientoDAO extends Extraer<TemporadaCrecimiento> {

    @Override
    public Collection<TemporadaCrecimiento> getTodos() {
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_TEMPO,NOM_TEMPO FROM TEMPORADA_CRECIMIENTO";
            
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            List<TemporadaCrecimiento> ret = new ArrayList<>();
            
            TemporadaCrecimiento tempo =null;
            while(rs.next()){
                tempo = new TemporadaCrecimiento();
                tempo.setId_tempo(rs.getBigDecimal("ID_TEMPO"));
                tempo.setNom_tempo(rs.getString("NOM_TEMPO"));
                ret.add(tempo);
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
    public  Collection<TemporadaCrecimiento> getPorID(int id) {
        try{
        con = UConnection.getConnection();
            String sql = "SELECT ID_TEMPO,NOM_TEMPO FROM TEMPORADA_CRECIMIENTO WHERE ID_TEMPO = ?";
            
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, new BigDecimal(id));
            rs = pstm.executeQuery();
            
            List<TemporadaCrecimiento> ret = new ArrayList<>();
            
            TemporadaCrecimiento tempo =null;
            while(rs.next()){
                tempo = new TemporadaCrecimiento();
                tempo.setId_tempo(rs.getBigDecimal("ID_TEMPO"));
                tempo.setNom_tempo(rs.getString("NOM_TEMPO"));
                ret.add(tempo);
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
    public boolean setElemento(TemporadaCrecimiento ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE TEMPORADA_CRECIMIENTO SET "
                    + "ID_TEMPO = ?, "
                    + "NOM_TEMPO = ? "
                    + "WHERE ID_TEMPO = ?";

            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_tempo());
            pstm.setString(2, ele.getNom_tempo());
            pstm.setBigDecimal(3, ele.getId_tempo());
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
    public boolean setConjunto(Collection<TemporadaCrecimiento> elementos) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE TEMPORADA_CRECIMIENTO SET "
                    + "ID_TEMPO = ?, "
                    + "NOM_TEMPO = ? "
                    + "WHERE ID_TEMPO = ?";
            pstm = con.prepareStatement(sql);
            for(TemporadaCrecimiento ele: elementos){
                pstm = con.prepareStatement(sql);
                pstm.setBigDecimal(1, ele.getId_tempo());
                pstm.setString(2, ele.getNom_tempo());
                pstm.setBigDecimal(3, ele.getId_tempo());
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
    public boolean insertElemento(TemporadaCrecimiento ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO TEMPORADA_CRECIMIENTO VALUES( ?, ?) ";

            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_tempo());
            pstm.setString(2, ele.getNom_tempo());
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
    public boolean insertConjunto(Collection<TemporadaCrecimiento> ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO TEMPORADA_CRECIMIENTO VALUES( ?, ?) ";
            
            for(TemporadaCrecimiento x: ele){
                pstm = con.prepareStatement(sql);
                pstm.setBigDecimal(1, x.getId_tempo());
                pstm.setString(2, x.getNom_tempo());
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
    public boolean deleteElemento(TemporadaCrecimiento ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "DELETE FROM TEMPORADA_CRECIMIENTO WHERE ID_TEMPO = ?";

            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_tempo());
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
    public boolean deleteConjunto(Collection<TemporadaCrecimiento> ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "DELETE FROM TEMPORADA_CRECIMIENTO WHERE ID_TEMPO = ?";

            pstm = con.prepareStatement(sql);
            for(TemporadaCrecimiento x: ele){
                pstm.setBigDecimal(1, x.getId_tempo());
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
    
}
