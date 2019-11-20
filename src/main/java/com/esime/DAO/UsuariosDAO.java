/*
 *  Codigo fuente desarrollado en ESIME Culhuacan, se permite su distribución
 * solo entre alumnos de la ESIME Culhuacan con propositos academicos.
 * Prohibida su venta sin autorización de los autores
 */
package com.esime.DAO;


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
public class UsuariosDAO extends Extraer<Usuarios>{

    @Override
    public Collection<Usuarios> getTodos() {
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_USUA,NOM_USUA,PRIAPE_USUA,";
            sql+="SEGAPE_USUA, NOM_ADMINIS,CONTRASENIA,CORREO ";
            sql+="FROM USUARIOS";
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
            
            List<Usuarios> ret = new ArrayList<>();
            
            Usuarios usua =null;
            while(rs.next()){
                usua = new Usuarios();
                usua.setContrasenia(rs.getString("CONTRASENIA"));
                usua.setCorreo(rs.getString("CORREO"));
                usua.setId_usua(rs.getBigDecimal("ID_USUA"));
                usua.setNom_adminis(rs.getString("NOM_ADMINIS"));
                usua.setNom_usua(rs.getString("NOM_USUA"));
                usua.setPriape_usua(rs.getString("PRIAPE_USUA"));
                usua.setSegape_usua(rs.getString("SEGAPE_USUA"));
                ret.add(usua);
            }
            return ret;            
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        finally{
                try {
                    if(rs!=null) rs.close();
                    if(pstm!=null) pstm.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
        }
    }

    @Override
    public Collection<Usuarios> getPorID(int id) {
        try {
            con = UConnection.getConnection();
            String sql = "SELECT ID_USUA,NOM_USUA,PRIAPE_USUA,";
            sql+="SEGAPE_USUA, NOM_ADMINIS,CONTRASENIA,CORREO ";
            sql+="FROM USUARIOS WHERE ID_USUA = ?";
            
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, new BigDecimal(id));
            rs = pstm.executeQuery();
            
            List<Usuarios> ret = new ArrayList<>();
            
            Usuarios usua =null;
            while(rs.next()){
                usua = new Usuarios();
                usua.setContrasenia(rs.getString("CONTRASENIA"));
                usua.setCorreo(rs.getString("CORREO"));
                usua.setId_usua(rs.getBigDecimal("ID_USUA"));
                usua.setNom_adminis(rs.getString("NOM_ADMINIS"));
                usua.setNom_usua(rs.getString("NOM_USUA"));
                usua.setPriape_usua(rs.getString("PRIAPE_USUA"));
                usua.setSegape_usua(rs.getString("SEGAPE_USUA"));
                ret.add(usua);
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
    public boolean setElemento(Usuarios ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE USUARIOS SET "
                    + "ID_USUA = ?, "
                    + "NOM_USUA = ?, "
                    + "PRIAPE_USUA = ?, "
                    + "SEGAPE_USUA = ?, "
                    + "NOM_ADMINIS = ?, "
                    + "CONTRASENIA = ?, "
                    + "CORREO = ? "
                    + "WHERE ID_USUA = ?";
            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_usua());
            pstm.setString(2, ele.getNom_usua());
            pstm.setString(3, ele.getPriape_usua());
            pstm.setString(4, ele.getSegape_usua());
            pstm.setString(5, ele.getNom_adminis());
            pstm.setString(6, ele.getContrasenia());
            pstm.setString(7, ele.getCorreo());
            pstm.setBigDecimal(8, ele.getId_usua());
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
    public boolean setConjunto(Collection<Usuarios> elementos) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "UPDATE USUARIOS SET "
                    + "ID_USUA = ?, "
                    + "NOM_USUA = ?, "
                    + "PRIAPE_USUA = ?, "
                    + "SEGAPE_USUA = ?, "
                    + "NOM_ADMINIS = ?, "
                    + "CONTRASENIA = ?, "
                    + "CORREO = ? "
                    + "WHERE ID_USUA = ?";
            pstm = con.prepareStatement(sql);
            for(Usuarios ele: elementos){
                pstm = con.prepareStatement(sql);
                pstm.setBigDecimal(1, ele.getId_usua());
                pstm.setString(2, ele.getNom_usua());
                pstm.setString(3, ele.getPriape_usua());
                pstm.setString(4, ele.getSegape_usua());
                pstm.setString(5, ele.getNom_adminis());
                pstm.setString(6, ele.getContrasenia());
                pstm.setString(7, ele.getCorreo());
                pstm.setBigDecimal(8, ele.getId_usua());
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
    public boolean insertElemento(Usuarios ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO USUARIOS VALUES(?,?,?,?,?,?,?) ";

            pstm = con.prepareStatement(sql);
            pstm.setBigDecimal(1, ele.getId_usua());
            pstm.setString(2, ele.getNom_usua());
            pstm.setString(3, ele.getPriape_usua());
            pstm.setString(4, ele.getSegape_usua());
            pstm.setString(5, ele.getNom_adminis());
            pstm.setString(6, ele.getContrasenia());
            pstm.setString(7, ele.getCorreo());
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
    public boolean insertConjunto(Collection<Usuarios> ele) {
        try {
            con = UConnection.getConnection();
            con.setAutoCommit(false);
            String sql = "INSERT INTO USUARIOS VALUES(?,?,?,?,?,?,?) ";
            
            for(Usuarios x: ele){
                pstm = con.prepareStatement(sql);
                pstm.setBigDecimal(1, x.getId_usua());
                pstm.setString(2, x.getNom_usua());
                pstm.setString(3, x.getPriape_usua());
                pstm.setString(4, x.getSegape_usua());
                pstm.setString(5, x.getNom_adminis());
                pstm.setString(6, x.getContrasenia());
                pstm.setString(7, x.getCorreo());
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
    public boolean deleteElemento(Usuarios ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteConjunto(Collection<Usuarios> ele) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
