/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Sebastián Idrobo Avirama <idrobo.sebastian@correounivalle.edu.co>
 */
public class PronosticoVentasView extends JFrame{
    
    //Métodos propios
    public JTextField getTxtVenta() {
        return txtVenta;
    }

    public void setTxtVenta(JTextField txtVenta) {
        this.txtVenta = txtVenta;
    }

    public JTextField getTxtCantidad() {
        return txtCantidad;
    }

    public void setTxtCantidad(JTextField txtCantidad) {
        this.txtCantidad = txtCantidad;
    }
    
    public void addBtnAgregarListener(ActionListener listenControles){
        btnAgregar.addActionListener(listenControles);
    }
    
    //Borrar, modificar, nuevo
    public void addBtnBorrarListener(ActionListener listenControles){
        btnBorrar.addActionListener(listenControles);
    }
    
    public void addModificarListener(ActionListener listenControles){
        btnModificar.addActionListener(listenControles);
    }
    
    public void addBtnNuevoListener(ActionListener listenControles){
        btnNuevo.addActionListener(listenControles);
    }
    
    //Atributos de la ventana -------------------------------->
    //Ancho y alto de ventana
    private int anchoV = 600;
    private int largoV = 800;
    
    //JButtons
    private JButton btnAgregar;
    private JButton btnBorrar;
    private JButton btnModificar;
    private JButton btnNuevo;
    
    //JTables
    private JTable tblHistorico;
    private JTable tblPronostico;
    
    //JLabels
    private JLabel lblVenta;
    private JLabel lblCantidad;
    
    //JTextFields
    private JTextField txtVenta;
    private JTextField txtCantidad;
    private JTextField txtPromedioVariacion;
    
    //JPanels
    private JPanel pnlDatosVenta;
    private JPanel pnlAnios;
    private JPanel pnlControles;
    private JPanel pnlVentas;
    private JPanel pnlPronostico;
    
    //JScrollPane
    private JScrollPane pnlSVentas;
    private JScrollPane pnlSPronostico;
    
    ////Border
    private Border border;
    
    public PronosticoVentasView(){
        iniciarComponentes();
        iniciarVentana();
    }
    
    private void iniciarVentana(){
        setSize(anchoV, largoV);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pronóstico de ventas");
        setResizable(false);
    }
    
    private void iniciarComponentes(){
        //Quitamos el layout del frame prinicipal
        setLayout(null);
                
        //Paneles
        pnlDatosVenta = new JPanel();
        pnlDatosVenta.setLayout(new GridLayout(1,2));
        pnlDatosVenta.setBorder(BorderFactory.createTitledBorder("Datos de venta"));
        pnlDatosVenta.setBounds(10,10,290,100);
        
        pnlControles = new JPanel();
        pnlControles.setLayout(new GridLayout(4,1));
        pnlControles.setBorder(BorderFactory.createTitledBorder("Controles"));
        pnlControles.setBounds(300,10,280,200);
        
        pnlAnios = new JPanel();
        pnlAnios.setLayout(new GridLayout(1,2));
        pnlAnios.setBorder(BorderFactory.createTitledBorder("Años a Pronosticar"));
        pnlAnios.setBounds(10,110,290,100);
        
        pnlVentas = new JPanel(new GridLayout(1,1));
        pnlVentas.setBorder(BorderFactory.createTitledBorder("Historico de Ventas"));
        pnlVentas.setBounds(10,210,570,290);
        
        pnlPronostico = new JPanel(new GridLayout(1,1));
        pnlPronostico.setBorder(BorderFactory.createTitledBorder("Pronóstico de Ventas"));
        pnlPronostico.setBounds(10,500,570,260);
        
        //pnlDatosVenta
        lblVenta = new JLabel("Cantidad de Venta");
        txtVenta = new JTextField("0");
        pnlDatosVenta.add(lblVenta);
        pnlDatosVenta.add(txtVenta);
        
        //pnlAnios
        lblCantidad = new JLabel("Cantidad");
        txtCantidad = new JTextField("0");
        pnlAnios.add(lblCantidad);
        pnlAnios.add(txtCantidad);
        
        //pnlControles
        btnAgregar = new JButton("Agregar año");
        btnBorrar = new JButton("Borrar año");
        btnModificar = new JButton("Modifica año");
        btnNuevo = new JButton("Nuevo Pronóstico");
        pnlControles.add(btnAgregar);
        pnlControles.add(btnBorrar);
        pnlControles.add(btnModificar);
        pnlControles.add(btnNuevo);
        
        //pnlVentas
        String [] columnNames = {"Año (X)", "Cantidad de Ventas (Y)", "Yn - Yn-1", "(Yn - Yn-1)/Yn-1" };
        Object[][] data = {{"","","",""}};
        tblHistorico = new JTable(data,columnNames);
        pnlSVentas = new JScrollPane();
        tblHistorico.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        pnlSVentas.setViewportView(tblHistorico);
        pnlVentas.add(pnlSVentas);
        
        //pnlPronostico
        String [] columnNames2 = {"Año", "Pronóstico Ventas"};
        Object [][] data2 = {{"",""}};
        tblPronostico = new JTable(data2, columnNames2);
        pnlSPronostico = new JScrollPane();
        tblPronostico.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        pnlSPronostico = new JScrollPane();
        pnlSPronostico.setViewportView(tblPronostico);
        pnlPronostico.add(pnlSPronostico);
        
        
        //Add
        add(pnlDatosVenta);
        add(pnlControles);
        add(pnlAnios);
        add(pnlVentas);
        add(pnlPronostico);
        
        
    }
    

    
}
