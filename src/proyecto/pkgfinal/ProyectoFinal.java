/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkgfinal;

import controlador.colas.Cola;
import controlador.listas.ListaEnlazada;
import controlador.listas.excepciones.ListaNullException;
import controlador.listas.excepciones.PosicionNoEncontradaException;
import controlador.pilas.Pila;

/**
 *
 * @author DEEPIN
 */
public class ProyectoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.insertar(25);
        lista.insertar(500);
        lista.insertar(100);
        lista.insertarCabecera(300);
        try {
            lista.insertarPosicion(450, 3);
            Integer pos = 0;
            System.out.println("El objeto de la posicion " +pos+" es "+lista.obtener(pos));

        } catch (PosicionNoEncontradaException | ListaNullException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(lista.getSize());
        lista.imprimir();
 
        
        
//        Pila <String> p = new Pila<>(3);
//        Cola <String> c = new Cola<>(6);
//        try {
//            p.push("Juan");
//            p.push("Maria");
//            p.push("Pedro");
//            
//            p.imprimir();
//            System.out.println("push "+p.pop());
//            p.imprimir();
//        } catch (Exception e) {
//            System.out.println("Error" +e.getMessage());
//        }
//        
//        
//        System.out.println("--------------------------------");
//        
//        try {
//            
//            c.queue("Juan");
//            c.queue("Luis");
//            c.queue("Sauul");
//            c.imprimir();
//            
//            
//            c.dequue();
//            c.imprimir();
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
        
    }
    
    //revisar en la hora 1

    
}
 