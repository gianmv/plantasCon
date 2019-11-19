/*
 *  Codigo fuente desarrollado en ESIME Culhuacan, se permite su distribución
 * solo entre alumnos de la ESIME Culhuacan con propositos academicos.
 * Prohibida su venta sin autorización de los autores
 */
package com.esime.DAO;
import com.esime.DTO.Clima;
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
public class ClimaDAO extends Extraer<Clima>{        
    public Collection<Clima> getTodos(){        
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_CLIMA,NOM_CLIMA FROM CLIMA";
            
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            List<Clima> ret = new ArrayList<>();
            
            Clima clima =null;
            while(rs.next()){
                clima = new Clima();
                clima.setId_clima(rs.getBigDecimal("ID_CLIMA"));
                clima.setNom_clima(rs.getString("NOM_CLIMA"));
                ret.add(clima);
            }
            return ret;            
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Clima>();
        }finally{
                try {
                    if(rs!=null) rs.close();
                    if(pstm!=null) pstm.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            
        }
        
    }
    
    public Collection<Clima> getPorID(int clima_id){        
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_CLIMA,NOM_CLIMA FROM CLIMA WHERE ID_CLIMA = ?";
            
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, new BigDecimal(clima_id));
            rs = pstm.executeQuery();
            
            List<Clima> ret = new ArrayList<>();
            
            Clima clima =null;
            while(rs.next()){
                clima = new Clima();
                clima.setId_clima(rs.getBigDecimal("ID_CLIMA"));
                clima.setNom_clima(rs.getString("NOM_CLIMA"));
                ret.add(clima);
            }
            
            return ret;            
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Clima>();
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
    public boolean setElemento(Clima ele) {
            try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE CLIMA SET "
                    + "ID_CLIMA = ?, "
                    + "NOM_CLIMA = ? "
                    + "WHERE ID_CLIMA = ?";

            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_clima());
            pstm.setString(2, ele.getNom_clima());
            pstm.setBigDecimal(3, ele.getId_clima());
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
    public boolean setConjunto(Collection<Clima> elementos) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE CLIMA SET "
                    + "ID_CLIMA = ?, "
                    + "NOM_CLIMA = ? "
                    + "WHERE ID_CLIMA = ?";
            pstm = con.prepareStatement(sql);
            for(Clima ele: elementos){
                pstm.setBigDecimal(1, ele.getId_clima());
                pstm.setString(2, ele.getNom_clima());
                pstm.setBigDecimal(3, ele.getId_clima());
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
    
    private ArrayList<BigDecimal> getTodosLosId(){
        try{
        con = UConnection.getConnection();
        String SQLID = "SELECT ID_CLIMA FROM CLIMA";
            ArrayList<BigDecimal> ids = new ArrayList<>();
            pstm = con.prepareStatement(SQLID);
            rs = pstm.executeQuery();
            while(rs.next()){
                ids.add(rs.getBigDecimal("ID_CLIMA"));
            }
            return ids;
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return new ArrayList<BigDecimal>();
        }
    }

    @Override
    public boolean insertElemento(Clima ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            ArrayList<BigDecimal> ids = getTodosLosId();
            String sql = "INSERT INTO CLIMA VALUES( ?, ?) ";

            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_clima());
            pstm.setString(2, ele.getNom_clima());
            pstm.setBigDecimal(3, ele.getId_clima());
            pstm.executeUpdate();
            
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
    public boolean insertConjunto(Collection<Clima> ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteElemento(Clima ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteConjunto(Collection<Clima> ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
