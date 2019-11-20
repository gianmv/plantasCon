/*
 *  Codigo fuente desarrollado en ESIME Culhuacan, se permite su distribución
 * solo entre alumnos de la ESIME Culhuacan con propositos academicos.
 * Prohibida su venta sin autorización de los autores
 */
package com.esime.DAO;

import com.esime.DTO.Sintomas;
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
public class SintomasDAO extends Extraer<Sintomas>{

    @Override
    public Collection<Sintomas> getTodos() {
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_SINTO,NOM_SINTO FROM SINTOMAS";
            
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            List<Sintomas> ret = new ArrayList<>();
            
            Sintomas sinto =null;
            while(rs.next()){
                sinto = new Sintomas();
                sinto.setId_sinto(rs.getBigDecimal("ID_SINTO"));
                sinto.setNom_sinto(rs.getString("NOM_SINTO"));
                ret.add(sinto);
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
    public Collection<Sintomas> getPorID(int id) {
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_SINTO,NOM_SINTO FROM SINTOMAS WHERE ID_SINTO = ?";
            
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, new BigDecimal(id));
            rs = pstm.executeQuery();
            
            List<Sintomas> ret = new ArrayList<>();
            
            Sintomas sinto =null;
            while(rs.next()){
                sinto = new Sintomas();
                sinto.setId_sinto(rs.getBigDecimal("ID_SINTO"));
                sinto.setNom_sinto(rs.getString("NOM_SINTO"));
                ret.add(sinto);
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
    public boolean setElemento(Sintomas ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE SINTOMAS SET "
                    + "ID_SINTO = ?, "
                    + "NOM_SINTO = ? "
                    + "WHERE ID_SINTO = ?";

            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_sinto());
            pstm.setString(2, ele.getNom_sinto());
            pstm.setBigDecimal(3, ele.getId_sinto());
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
    public boolean setConjunto(Collection<Sintomas> elementos) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE SINTOMAS SET "
                    + "ID_SINTO = ?, "
                    + "NOM_SINTO = ? "
                    + "WHERE ID_SINTO = ?";
            pstm = con.prepareStatement(sql);
            for(Sintomas ele: elementos){
                pstm = con.prepareStatement(sql);
                pstm.setBigDecimal(1, ele.getId_sinto());
                pstm.setString(2, ele.getNom_sinto());
                pstm.setBigDecimal(3, ele.getId_sinto());
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
    public boolean insertElemento(Sintomas ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO SINTOMAS VALUES( ?, ?) ";

            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_sinto());
            pstm.setString(2, ele.getNom_sinto());
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
    public boolean insertConjunto(Collection<Sintomas> ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO SINTOMAS VALUES( ?, ?) ";
            
            for(Sintomas x: ele){
                pstm = con.prepareStatement(sql);
                pstm.setBigDecimal(1, x.getId_sinto());
                pstm.setString(2, x.getNom_sinto());
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
    public boolean deleteElemento(Sintomas ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "DELETE FROM SINTOMAS WHERE ID_SINTO = ?";

            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_sinto());
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
    public boolean deleteConjunto(Collection<Sintomas> ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "DELETE FROM SINTOMAS WHERE ID_SINTO = ?";
            
            for(Sintomas x:ele){
                pstm = con.prepareStatement(sql);
                pstm.setBigDecimal(1, x.getId_sinto());
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
