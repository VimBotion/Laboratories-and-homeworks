/**
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */

import javax.swing.*;
import java.awt.*;

public class InterfazCalculadora extends JFrame {
	// Posiciones de los botones de la calculadora
	int[][] posicion = {
		{0, 0}, {1, 0}, {2, 0}, {3, 0},
		{0, 1}, {1, 1}, {2, 1}, {3, 1},
		{0, 2}, {1, 2}, {2, 2}, {3, 2}, {4, 2},
		{0, 3}, {1, 3}, {2, 3}, {3, 3}, {4, 3},
		{0, 4}, {1, 4}, {2, 4}, {3, 4}, {4, 4}, {5, 4},
		{0, 5}, {1, 5}, {2, 5}, {3, 5}, {4, 5}, {5, 5}
	};

	// Nombres de los botones de la calculadora
	String[] arrayBotonesCalc = {
		"7", "8", "9", "/",
		"4", "5", "6", "*",
		"1", "2", "3", "-", "C",
		"0", "+/-", ",", "+", "=",
		"A", "B", "C", "D", "E", "F"
	};
    JPanel panelBotonOperaciones, panelBotonesNumeros, panelEspacio;
    JTextField resultado;
    ButtonGroup grupoBotones;
    JRadioButton hex, bin, dec, oct; 
    JButton boton;
    GridBagConstraints gbc;
    
    public InterfazCalculadora() {
		panelEspacio = new JPanel(new BorderLayout());
		// Anade un borde invisible para separar el textfield de la ventana
		panelEspacio.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        resultado = new JTextField("0");
		// El 0 a la derecha
        resultado.setHorizontalAlignment(JTextField.RIGHT);
		resultado.setEditable(false);
		panelEspacio.add(resultado);
        
		// Inicio del panelBotonOperaciones
        panelBotonOperaciones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        grupoBotones = new ButtonGroup();
        hex = new JRadioButton("Hex");
        bin = new JRadioButton("Bin");
        dec = new JRadioButton("Dec");
        oct = new JRadioButton("Oct");
        grupoBotones.add(hex);
        grupoBotones.add(bin);
        grupoBotones.add(dec);
        grupoBotones.add(oct);
        panelBotonOperaciones.add(hex);        
        panelBotonOperaciones.add(bin);
        panelBotonOperaciones.add(dec);
        panelBotonOperaciones.add(oct);
		// Fin del panelBotonOperaciones
        
		// Inicio del panelBotonNumeros
        panelBotonesNumeros = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(1, 1, 1, 1);
        
        for (int i = 0; i < arrayBotonesCalc.length; i++) {
			// Posiciones
            gbc.gridx = posicion[i][0];
            gbc.gridy = posicion[i][1];

			// Instanciacion de botones
            boton = new JButton(arrayBotonesCalc[i]);
            
            if (arrayBotonesCalc[i].equals("C")) {
				// Si es C de Clear o C de numero Hex
                if (i == 12) {
                    boton.setForeground(Color.RED);
					gbc.gridwidth = 2;
                } 
                else {
					gbc.gridwidth = 1;
                    boton.setForeground(Color.BLUE); 
                }
            } 
            else if (arrayBotonesCalc[i].matches("[/*\\-+=]")) {
				gbc.gridwidth = 1;
                boton.setForeground(Color.RED); 
            } 
            else {
				gbc.gridwidth = 1;
                boton.setForeground(Color.BLUE); 
            }
            panelBotonesNumeros.add(boton, gbc);
        }
		// Fin del panelBotonNumeros

        add(panelEspacio, BorderLayout.NORTH);
        add(panelBotonOperaciones, BorderLayout.CENTER);
        add(panelBotonesNumeros, BorderLayout.SOUTH);
        
        setTitle("Calculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(310, 260);
        setResizable(false); 
        setVisible(true);
    }

    public static void main(String[] argumentos) {
        InterfazCalculadora ventana = new InterfazCalculadora();
    }
}