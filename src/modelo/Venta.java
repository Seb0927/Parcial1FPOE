a/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Sebastián Idrobo Avirama <idrobo.sebastian@correounivalle.edu.co>
 */
public class Venta {
    int anio;
    double cantidadVentas;
    double diferencia;
    double porcentajeVariacion;
    
    //Constructores
    public Venta(int anio, double cantidadVentas) {
        this.anio = anio;
        this.cantidadVentas = cantidadVentas;
    }

    public Venta(int anio, double cantidadVentas, double diferencia, double porcentajeVariacion) {
        this.anio = anio;
        this.cantidadVentas = cantidadVentas;
        this.diferencia = diferencia;
        this.porcentajeVariacion = porcentajeVariacion;
    }
    
    //Getter's & Setter's
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(double cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public double getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(double diferencia) {
        this.diferencia = diferencia;
    }

    public double getPorcentajeVariacion() {
        return porcentajeVariacion;
    }

    public void setPorcentajeVariacion(double porcentajeVariacion) {
        this.porcentajeVariacion = porcentajeVariacion;
    }
    
    
    
}
