/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import model.Funcionario;

/**
 *
 * @author Usuario
 */
public interface FuncionarioDao {
    List<Funcionario> findAll();
    Funcionario findByDocumento(int documento);
    int save(Funcionario funcionario);
    int update(Funcionario funcionario);
    void delete(int documento);
    
}
