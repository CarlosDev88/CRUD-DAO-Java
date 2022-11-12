/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDao;
import model.Funcionario;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class FuncionarioController {
     private FuncionarioDao funcionarioDao;

    public FuncionarioController(FuncionarioDao funcionarioDao) {
        this.funcionarioDao = funcionarioDao;
    }
     
    public DefaultTableModel llenarTabla() {
        DefaultTableModel model = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        model.addColumn("id");
        model.addColumn("identificacion");
        model.addColumn("nombre");
        model.addColumn("apellido");
        model.addColumn("telefono");
        model.addColumn("direccion");
        model.addColumn("sexo");
        model.addColumn("fecha nac");
        List<Funcionario> funcionarios = funcionarioDao.findAll();
        String [] registros = new String[20];
        for(Funcionario f : funcionarios){
            registros[0] = String.valueOf(f.getIdFuncionario());
            registros[1] = String.valueOf(f.getNumeroIdentificacion());
            registros[2] = f.getNombre();
            registros[3] = f.getApellido();
            registros[4] = f.getTelefono();
            registros[5] = f.getDireccion();
            registros[6] = f.getSexo();
            registros[7] = f.getFechaNacimiento().toString();
            
            model.addRow(registros);
            
        }
        return model;
    }
    
    public Funcionario listarPorDocumento(int documento){        
        return funcionarioDao.findByDocumento(documento);
    }
    
    public int guardar(Funcionario funcionario){
        return funcionarioDao.save(funcionario);
    }
    
    public void actualizar(Funcionario funcionario) {
        funcionarioDao.update(funcionario);
    }
    
     public void borrar(int documento){
         funcionarioDao.delete(documento);
    }
}
