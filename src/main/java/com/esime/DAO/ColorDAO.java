/*
 *  Codigo fuente desarrollado en ESIME Culhuacan, se permite su distribución
 * solo entre alumnos de la ESIME Culhuacan con propositos academicos.
 * Prohibida su venta sin autorización de los autores
 */
package com.esime.DAO;

import com.esime.DTO.Color;
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
public class ColorDAO extends Extraer<Color>{
    
    @Override
    public Collection<Color> getTodos(){
  
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_COLOR,NOM_COLOR FROM COLOR";
            
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            List<Color> ret = new ArrayList<>();
            
            Color color =null;
            while(rs.next()){
                color = new Color();
                color.setId_color(rs.getBigDecimal("ID_COLOR"));
                color.setNom_color(rs.getString("NOM_COLOR"));
                ret.add(color);
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
    public Collection<Color> getPorID(int color_id){
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_COLOR,NOM_COLOR FROM COLOR WHERE ID_COLOR = ?";
            
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, new BigDecimal(color_id));
            rs = pstm.executeQuery();
            
            List<Color> ret = new ArrayList<>();
            
            Color color =null;
            while(rs.next()){
                color = new Color();
                color.setId_color(rs.getBigDecimal("ID_COLOR"));
                color.setNom_color(rs.getString("NOM_COLOR"));
                ret.add(color);
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
    /**
     * El parametro Color ele debe tener una ide valida para poder actualizar
     * la base de datos.
     */
    public boolean setElemento(Color ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE COLOR SET "
                    + "ID_COLOR = ?, "
                    + "NOM_COLOR = ? "
                    + "WHERE ID_COLOR = ?";

            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_color());
            pstm.setString(2, ele.getNom_color());
            pstm.setBigDecimal(3, ele.getId_color());
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
    public boolean setConjunto(Collection<Color> elementos) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE COLOR SET "
                    + "ID_COLOR = ?, "
                    + "NOM_COLOR = ? "
                    + "WHERE ID_COLOR = ?";
            pstm = con.prepareStatement(sql);
            for(Color ele: elementos){
                pstm = con.prepareStatement(sql);
                pstm.setBigDecimal(1, ele.getId_color());
                pstm.setString(2, ele.getNom_color());
                pstm.setBigDecimal(3, ele.getId_color());
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
    public boolean insertElemento(Color ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO COLOR VALUES( ?, ?) ";

            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_color());
            pstm.setString(2, ele.getNom_color());
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
    public boolean insertConjunto(Collection<Color> ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO COLOR VALUES( ?, ?) ";

            for(Color x:ele){
                pstm = con.prepareStatement(sql);
                pstm.setBigDecimal(1, x.getId_color());
                pstm.setString(2, x.getNom_color());
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
    public boolean deleteElemento(Color ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteConjunto(Collection<Color> ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
