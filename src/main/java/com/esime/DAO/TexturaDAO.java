/*
 *  Codigo fuente desarrollado en ESIME Culhuacan, se permite su distribución
 * solo entre alumnos de la ESIME Culhuacan con propositos academicos.
 * Prohibida su venta sin autorización de los autores
 */
package com.esime.DAO;

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
public class TexturaDAO extends Extraer<Textura>{

    @Override
    public Collection<Textura> getTodos() {
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_TEXT,NOM_TEXT FROM TEXTURA";
            
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            List<Textura> ret = new ArrayList<>();
            
            Textura textura =null;
            while(rs.next()){
                textura = new Textura();
                textura.setId_text(rs.getBigDecimal("ID_TEXT"));
                textura.setNom_text(rs.getString("NOM_TEXT"));
                ret.add(textura);
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
    public Collection<Textura> getPorID(int id) {
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_TEXT,NOM_TEXT FROM TEXTURA WHERE ID_TEXT = ?";
            
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, new BigDecimal(id));
            rs = pstm.executeQuery();
            
            List<Textura> ret = new ArrayList<>();
            
            Textura textura =null;
            while(rs.next()){
                textura = new Textura();
                textura.setId_text(rs.getBigDecimal("ID_TEXT"));
                textura.setNom_text(rs.getString("NOM_TEXT"));
                ret.add(textura);
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
    public boolean setElemento(Textura ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE TEXTURA SET "
                    + "ID_TEXT = ?, "
                    + "NOM_TEXT = ? "
                    + "WHERE ID_TEXT = ?";
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_text());
            pstm.setString(2, ele.getNom_text());
            pstm.setBigDecimal(3, ele.getId_text());
            int filasAfectadas = pstm.executeUpdate();

            if (filasAfectadas == 1) {
                con.commit();
            } else {
                throw new SQLException();
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
    public boolean setConjunto(Collection<Textura> elementos) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE TEXTURA SET "
                    + "ID_TEXT = ?, "
                    + "NOM_TEXT = ? "
                    + "WHERE ID_TEXT = ?";
            pstm = con.prepareStatement(sql);
            for(Textura ele: elementos){
                pstm = con.prepareStatement(sql);
                pstm.setBigDecimal(1, ele.getId_text());
                pstm.setString(2, ele.getNom_text());
                pstm.setBigDecimal(3, ele.getId_text());
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
    public boolean insertElemento(Textura ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO TEXTURA VALUES( ?, ?) ";

            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_text());
            pstm.setString(2, ele.getNom_text());
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
    public boolean insertConjunto(Collection<Textura> ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO TEXTURA VALUES( ?, ?) ";
            
            for(Textura x: ele){
                pstm = con.prepareStatement(sql);
                pstm.setBigDecimal(1, x.getId_text());
                pstm.setString(2, x.getNom_text());
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
    public boolean deleteElemento(Textura ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteConjunto(Collection<Textura> ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
