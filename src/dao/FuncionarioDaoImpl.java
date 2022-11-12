/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Conexion;
import model.Funcionario;
import utils.Mensajes;

/**
 *
 * @author Usuario
 */
public class FuncionarioDaoImpl implements FuncionarioDao {

    private Conexion conexion;
    private Statement st;
    private ResultSet rS;
    private PreparedStatement pSt;

    @Override
    public List<Funcionario> findAll() {
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM recursoshumanos.funcionario";
            conexion = new Conexion();
            st = conexion.getCon().createStatement();
            rS = st.executeQuery(sql);

            while (rS.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rS.getInt("id_funcionario"));
                funcionario.setNumeroIdentificacion(rS.getInt("numero_identificacion"));
                funcionario.setNombre(rS.getString("nombre"));
                funcionario.setApellido(rS.getString("apellido"));
                funcionario.setTelefono(rS.getString("telefono"));
                funcionario.setDireccion(rS.getString("direccion"));
                funcionario.setSexo(rS.getString("sexo"));
                funcionario.setFechaNacimiento(LocalDate.parse(rS.getString("fecha_nacimiento")));
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Mensajes.mensajeError("Error en la BBDD", ex.getMessage());

        } finally {
            try {
                st.close();
                rS.close();
                conexion.getCon().close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }

        return funcionarios;
    }

    @Override
    public Funcionario findByDocumento(int documento) {
        Funcionario funcionario = new Funcionario();
        String sql = "SELECT * FROM recursoshumanos.funcionario where numero_identificacion=?";
        conexion = new Conexion();
        try {
            pSt = conexion.getCon().prepareStatement(sql);
            pSt.setInt(1, documento);
            rS = pSt.executeQuery();

            if (rS.first()) {
                funcionario.setIdFuncionario(rS.getInt("id_funcionario"));
                funcionario.setNumeroIdentificacion(rS.getInt("numero_identificacion"));
                funcionario.setNombre(rS.getString("nombre"));
                funcionario.setApellido(rS.getString("apellido"));
                funcionario.setTelefono(rS.getString("telefono"));
                funcionario.setDireccion(rS.getString("direccion"));
                funcionario.setSexo(rS.getString("sexo"));
                funcionario.setFechaNacimiento(LocalDate.parse(rS.getString("fecha_nacimiento")));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Mensajes.mensajeError("Error en la BBDD", ex.getMessage());

        } finally {
            try {
                st.close();
                rS.close();
                conexion.getCon().close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }

        return funcionario;
    }

    @Override
    public int save(Funcionario funcionario) {
        int resultado = 0;
        String sql = "INSERT INTO recursoshumanos.funcionario"
                + "("
                + "numero_identificacion,"
                + "nombre,"
                + "apellido,"
                + "telefono,"
                + "direccion,"
                + "sexo,"
                + "fecha_nacimiento,"
                + "tipo_identificacion_id_tipo_identificacion,"
                + "estado_civil_id_estado_civil)"
                + "VALUES"
                + "(?,?,?,?,?,?,?,?,?);";
        conexion = new Conexion();
        try {

            pSt = conexion.getCon().prepareStatement(sql);
            pSt.setInt(1, funcionario.getNumeroIdentificacion());
            pSt.setString(2, funcionario.getNombre());
            pSt.setString(3, funcionario.getApellido());
            pSt.setString(4, funcionario.getTelefono());
            pSt.setString(5, funcionario.getDireccion());
            pSt.setString(6, funcionario.getSexo());
            pSt.setString(7, funcionario.getFechaNacimiento().toString());
            pSt.setInt(8, funcionario.getTipoIdentificacion().getId_tipo_identificacion());
            pSt.setInt(9, funcionario.getEstadoCivil().getId_estado_civil());

            resultado = pSt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Mensajes.mensajeError("Error en la BBDD", ex.getMessage());

        } finally {
            try {
                pSt.close();
                conexion.getCon().close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }

        return resultado;
    }

    @Override
    public int update(Funcionario funcionario) {
        int resultado = 0;
        conexion = new Conexion();

        String sql = "update funcionario set numero_identificacion =?,nombre =?,apellido =?,telefono =?,direccion =?,sexo =? where  numero_identificacion=?";

        try {
            pSt = conexion.getCon().prepareStatement(sql);
            pSt.setInt(1, funcionario.getNumeroIdentificacion());
            pSt.setString(2, funcionario.getNombre());
            pSt.setString(3, funcionario.getApellido());
            pSt.setString(4, funcionario.getTelefono());
            pSt.setString(5, funcionario.getDireccion());
            pSt.setString(6, funcionario.getSexo());
            pSt.setInt(7, funcionario.getNumeroIdentificacion());

            resultado = pSt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Mensajes.mensajeError("Error en la BBDD", ex.getMessage());

        } finally {
            try {
                pSt.close();
                conexion.getCon().close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

            return resultado;
        }
    }

    @Override
    public void delete(int documento) {
        String sql = "DELETE FROM recursoshumanos.funcionario WHERE numero_identificacion=?";
        conexion = new Conexion();

        try {
            pSt = conexion.getCon().prepareStatement(sql);
            pSt.setInt(1, documento);
            pSt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Mensajes.mensajeError("Error en la BBDD", ex.getMessage());

        } finally {
            try {
                conexion.getCon().close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }
    }

}
