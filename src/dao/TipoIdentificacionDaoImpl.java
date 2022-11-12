/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import model.Conexion;
import model.TiposIdentificacion;
import utils.Mensajes;

/**
 *
 * @author Usuario
 */
public class TipoIdentificacionDaoImpl implements TipoIdentificacionDao {

    private Conexion conexion;
    private Statement st;
    private ResultSet rS;

    @Override
    public List<TiposIdentificacion> findAll() {

        List<TiposIdentificacion> tiposIds = new ArrayList<>();

        try {
            String sql = "SELECT * FROM recursoshumanos.tipo_identificacion";
            conexion = new Conexion();
            st = conexion.getCon().createStatement();
            rS = st.executeQuery(sql);
            
            while(rS.next()){
                TiposIdentificacion tipoIdentificacion = new TiposIdentificacion();
                tipoIdentificacion.setId_tipo_identificacion(rS.getInt("id_tipo_identificacion"));
                tipoIdentificacion.setNombre(rS.getString("nombre"));
                tipoIdentificacion.setDescripcion(rS.getString("descripcion"));
                tiposIds.add(tipoIdentificacion);
            }
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
             Mensajes.mensajeError("Error en la BBDD", ex.getMessage());
           
        } finally{
            try {
                st.close();
                rS.close();
                conexion.getCon().close();
            } catch (SQLException ex) {
                 System.err.println(ex.getMessage());
            }
          
        }

        return tiposIds;
    }

}
