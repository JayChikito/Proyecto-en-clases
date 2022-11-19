/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import modelo.Rol;

/**
 *
 * @author DEEPIN
 */
public class RolDao extends AdaptadorDao<Rol> {

    private Rol rol;

    public RolDao() {
        super(Rol.class);
    }

    public Rol getRol() {
        if (rol == null) {
            rol = new Rol();
        }

        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean guardar() throws Exception {
        guardar(this.rol);
        return true;
    }

    public boolean modificar(Integer pos) throws Exception {
        modificar(this.rol, pos);
        return true;
    }
    
    private Integer generarId(){
        return listar().getSize()+1;
    }
    
    public void crearRoles(){
        if(listar().estaVacia()){
            
        }
    }
}
