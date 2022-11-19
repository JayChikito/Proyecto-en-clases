/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import modelo.Persona;

/**
 *
 * @author DEEPIN
 */
public class PersonaDao extends AdaptadorDao<Persona> {

    private Persona persona;

    public PersonaDao() {
        super(Persona.class);
    }

    public Persona getPersona() {
        if (persona == null){
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public boolean guardar() throws Exception {
        this.persona.setId(generarId());
        guardar(this.persona);
        return true;
    }

    public boolean modificar(Integer pos) throws Exception {
        modificar(this.persona, pos);
        return true;
    }
    
    private Integer generarId(){
        return listar().getSize()+1;
    }
}
