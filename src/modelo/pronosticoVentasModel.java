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
public class PronosticoVentasModel {
    ArrayList<Venta> historicoVentas;
    ArrayList<Venta> pronosticoVentas;
    int aniosPronosticados;
    int promedioVariacion;//
    
    //Constructores
    public PronosticoVentasModel() {
        historicoVentas = new ArrayList<>();
        pronosticoVentas = new ArrayList<>();
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
    
    /**
     * Elimina una determinada venta
     * @param indice indice del elemento "venta" a eliminar de "historialVentas"
     */
    public void eliminarVenta(int indice){
        //Elimina la venta indicada
        System.out.println("Indice: " + indice);
        System.out.println("Historico ventas size + " + historicoVentas.size());
        historicoVentas.remove(indice);
        System.out.println("Historico ventas size + " + historicoVentas.size());
        ArrayList<Venta> tempVentas = new ArrayList<>(historicoVentas);
        historicoVentas.removeAll(historicoVentas);
        for (int i = 0; i<tempVentas.size(); i++){
            if (i == 0){
                System.out.println("Entre aquí con: " + i);
                System.out.println("Con ventas: " + tempVentas.get(i).getVentas());
                Venta v = new Venta(i, tempVentas.get(i).getVentas());
                historicoVentas.add(v);
            } else {
                System.out.println("Entre aquí con: " + i);
                Venta v = new Venta(i, tempVentas.get(i).getVentas());
                historicoVentas.add(v);
                setDiferencia();
                setVariacion();
            }
        }
    }
    
    /**
     * Modifica una determinada venta
     * @param indice índice del elemento "venta" en "historialVentas"
     * @param ventas valor a cambiar
     */
    public void modificarVenta(int indice, double ventas){
        historicoVentas.get(indice).setVentas(ventas);
    }
    
    /**
     * Remueve todos los elementos de "historicoVentas" y "pronosticoVentas"
     * Además aniosPronosticados y promedioVariacion son establecidos en 0.
     */
    public void nuevoPronostico(){
        historicoVentas.removeAll(historicoVentas);
        pronosticoVentas.removeAll(pronosticoVentas);
        aniosPronosticados = 0;
        promedioVariacion = 0;
    }
    
    /**
     * Calcula "pronosticoVentas" y añade las respectivas ventas[Solo con año y venta]
     * a si misma.
     */
    public void calcularPronosticoVentas(){
        //Realizamos el pronostico de ventas en baso a los años pronosticados
        for (int i = 1; i <= aniosPronosticados; i++){
            //Si "pronosticoVentas" se encuentra vacío, hacer el primer pronóstico
            //del año en base del último item de "historicoVentas".
            //Sino, hacerlo en base al último item de "pronosticoVentas"
            if (pronosticoVentas.isEmpty()){
                double prVenta = historicoVentas.get(historicoVentas.size() - 1).getVentas();
                prVenta += promedioVariacion*prVenta;
                Venta v = new Venta(i+aniosPronosticados, prVenta);
                pronosticoVentas.add(v);
            } else {
                double prVenta = pronosticoVentas.get(pronosticoVentas.size() - 1).getVentas();
                prVenta += promedioVariacion*prVenta;
                Venta v = new Venta(i+aniosPronosticados, prVenta);
                pronosticoVentas.add(v);
            }
             
        }
    }
    
    public Venta getVenta(int indice){
        return historicoVentas.get(indice);
    }
    
    public Venta getLastVenta(){
        return historicoVentas.get(historicoVentas.size() - 1);
    }
    
    //Métodos propios (PRIVADOS)
    /**
     *Establece la diferencia (Resta) entre la última venta y su anterior en la última venta.
     */
    private void setDiferencia(){
        //Obtiene la diferencia entre la última venta, con la penúltima venta
        double diferencia = historicoVentas.get(historicoVentas.size() - 1).getVentas() - historicoVentas.get(historicoVentas.size() - 2).getVentas();
        //Establece la diferencia en la última venta
        historicoVentas.get(historicoVentas.size() - 1).setDiferencia(diferencia);
    }
    
    /**
     * Establece la varianza entre la última venta y su anterior en la última venta .
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
