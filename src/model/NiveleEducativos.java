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
public class NiveleEducativos {

    private int idNivel;
    private String nombre;
    private String descripcion;

    public NiveleEducativos() {
    }

    public NiveleEducativos(int id_nivel) {
        this.idNivel = id_nivel;
    }

    public int getId_nivel() {
        return idNivel;
    }

    public void setId_nivel(int id_nivel) {
        this.idNivel = id_nivel;
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
