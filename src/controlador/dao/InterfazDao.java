/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.listas.ListaEnlazada;

/**
 *
 * @author DEEPIN
 */
public interface InterfazDao<T> {

    public void guardar(T dato);

    public void modificar(T dato);
    public ListaEnlazada<T> listar();
    public T obtener (Integer id);

}
