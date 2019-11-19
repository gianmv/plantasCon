/*
 *  Codigo fuente desarrollado en ESIME Culhuacan, se permite su distribución
 * solo entre alumnos de la ESIME Culhuacan con propositos academicos.
 * Prohibida su venta sin autorización de los autores
 */
package com.esime.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import com.esime.plantascons.UConnection;

/**
 *
 * @author Giancarlo Mo.Ve.
 */
public abstract class Extraer<T> {
    protected Connection con = null;
    protected PreparedStatement pstm = null;
    protected ResultSet rs = null;
    
    abstract public Collection<T> getTodos();
    abstract public Collection<T> getPorID(int id);
    abstract public boolean setElemento(T ele);
    abstract public boolean setConjunto(Collection<T> elementos);
    abstract public boolean insertElemento(T ele);
    abstract public boolean insertConjunto(Collection<T> ele);
    abstract public boolean deleteElemento(T ele);
    abstract public boolean deleteConjunto(Collection<T> ele);
}
