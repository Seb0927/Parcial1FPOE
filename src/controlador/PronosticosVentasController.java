/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
        this.vista.addBtnPronosticoListener(new CalculateListener());
    }
    
    class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equalsIgnoreCase("Agregar año")){
                double ventaView = vista.getVenta();
                modelo.agregarVenta(ventaView);
                String venta = Double.toString(modelo.getLastVenta().getVentas());
                String anio = String.valueOf(modelo.getLastVenta().getAnio());
                String diferencia = String.valueOf(modelo.getLastVenta().getDiferencia());
                String variacion = String.valueOf(modelo.getLastVenta().getVariacion());
                Object[] fila = {anio, venta, diferencia, variacion};
                vista.addTblHistorico(fila);
            }
            
            if (e.getActionCommand().equalsIgnoreCase("Borrar año")){
                int indice = vista.getSelectedRow();
                modelo.eliminarVenta(indice);
                vista.removeAllRowsVentas();
                for (int i = 0; i < modelo.getHistoricoVentas().size(); i++){
                    String venta = Double.toString(modelo.getVenta(i).getVentas());
                    String anio = String.valueOf(modelo.getVenta(i).getAnio());
                    String diferencia = String.valueOf(modelo.getVenta(i).getDiferencia());
                    String variacion = String.valueOf(modelo.getVenta(i).getVariacion());
                    Object[] fila = {anio, venta, diferencia, variacion};
                    vista.addTblHistorico(fila);
                }
                
            }
            
            if (e.getActionCommand().equalsIgnoreCase("Realizar pronóstico")){
                modelo.calcularVariacion();
                int anios = (int) vista.getCantidad();
                modelo.calcularPronosticoVentas(anios);
                for (int i = 0; i < modelo.getPronosticoVentas().size(); i++){
                    System.out.println("size: " + modelo.getPronosticoVentas().size());
                    String anio = String.valueOf(modelo.getPronostico(i).getAnio());
                    String venta = Double.toString(modelo.getPronostico(i).getVentas());
                    Object[] fila = {anio, venta};
                    vista.addTblPronostico(fila);
                }
            }
            
            if (e.getActionCommand().equalsIgnoreCase("Modifica año")){
                JOptionPane.showMessageDialog(null,"Profe, no me alcanzó el tiempo :c");
            }
            
            if (e.getActionCommand().equalsIgnoreCase("Nuevo Pronóstico")){
                vista.removeAllRowsVentas();
                vista.removeAllRowsPronosticos();
                modelo.nuevoPronostico();
                
            }
            
            
        }

    }

}
