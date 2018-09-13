/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author mati
 */
public class EstadoCalculadora implements Serializable {

    double valor = 0;
    int operacioActiva = Constants.IGUAL;
    double resultat = 0;

    public EstadoCalculadora(double v, int o, double r) {
        this.valor = v;
        this.operacioActiva = o;
        this.resultat = r;
    }

    public EstadoCalculadora() {
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getOperacioActiva() {
        return operacioActiva;
    }

    public void setOperacioActiva(int operacioActiva) {
        this.operacioActiva = operacioActiva;
    }

    public double getResultat() {
        return resultat;
    }

    public void setResultat(double resultat) {
        this.resultat = resultat;
    }

    @Override
    public String toString() {
        return "EstadoCalculadora{" + "valor=" + valor + ", operacioActiva=" + operacioActiva + ", resultat=" + resultat + '}';
    }
    

}
