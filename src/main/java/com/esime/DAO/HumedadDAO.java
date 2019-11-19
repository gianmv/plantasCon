/*
 *  Codigo fuente desarrollado en ESIME Culhuacan, se permite su distribución
 * solo entre alumnos de la ESIME Culhuacan con propositos academicos.
 * Prohibida su venta sin autorización de los autores
 */
package com.esime.DAO;

import com.esime.DTO.Humedad;
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
public class HumedadDAO extends Extraer<Humedad>{

    @Override
    public Collection<Humedad> getTodos() {
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_HUME,GRAD_HUME FROM HUMEDAD";
            
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            List<Humedad> ret = new ArrayList<>();
            
            Humedad humed =null;
            while(rs.next()){
                humed = new Humedad();
                humed.setId_hume(rs.getBigDecimal("ID_HUME"));
                humed.setGrad_hume(rs.getBigDecimal("GRAD_HUME"));
                ret.add(humed);
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
    public Collection<Humedad> getPorID(int id) {
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_HUME,GRAD_HUME FROM HUMEDAD WHERE ID_HUME = ?";
            
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, new BigDecimal(id));
            rs = pstm.executeQuery();
            
            List<Humedad> ret = new ArrayList<>();
            
            Humedad humed =null;
            while(rs.next()){
                humed = new Humedad();
                humed.setId_hume(rs.getBigDecimal("ID_HUME"));
                humed.setGrad_hume(rs.getBigDecimal("GRAD_HUME"));
                ret.add(humed);
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
    public boolean setElemento(Humedad ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE HUMEDAD SET "
                    + "ID_HUME = ?, "
                    + "GRAD_HUME = ? "
                    + "WHERE ID_HUME = ?";
            
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_hume());
            pstm.setBigDecimal(2, ele.getGrad_hume());
            pstm.setBigDecimal(3, ele.getId_hume());
            int filasAfectadas = pstm.executeUpdate();

            if (filasAfectadas == 1) {
                con.commit();
                return true;
            } else {
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
    public boolean setConjunto(Collection<Humedad> elementos) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE HUMEDAD SET "
                    + "ID_HUME = ?, "
                    + "GRAD_HUME = ? "
                    + "WHERE ID_HUME = ?";
            pstm = con.prepareStatement(sql);
            for(Humedad ele: elementos){
                pstm = con.prepareStatement(sql);
                pstm.setBigDecimal(1, ele.getId_hume());
                pstm.setBigDecimal(2, ele.getGrad_hume());
                pstm.setBigDecimal(3, ele.getId_hume());
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
    public boolean insertElemento(Humedad ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO HUMEDAD VALUES( ?, ?) ";

            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_hume());
            pstm.setBigDecimal(2, ele.getGrad_hume());
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
    public boolean insertConjunto(Collection<Humedad> ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO HUMEDAD VALUES( ?, ?) ";
            
            for(Humedad x: ele){
                pstm = con.prepareStatement(sql);
                pstm.setBigDecimal(1, x.getId_hume());
                pstm.setBigDecimal(2, x.getGrad_hume());
                pstm.executeUpdate();
            }
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
    public boolean deleteElemento(Humedad ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteConjunto(Collection<Humedad> ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
