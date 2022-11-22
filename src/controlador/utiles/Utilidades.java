/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.utiles;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author DEEPIN
 */
public class Utilidades {

    public static String capitalizar(String nombre) {
        char[] aux = nombre.toCharArray();
        aux[0] = Character.toUpperCase(aux[0]);
        return new String(aux);
    }

    public static Field obtenerAtributo(Class clase, String nombre) {
        Field atributo = null;
        for (Field aux : clase.getDeclaredFields()) {
            if (nombre.equalsIgnoreCase(aux.getName())) {
                atributo = aux;
                break;
            }
        }
        return atributo;
    }

    public static Object transformarDato(Field atributo, String dato) {
        Object transformar = null;
        if (atributo.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
            if (atributo.getType().getSimpleName().equals("Intger")) {
                transformar = Integer.parseInt(dato);
            }
        } else if (atributo.getType().isEnum()) {
            Enum enumeracion = Enum.valueOf((Class) atributo.getType(), dato.toString());
            transformar = enumeracion;

        } else {
            transformar = dato;
        }
        return transformar;

    }

    public static String encriptar(String dato) {
        return Base64.getEncoder().encodeToString(dato.getBytes());
    }

    public static String desencriptar(String dato) {
        return new String(Base64.getDecoder().decode(dato));
    }

    //*********************************************************************\\
    public static SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] claveEncription = clave.getBytes("UTF-8");

        claveEncription = Arrays.copyOf(claveEncription, 16);
        SecretKeySpec keySpec = new SecretKeySpec(claveEncription, "AES");
        return keySpec;
    }

    public static String encriptarClave(final String datos, final String claveSecreta) throws InvalidKeyException, NoSuchPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException {
        byte[] decodeKey = Base64.getDecoder().decode(claveSecreta);
        SecretKey secretKeySpec = crearClave(new String(decodeKey));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] bytesEncriptados = cipher.doFinal(datos.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(bytesEncriptados);
    }

    public static String desencriptarClave(final String datos, final String claveSecreta) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        byte[] decodeKey = Base64.getDecoder().decode(claveSecreta);
        SecretKey secretKeySpec = crearClave(new String(decodeKey));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        byte[] bytesEncriptados = Base64.getDecoder().decode(datos);
        byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
        return new String(datosDesencriptados);

    }

    public static void main(String[] args) {

        try {
            String claveSecreta = "XABC345";
            String dato = "IShowSpeed";
            System.out.println(Utilidades.encriptarClave(dato, claveSecreta));
            System.out.println(Utilidades.desencriptarClave("rWw5G4J6Iz9tllr1vOvUdQ==", "XABC345"));
            //77+9Tu+/ve+/vQkHJu+/vTTvv71W77+9byk=
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
