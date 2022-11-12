/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.LocalDate;


/**
 *
 * @author Usuario
 */
public class FuncionarioDTO {
    
    private int idFuncionario;
    private int numeroIdentificacion;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String sexo;
    private LocalDate fechaNacimiento;
    private String descriptcionTipoIdentificacion;
    private String descripcionEstadoCivil;

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDescriptcionTipoIdentificacion() {
        return descriptcionTipoIdentificacion;
    }

    public void setDescriptcionTipoIdentificacion(String descriptcionTipoIdentificacion) {
        this.descriptcionTipoIdentificacion = descriptcionTipoIdentificacion;
    }

    public String getDescripcionEstadoCivil() {
        return descripcionEstadoCivil;
    }

    public void setDescripcionEstadoCivil(String descripcionEstadoCivil) {
        this.descripcionEstadoCivil = descripcionEstadoCivil;
    }
    
    
    
}
