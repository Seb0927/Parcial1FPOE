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
    
    //Métodos propios (PUBLICOS)
    /**
     * Agrega una venta correspondiente a "historicoVentas"
     * @param venta Venta correspondiente
     */
    public void agregarVenta(double venta){
        //Calculamos el año a ingresar a la cantidad de ventas
        int anio = historicoVentas.size();
        
        /*
        Si "historicoVentas" se encuentra vacío, añadiremos la primera venta sin "diferencia" y "variacion"
        Sino, se debe añadir con "diferencia" y "variacion"
        */
        if (historicoVentas.isEmpty()){
            Venta v = new Venta(anio, venta);
            historicoVentas.add(v);
        } else {
            Venta v = new Venta(anio, venta);
            historicoVentas.add(v);
            setDiferencia();
            setVariacion();
        }
    }
    
    //Métodos propios (PRIVADOS)
    /**
     *Establece la diferencia (Resta) entre la última venta y su anterior en la última venta
     */
    private void setDiferencia(){
        //Obtiene la diferencia entre la última venta, con la penúltima venta
        double diferencia = historicoVentas.get(historicoVentas.size() - 1).getVentas() - historicoVentas.get(historicoVentas.size() - 2).getVentas();
        //Establece la diferencia en la última venta
        historicoVentas.get(historicoVentas.size() - 1).setDiferencia(diferencia);
    }
    
    /**
     * Establece la varianza entre la última venta y su anterior en la última venta 
     */
    private void setVariacion(){
        //Obtiene "diferencia" del útlimo elemento de "historicoVentas"
        double diferencia = historicoVentas.get(historicoVentas.size() - 1).getDiferencia();
        //Establece la variacion en la última venta
        double variacion = diferencia/historicoVentas.get(historicoVentas.size() -2).getVentas();
        historicoVentas.get(historicoVentas.size() - 1).setVariacion(variacion);
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
