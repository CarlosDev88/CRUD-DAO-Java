/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EstadoCivilDao;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import model.EstadoCivil;

/**
 *
 * @author Usuario
 */
public class EstadoCivilController {
    
    private EstadoCivilDao estadoCivilDao;

    public EstadoCivilController(EstadoCivilDao estadoCivilDao) {
        this.estadoCivilDao = estadoCivilDao;
    }
    
       public DefaultComboBoxModel llenarCombo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();        
        List<EstadoCivil> estadoCvil = estadoCivilDao.findAll();
        
        for(EstadoCivil e : estadoCvil){
            modelo.addElement(e.getDescripcion());
        }
        
        return modelo;
    }
    
}
