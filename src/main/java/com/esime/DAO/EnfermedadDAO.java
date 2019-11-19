/*
 *  Codigo fuente desarrollado en ESIME Culhuacan, se permite su distribución
 * solo entre alumnos de la ESIME Culhuacan con propositos academicos.
 * Prohibida su venta sin autorización de los autores
 */
package com.esime.DAO;

import com.esime.DTO.Enfermedad;
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
public class EnfermedadDAO extends Extraer<Enfermedad> {

    @Override
    public Collection<Enfermedad> getTodos() {
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_ENFER,NOM_ENFER,NOM_CIEN_ENFER,ID_SINTO FROM ENFERMEDAD";
            
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            List<Enfermedad> ret = new ArrayList<>();
            
            Enfermedad enfe =null;
            while(rs.next()){
                enfe = new Enfermedad();
                enfe.setId_enfer(rs.getBigDecimal("ID_ENFER"));
                enfe.setNom_cien_enfer(rs.getString("NOM_CIEN_ENFER"));
                enfe.setNom_efer(rs.getString("NOM_ENFER"));
                enfe.setId_sinto(rs.getBigDecimal("ID_SINTO"));
                ret.add(enfe);
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
    public Collection<Enfermedad> getPorID(int id) {
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_ENFER,NOM_ENFER,NOM_CIEN_ENFER,ID_SINTO FROM ENFERMEDAD";
            sql+=" WHERE ID_ENFER = ?";
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1,new BigDecimal(id));
            rs = pstm.executeQuery();
            
            List<Enfermedad> ret = new ArrayList<>();
            
            Enfermedad enfe =null;
            while(rs.next()){
                enfe = new Enfermedad();
                enfe.setId_enfer(rs.getBigDecimal("ID_ENFER"));
                enfe.setNom_cien_enfer(rs.getString("NOM_CIEN_ENFER"));
                enfe.setNom_efer(rs.getString("NOM_ENFER"));
                enfe.setId_sinto(rs.getBigDecimal("ID_SINTO"));
                ret.add(enfe);
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
    public boolean setElemento(Enfermedad ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE ENFERMEDAD SET "
                    + "ID_ENFER = ?, "
                    + "NOM_ENFER = ?, "
                    + "NOM_CIEN_ENFER = ?,"
                    + "ID_SINTO = ? "
                    + "WHERE ID_ENFER = ?";
            
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_enfer());
            pstm.setString(2, ele.getNom_efer());
            pstm.setString(3, ele.getNom_cien_enfer());
            pstm.setBigDecimal(4, ele.getId_sinto());
            pstm.setBigDecimal(5, ele.getId_enfer());
                
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
    public boolean setConjunto(Collection<Enfermedad> elementos) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE ENFERMEDAD SET "
                    + "ID_ENFER = ?, "
                    + "NOM_ENFER = ?, "
                    + "NOM_CIEN_ENFER = ?,"
                    + "ID_SINTO = ? "
                    + "WHERE ID_ENFER = ?";
            pstm = con.prepareStatement(sql);
            for(Enfermedad ele: elementos){
                pstm.setBigDecimal(1, ele.getId_enfer());
                pstm.setString(2, ele.getNom_efer());
                pstm.setString(3, ele.getNom_cien_enfer());
                pstm.setBigDecimal(4, ele.getId_sinto());
                pstm.setBigDecimal(5, ele.getId_enfer());
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
    public boolean insertElemento(Enfermedad ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertConjunto(Collection<Enfermedad> ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteElemento(Enfermedad ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteConjunto(Collection<Enfermedad> ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
