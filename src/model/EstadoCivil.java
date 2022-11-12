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
public class EstadoCivil {
    private int idEstadoCivil;
    private String nombre;
    private String descripcion;

    public EstadoCivil() {
    }

    public EstadoCivil(int id_estado_civil) {
        this.idEstadoCivil = id_estado_civil;
    }
        

    public int getId_estado_civil() {
        return idEstadoCivil;
    }

    public void setId_estado_civil(int id_estado_civil) {
        this.idEstadoCivil = id_estado_civil;
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
