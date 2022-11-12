/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.Mensajes;

/**
 *
 * @author Usuario
 */
public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/recursoshumanos?serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "123456";

    private Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            con.createStatement();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Mensajes.mensajeError("Error de conexion", e.getMessage());

        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

}
