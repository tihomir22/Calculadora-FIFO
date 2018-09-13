/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.MiObjectOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.EstadoCalculadora;

/**
 *
 * @author mati
 */
public class mainV3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String nombreFichero = "FicheroEstadoCalculadora.obj";
        File fichero = new File(nombreFichero);

        EstadoCalculadora ec1 = new EstadoCalculadora(100, 1, 0);
        EstadoCalculadora ec2 = new EstadoCalculadora(10, 1, 100);
        EstadoCalculadora ec3 = new EstadoCalculadora(100, 1, 110);
        EstadoCalculadora ec4 = new EstadoCalculadora(0, 0, 200);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
            oos.writeObject(ec1);
            oos.writeObject(ec2);
            oos.writeObject(ec3);
            oos.writeObject(ec4);
            oos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainV3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(mainV3.class.getName()).log(Level.SEVERE, null, ex);
        }

        EstadoCalculadora ec5 = new EstadoCalculadora(200, 2, 0);
        EstadoCalculadora ec6 = new EstadoCalculadora(20, 2, 100);
        EstadoCalculadora ec7 = new EstadoCalculadora(200, 2, 110);
        EstadoCalculadora ec8 = new EstadoCalculadora(0, 0, 200);
        ObjectOutputStream oos2 = null;
        try {
            oos2 = new MiObjectOutputStream(new FileOutputStream(fichero, true));
            oos2.writeObject(ec5);
            oos2.writeObject(ec6);
            oos2.writeObject(ec7);
            oos2.writeObject(ec8);
            oos2.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainV3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(mainV3.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Recuperación de información");
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            EstadoCalculadora lecturaOb = null;
            do {
                lecturaOb = (EstadoCalculadora) ois.readObject();
                System.out.println(lecturaOb);
            } while (lecturaOb != null);
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainV3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Final del fichero");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mainV3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
