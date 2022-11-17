/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkgfinal;

import controlador.colas.Cola;
import controlador.dao.AdaptadorDao;
import controlador.listas.ListaEnlazada;
import controlador.listas.excepciones.ListaNullException;
import controlador.listas.excepciones.PosicionNoEncontradaException;
import controlador.pilas.Pila;
import controlador.utiles.Utilidades;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import modelo.Persona;
import modelo.Rol;

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

//        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
//        lista.insertar(25);
//        lista.insertar(500);
//        lista.insertar(100);
//        lista.insertarCabecera(300);
//        try {
//            lista.insertarPosicion(450, 3);
//            Integer pos = 2;
//            System.out.println("El objeto de la posicion " + pos + " es " + lista.obtener(pos-1));
//            lista.imprimir();
//            lista.insertarPosicion(9, 0);
//            lista.insertarPosicion(450, 3);
//            lista.imprimir();
//        } catch (PosicionNoEncontradaException | ListaNullException e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println(lista.getSize());
//        lista.imprimir();
////                     
////        System.out.println("\n***************************PILA***************************\n");
//
////        Pila<String> p = new Pila<>(3);
////        Cola<String> c = new Cola<>(4);
////        try {
////            p.push("Juan");
////            p.push("Maria");
////            p.push("Pedro");
////
////            p.imprimir();
////            System.out.println("push " + p.pop());
////            p.imprimir();
////        } catch (Exception e) {
////            System.out.println("Error" + e.getMessage());
////        }
////
////        System.out.println("\n***************************COLA***************************\n");
////
////        try {
////
////            c.queue("Juan");
////            c.queue("Luis");
////            c.queue("Sauul");
////            c.queue("Denji");
////            c.imprimir();
////
////            c.dequue();
////            c.imprimir();
////        } catch (Exception e) {
////            System.out.println("Error: " + e.getMessage());
////        }
//
//        AdaptadorDao<Rol> ad = new AdaptadorDao<Rol>(Rol.class);
//        Rol aux = new Rol();
//        aux.setId(2);
//        aux.setNombre("Cajero");
//        aux.setDescripcion("Si hace algo xd");
//        try {
//            ad.guardar(aux);
////            ad.guardar(aux);
//            //ad.listar();
//            ad.listar().imprimir();
////            System.out.println(Utilidades.capitalizar("hola"));
//            //Field a = Utilidades.obtenerAtributo(Rol.class, "id");
//            //System.out.println(a.getType().getSimpleName());
//        } catch (Exception e) {
//            System.out.println(e);
//
//        }

        AdaptadorDao<Persona> ad = new AdaptadorDao<>(Persona.class);
        try {
            Persona p = new Persona();
            p.setApellido("White");
            p.setNombre("Walter");
            p.setDireccion("Laboratorio de Ohio");
            p.setId(3);
            ad.guardar(p);
        } catch (Exception e) {
            System.out.println(e);
        }

    

    }

    //revisar 01:30:00
}
