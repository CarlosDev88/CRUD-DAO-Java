/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public interface Mensajes {

    public static void mostrarMensaje(String titulo, String msg, int tipo) {
        JOptionPane.showMessageDialog(null, msg, titulo, tipo);
    }
    
     public static void mensajeError(String titulo, String msg) {
        mostrarMensaje( titulo, msg, JOptionPane.ERROR_MESSAGE);
    }

    public static boolean mensajeConfirm(String titulo, String msg) {
        JOptionPane jp = new JOptionPane();
        return jp.showConfirmDialog(null, msg, titulo, jp.YES_NO_OPTION) == jp.YES_OPTION;
    }

}
