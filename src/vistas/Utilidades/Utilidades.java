/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.Utilidades;

import javax.swing.JComboBox;
import modelo.enums.TipoIdentificacion;

/**
 *
 * @author DEEPIN
 */
public class Utilidades {

    public static void cargarTipoIndentificacion(JComboBox cbx) {
        cbx.removeAllItems();
        for (TipoIdentificacion tipo : TipoIdentificacion.values()) {
            cbx.addItem(tipo);
        }
    }

    public static TipoIdentificacion obtenerTipoIdentificacion(JComboBox cbx) {
        return (TipoIdentificacion) cbx.getSelectedItem();
    }


}
