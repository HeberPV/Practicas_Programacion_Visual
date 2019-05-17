import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;

public class TablaCrud implements ActionListener {
    
    private JFrame ventana;
    private JTable tabla;
    private JTextField caja1;
    private JTextField caja2;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    int Data = 0;
    private DefaultTableModel model;
    private int contador=0;
    public TablaCrud(){
    	
    	ventana = new JFrame();
    	
    	//mensaje= new JLabel();
    	//mensaje.setText("**Operaciones**");
    	//mensaje.setBounds(250,100, 200, 10);
    	//mensaje.setForeground(Color.BLUE);
    	//ventana.add(mensaje);
    	
    	caja1 = new JTextField();
		caja1.setBounds(250,40,200,17);
		ventana.add(caja1);
		
		caja2 = new JTextField();
		caja2.setBounds(250,60,200,17);
		caja2.setEditable(true);
		ventana.add(caja2);
		
		boton1 = new JButton();
		boton1.setText("Añadir nuevo");
		boton1.setBounds(250,80,200,20);
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				addRow(caja1.getText(),caja2.getText());
			}
		});
		ventana.add(boton1);
		
		boton2 = new JButton();
		boton2.setText("Eliminar");
		boton2.setBounds(250,10,100,20);
		boton2.setVisible(false);
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int row=Data;
				deleteRow(row);
				deletePropCajas();
			}
		});
		ventana.add(boton2);
		
		boton3 = new JButton();
		boton3.setText("Editar");
		boton3.setBounds(360,10,100,20);
		boton3.setVisible(false);
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				editarRow();
				deletePropCajas();
			}
		});
		ventana.add(boton3);
		
	      String data[][] = {
	          {"1","Tacos","$12.00"},
	          {"2","Tamales","$10.00"},
	          {"3","Tortas","$35"},
	          {"4","Cochito","$45.00"},
	      };
	      String label[] = {"ID","NOMBRE","PRECIO"};
	      
	      contador=data.length;
	      
	      model = new DefaultTableModel(data,label);
	      tabla = new JTable(model);
	      tabla.setCellSelectionEnabled(true);
	      ListSelectionModel select = tabla.getSelectionModel();
	      select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	      select.addListSelectionListener(new ListSelectionListener(){
	         public void valueChanged(ListSelectionEvent e){
	        	 Data=tabla.getSelectedRow();
	        	 System.out.println(Data);
	        	 boton2.setVisible(true);
	        	 boton3.setVisible(true);
	        	 try {
	        	 addPropCajas();}catch(Exception ex) {
	        		 System.out.println("Eliminado");
	        	 }
	         }
	      });
	      tabla.setAutoResizeMode(AUTO_RESIZE_OFF);
	      JScrollPane scroll = new JScrollPane(tabla);
	      ventana.add(scroll);
	      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      ventana.setSize(500,500);
	      ventana.setVisible(true);
      
    }
    
    @Override
	public void actionPerformed(ActionEvent e){
		System.out.println("kaka");
	}
    
    public void addPropCajas() {
    	boton1.setVisible(false);
    	String vCaja1;
   	 	String vCaja2;
   	 	vCaja1=(String)tabla.getValueAt(Data, 1);
        caja1.setText(vCaja1);
        vCaja2=(String)tabla.getValueAt(Data, 2);
        caja2.setText(vCaja2);
    }
    
    public void deletePropCajas() {
    	boton1.setVisible(true);
        caja1.setText("");
        caja2.setText("");
        boton2.setVisible(false);
        boton3.setVisible(false);
    }
    
    public void editarRow() {
    	tabla.setValueAt(caja1.getText(), Data, 1);
    	tabla.setValueAt(caja2.getText(), Data, 2);
    }
    
    public void addRow(String str2,String str3){
    	String str1;
    	contador++;
    	str1=Integer.toString(contador);
        model.addRow(new Object[]{str1,str2,str3});
    }
    public void addDataInSpecificRow(int row,String str1, String str2,String str3){
        model.insertRow(row, new Object[] {str1,str2,str3});
    }
    
    public void deleteRow(int fila){
        if(model.getRowCount()>0){
           model.removeRow(fila);
        }
        else {
            JOptionPane.showMessageDialog(tabla, "Tabla vacía.","ERROR", 1);
        }
       
    }
    
    public static void main(String[] args){
    	TablaCrud x = new TablaCrud();
    }
}

