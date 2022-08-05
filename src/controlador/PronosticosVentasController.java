/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.PronosticoVentasModel;
import view.PronosticoVentasView;

/**
 *
 * @author Sebastián Idrobo Avirama <idrobo.sebastian@correounivalle.edu.co>
 */
public class PronosticosVentasController {

    private PronosticoVentasView vista;
    private PronosticoVentasModel modelo;

    public PronosticosVentasController(PronosticoVentasView vista, PronosticoVentasModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        this.vista.addBtnAgregarListener(new CalculateListener());
        this.vista.addBtnBorrarListener(new CalculateListener());
        this.vista.addBtnModificarListener(new CalculateListener());
        this.vista.addBtnNuevoListener(new CalculateListener());
    }
    
    class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equalsIgnoreCase("Agregar año")){
                double ventaView = vista.getVenta();
                modelo.agregarVenta(ventaView);
                String venta = Double.toString(modelo.getLastVenta().getVentas());
                System.out.println(venta);
                String anio = String.valueOf(modelo.getLastVenta().getAnio());
                System.out.println(anio);
                String diferencia = String.valueOf(modelo.getLastVenta().getDiferencia());
                System.out.println(diferencia);
                String variacion = String.valueOf(modelo.getLastVenta().getVariacion());
                System.out.println(variacion);
                Object[] fila = {anio, venta, diferencia, variacion};
                vista.addTblHistorico(fila);
                
            }
            
        }

    }

}
