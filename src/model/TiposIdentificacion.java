/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class TiposIdentificacion {

    private int idTipoIdentificacion;
    private String nombre;
    private String descripcion;

    public TiposIdentificacion() {
    }

    public TiposIdentificacion(int id_tipo_identificacion) {
        this.idTipoIdentificacion = id_tipo_identificacion;
    }

    public int getId_tipo_identificacion() {
        return idTipoIdentificacion;
    }

    public void setId_tipo_identificacion(int id_tipo_identificacion) {
        this.idTipoIdentificacion = id_tipo_identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

}
