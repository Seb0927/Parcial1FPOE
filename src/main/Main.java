/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controlador.PronosticosVentasController;
import modelo.PronosticoVentasModel;
import view.PronosticoVentasView;

/**
 *
 * @author sebas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PronosticoVentasView v = new PronosticoVentasView();
        PronosticoVentasModel m = new PronosticoVentasModel();
        PronosticosVentasController c = new PronosticosVentasController(v,m);
    }
    
}
