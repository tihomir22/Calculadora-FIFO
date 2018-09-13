/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.FicheroEstado;
import java.io.File;
import java.util.Scanner;
import modelo.EstadoCalculadora;

/**
 *
 * @author mati
 */
public class mainV4 {

    public static void main(String[] args) {
        File ficheroTiho = new File("ficheroTiho.obj");
        FicheroEstado fe = new FicheroEstado(ficheroTiho);
        EstadoCalculadora activa = null;
        double valor, resultat;
        int operacion;
        Scanner teclado = new Scanner(System.in);
        int opcion = 99;

        while (opcion != 0) {
            mostrarMenu();
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    teclado.nextLine();
                    ficheroTiho = new File(teclado.nextLine());
                    System.out.println("La ruta será " + ficheroTiho.getAbsolutePath());
                    break;

                case 2:
                    System.out.println("Introduzca valor ");
                    valor = teclado.nextDouble();
                    System.out.println("Introduzca operacion aritmetica 0 IGUAL 1 SUMA 2 RESTA 3 MULTI 4 DIVISION");
                    operacion = teclado.nextInt();
                    System.out.println("Introduzca resultado");
                    resultat = teclado.nextDouble();
                    activa = new EstadoCalculadora(valor, operacion, resultat);
                    break;

                case 3:
                    fe.guardar(activa);
                    System.out.println("Escrito con exito");
                    break;
                case 4:
                    fe.verTodos();
                    break;

                case 5:
                    fe.añadir(activa);
                    break;
            }
            System.out.println(ficheroTiho.getAbsolutePath());
        }

    }

    public static void mostrarMenu() {
        System.out.println("1.Especificar fichero en concreto donde guardar los datos");
        System.out.println("2.-Dar de alta un estado calculadora y seleccionarlo");
        System.out.println("3.-Añadir el objeto seleccionado al fichero sin Append");
        System.out.println("4.-Mostrar todos los objetos guardados");
        System.out.println("5.-Añadir el objeto seleccionado al fichero con Appendf");
    }
}
