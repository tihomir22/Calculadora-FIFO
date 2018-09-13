/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
import modelo.MiObjectOutputStream;
import vista.mainV1;
import vista.mainV3;

/**
 *
 * @author mati
 */
public class FicheroEstado {

    File fichero;

    public FicheroEstado(File fichero) {
        this.fichero = fichero;
    }

    public FicheroEstado(String nombre) {
        this.fichero = new File(nombre);
    }

    public void guardar(EstadoCalculadora estado) {
        //EstadoCalculadora ec1 = new EstadoCalculadora(1, 1, 0);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fichero));
            oos.writeObject(estado);
            oos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainV1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(mainV1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void añadir(EstadoCalculadora estado) {
        //EstadoCalculadora ec1 = new EstadoCalculadora(1, 1, 0);
        ObjectOutputStream oos = null;
        try {
            oos = new MiObjectOutputStream(new FileOutputStream(fichero, true));
            oos.writeObject(estado);
            oos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainV1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(mainV1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void verTodos() {
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

    public EstadoCalculadora obtener() {
        System.out.println("Recuperación de información");
        EstadoCalculadora ec2 = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
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
        return ec2;
    }

}
