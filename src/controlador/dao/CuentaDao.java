/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import modelo.Cuenta;

/**
 *
 * @author DEEPIN
 */
public class CuentaDao extends AdaptadorDao<Cuenta> {

    private Cuenta cuenta;

    public CuentaDao() {
        super(Cuenta.class);
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public boolean guardar() throws Exception {
        guardar(this.cuenta);
        return true;
    }

    public boolean modificar(Integer pos) throws Exception {
        modificar(this.cuenta, pos);
        return true;
    }
    
    private Integer generarId(){
        return listar().getSize()+1;
    }
}
