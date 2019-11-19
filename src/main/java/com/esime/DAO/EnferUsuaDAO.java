/*
 *  Codigo fuente desarrollado en ESIME Culhuacan, se permite su distribución
 * solo entre alumnos de la ESIME Culhuacan con propositos academicos.
 * Prohibida su venta sin autorización de los autores
 */
package com.esime.DAO;

import com.esime.DTO.EnferUsua;
import com.esime.DTO.Enfermedad;
import com.esime.DTO.Usuarios;
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
public class EnferUsuaDAO extends Extraer<EnferUsua>{

    @Override
    public Collection<EnferUsua> getTodos() {
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_ENFER,ID_USUA FROM ENFER_USUA";
            
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            List<EnferUsua> ret = new ArrayList<>();
            
            EnferUsua temp =null;
            while(rs.next()){
                temp = new EnferUsua();
                int idEnfe = rs.getBigDecimal("ID_ENFER").intValue();
                int idUsua = rs.getBigDecimal("ID_USUA").intValue();
                
                temp.setEnfer(getEnfermedad(idEnfe));
                temp.setUsua(getUsuarios(idUsua));
                ret.add(temp);
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
    public Collection<EnferUsua> getPorID(int id) {
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_ENFER,ID_USUA FROM ENFER_USUA WHERE ID_ENFER = ?";
            
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, new BigDecimal(id));
            rs = pstm.executeQuery();
            
            List<EnferUsua> ret = new ArrayList<>();
            
            EnferUsua temp =null;
            while(rs.next()){
                temp = new EnferUsua();
                int idEnfe = rs.getBigDecimal("ID_ENFER").intValue();
                int idUsua = rs.getBigDecimal("ID_USUA").intValue();
                
                temp.setEnfer(getEnfermedad(idEnfe));
                temp.setUsua(getUsuarios(idUsua));
                ret.add(temp);
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
    
    public Collection<EnferUsua> getEnfermedadID(int id){
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_ENFER,ID_USUA FROM ENFER_USUA WHERE ID_ENFER = ?";
            
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, new BigDecimal(id));
            rs = pstm.executeQuery();
            
            List<EnferUsua> ret = new ArrayList<>();
            
            EnferUsua temp =null;
            while(rs.next()){
                temp = new EnferUsua();
                int idEnfe = rs.getBigDecimal("ID_ENFER").intValue();
                int idUsua = rs.getBigDecimal("ID_USUA").intValue();
                
                temp.setEnfer(getEnfermedad(idEnfe));
                temp.setUsua(getUsuarios(idUsua));
                ret.add(temp);
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
    
    public Collection<EnferUsua> getUsuarioID(int id){
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_ENFER,ID_USUA FROM ENFER_USUA WHERE ID_USUA = ?";
            
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, new BigDecimal(id));
            rs = pstm.executeQuery();
            
            List<EnferUsua> ret = new ArrayList<>();
            
            EnferUsua temp =null;
            while(rs.next()){
                temp = new EnferUsua();
                int idEnfe = rs.getBigDecimal("ID_ENFER").intValue();
                int idUsua = rs.getBigDecimal("ID_USUA").intValue();
                
                temp.setEnfer(getEnfermedad(idEnfe));
                temp.setUsua(getUsuarios(idUsua));
                ret.add(temp);
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
    
    private Usuarios getUsuarios(int id){
       ArrayList<Usuarios> temp;
       UsuariosDAO t = new UsuariosDAO();
       temp = (ArrayList<Usuarios>) t.getPorID(id);
       return temp.get(0); 
    }
    
    private Enfermedad getEnfermedad(int id){
       ArrayList<Enfermedad> temp;
       EnfermedadDAO t = new EnfermedadDAO();
       temp = (ArrayList<Enfermedad>) t.getPorID(id);
       return temp.get(0);
    }
    
    /**
     * Esta función no se implementa debido a que para actualizar esta tabla
     * son necesarias dos parametros, una para seleccionar la fila a actualizar
     * y otro con los datos que se van a actualizar. Se implementa para evitar
     * que sea abstracta.
     * @param ele no usar por favor
     * @return 
     */
    @Override
    public boolean setElemento(EnferUsua ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Esta función actualiza los registros de la supertabla Enfer_Usua,
     * por lo que es nececesario manda los dos objetos de las tablas que 
     * serian nuestra identificacion, ademas de un segundo parametro, que contendrá
     * los elementos que se desean actualizar.
     * @param original de tipo EnferUsua que es el registro que se desea actualizar
     * @param nuevo de tipo EferUsa que es el registro por el cual se va a cambiar
     * @return 
     */
    public boolean setElemento(EnferUsua original,EnferUsua nuevo) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE ENFER_USUA SET "
                    + "ID_ENFER = ?, "
                    + "ID_USUA = ? "
                    + "WHERE ID_ENFER = ? AND ID_USUA = ?";
            
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, nuevo.getEnfer().getId_enfer());
            pstm.setBigDecimal(2, nuevo.getUsua().getId_usua());
            pstm.setBigDecimal(3, original.getEnfer().getId_enfer());
            pstm.setBigDecimal(4, original.getUsua().getId_usua());
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

    /**
     * Esta función no se implementa debido a que para actualizar esta tabla
     * son necesarias dos parametros, una para seleccionar la fila a actualizar
     * y otro con los datos que se van a actualizar. Se implementa para evitar
     * que sea abstracta.
     * @param elementos no usar por favor
     * @return 
     */
    @Override
    public boolean setConjunto(Collection<EnferUsua> elementos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertElemento(EnferUsua ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertConjunto(Collection<EnferUsua> ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteElemento(EnferUsua ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteConjunto(Collection<EnferUsua> ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
