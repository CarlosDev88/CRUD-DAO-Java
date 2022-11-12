/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TipoIdentificacionDao;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import model.TiposIdentificacion;

/**
 *
 * @author Usuario
 */
public class TipoIdentificacionController {
    private TipoIdentificacionDao tipoIdentificacionDao;

    public TipoIdentificacionController(TipoIdentificacionDao tipoIdentificacionDao) {
        this.tipoIdentificacionDao = tipoIdentificacionDao;
    }
    
    public DefaultComboBoxModel llenarCombo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();        
        List<TiposIdentificacion> tiposIds = tipoIdentificacionDao.findAll();
        
        for(TiposIdentificacion t : tiposIds){
            modelo.addElement(t.getDescripcion());
        }
        
        return modelo;
    }
}
