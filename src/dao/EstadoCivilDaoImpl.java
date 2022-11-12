/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Conexion;
import model.EstadoCivil;
import utils.Mensajes;



/**
 *
 * @author Usuario
 */
public class EstadoCivilDaoImpl implements EstadoCivilDao{
    
    private Conexion conexion;
    private Statement st;
    private ResultSet rS;

    @Override
    public List<EstadoCivil> findAll() {
        List<EstadoCivil> tiposEsCvl = new ArrayList<>();
        
          try {
            String sql = "SELECT * FROM recursoshumanos.estado_civil";
            conexion = new Conexion();
            st = conexion.getCon().createStatement();
            rS = st.executeQuery(sql);
            
            while(rS.next()){
                EstadoCivil estadoCivil = new EstadoCivil();
                estadoCivil.setId_estado_civil(rS.getInt("id_estado_civil"));
                estadoCivil.setNombre(rS.getString("nombre"));
                estadoCivil.setDescripcion(rS.getString("descripcion"));
                tiposEsCvl.add(estadoCivil);
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

        return tiposEsCvl;
    }
    
}
