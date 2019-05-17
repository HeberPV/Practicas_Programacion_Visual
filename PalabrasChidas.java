import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PalabrasChidas extends JFrame implements ActionListener{
	private JLabel mensaje;
	private JButton boton;
	private JTextField caja1;
	private JLabel palindromo;
	private JLabel inversa;
	private JLabel longitud;
	private JLabel repetidas;
	public PalabrasChidas(){
		super();
		configurarVentana();
		agregarComponentes();
	}
	
	private void configurarVentana(){
		this.setTitle("Verificacion de palabras");
		this.setSize(300,200);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void agregarComponentes(){
		mensaje= new JLabel();
		mensaje.setText("Ingresa una palabra");
		mensaje.setBounds(15,5, 120, 30);
		mensaje.setForeground(Color.BLUE);
		this.add(mensaje);
		
		palindromo = new JLabel();
		palindromo.setText("Palindromo: ");
		palindromo.setBounds(15,60, 120, 30);
		palindromo.setForeground(Color.BLUE);
		this.add(palindromo);
		
		longitud = new JLabel();
		longitud.setText("Longitud: ");
		longitud.setBounds(15,80, 120, 30);
		longitud.setForeground(Color.BLUE);
		this.add(longitud);
		
		inversa = new JLabel();
		inversa.setText("Inversa: ");
		inversa.setBounds(15,100, 120, 30);
		inversa.setForeground(Color.BLUE);
		this.add(inversa);
		
		repetidas = new JLabel();
		repetidas.setText("Repetidas: ");
		repetidas.setBounds(15,120, 120, 30);
		repetidas.setForeground(Color.BLUE);
		this.add(repetidas);
		
		caja1 = new JTextField();
		caja1.setBounds(150,10,100,17);
		this.add(caja1);

		boton = new JButton();
		boton.setText("Verificar");
		boton.setBounds(50,40,200,20);
		boton.addActionListener(this);
		this.add(boton);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String palabra = caja1.getText();
		char[] cPalabra;
		String pInversa = "";
		String pLongitud;
		int contador=0;
		int mayor=0;
		char caracterC;
		String letra="";
		
		cPalabra = palabra.toCharArray();
		
		for(int i=(cPalabra.length-1);i>=0;i--) {
			pInversa=pInversa+cPalabra[i];
		}
		
		pLongitud = Integer.toString(cPalabra.length);
		
		for(int i=0;i<cPalabra.length;i++) {
			contador=0;
			caracterC=cPalabra[i];
			for(int j=0;j<cPalabra.length;j++) {
				if(caracterC==cPalabra[j]) {
					contador=contador+1;
				}
			}
			System.out.println(caracterC+": "+contador);
			if(contador>mayor) {
				mayor=contador;
				letra=Character.toString(cPalabra[i]);
			}
		}
		
		repetidas.setText("Repetidas: "+letra);
		
		if(palabra.compareTo(pInversa)==0) {
			palindromo.setText("Palindromo: SI");
		}else {
			palindromo.setText("Palindromo: NEL");
		}
		longitud.setText("Longitud: "+pLongitud);
		inversa.setText("Inversa: "+pInversa);
	}
	
	public static void main(String[] args){
		PalabrasChidas ventana=new PalabrasChidas();
		ventana.setVisible(true);
	}
}
