/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

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
public class mainV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String nombreFichero = "FicheroEstadoCalculadora.obj";
        File fichero = new File(nombreFichero);

        EstadoCalculadora ec1 = new EstadoCalculadora(1, 1, 0);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
            oos.writeObject(ec1);
            oos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainV1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(mainV1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Recuperación de información");
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            EstadoCalculadora ec2 = null;
            ec2 = (EstadoCalculadora) ois.readObject();
            System.out.println(ec2);
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainV1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(mainV1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mainV1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
