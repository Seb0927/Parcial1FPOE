/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Sebastián Idrobo Avirama <idrobo.sebastian@correounivalle.edu.co>
 */
public class pronosticoVentasModel {
    ArrayList<Venta> historicoVentas;
    ArrayList<Venta> pronosticoVentas;
    int aniosPronosticados;
    int promedioVariacion;
    
    //Constructores
    public pronosticoVentasModel() {
        
    }
    
    //Métodos propios
    void agregarVenta(){
        
    }
    
    
    //Getter's & Setter's
    public ArrayList<Venta> getHistoricoVentas() {
        return historicoVentas;
    }

    public void setHistoricoVentas(ArrayList<Venta> historicoVentas) {
        this.historicoVentas = historicoVentas;
    }

    public ArrayList<Venta> getPronosticoVentas() {
        return pronosticoVentas;
    }

    public void setPronosticoVentas(ArrayList<Venta> pronosticoVentas) {
        this.pronosticoVentas = pronosticoVentas;
    }

    public int getAniosPronosticados() {
        return aniosPronosticados;
    }

    public void setAniosPronosticados(int aniosPronosticados) {
        this.aniosPronosticados = aniosPronosticados;
    }

    public int getPromedioVariacion() {
        return promedioVariacion;
    }

    public void setPromedioVariacion(int promedioVariacion) {
        this.promedioVariacion = promedioVariacion;
    }
    
    
    
    
}
