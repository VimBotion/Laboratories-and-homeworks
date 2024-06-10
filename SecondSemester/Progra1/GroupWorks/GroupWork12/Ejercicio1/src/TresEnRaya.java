 /**
  *
  * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
  */
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TresEnRaya extends JFrame {
	JMenuBar barraMenu;
	JLabel texto;
	JMenu menuOperaciones, menuAyuda;
	JMenuItem nuevoJuego, salir, acercaDe;
	JButton[] botones = new JButton[9];
	Font fuente = new Font("MV Boli", Font.BOLD, 90);
	Boolean turnoJugador1 = true, finJuego = false;
	TresEnRaya(){
		setLayout(new BorderLayout());
		
		// Barra de menu
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		// Menu operaciones
		menuOperaciones = new JMenu("Operaciones");
		barraMenu.add(menuOperaciones);
		nuevoJuego = new JMenuItem("Nuevo juego");
		salir = new JMenuItem("Salir");
		menuOperaciones.add(nuevoJuego);
		menuOperaciones.add(salir);
		// Menu ayuda
		menuAyuda = new JMenu("Ayuda");
		barraMenu.add(menuAyuda);
		acercaDe = new JMenuItem("Acerca De");
		menuAyuda.add(acercaDe);
		
		// Pantalla Texto
		texto = new JLabel("Turno del Jugador 1", SwingConstants.CENTER);
		texto.setForeground(Color.WHITE);
		texto.setFont(new Font("Serif", Font.BOLD, 40));
		add(texto, BorderLayout.NORTH);
		
		// Manejador
		ManejadorInteraccion manejador = new ManejadorInteraccion();
		
		JPanel panelBotones = new JPanel(new GridLayout(3, 3));
		for(int i = 0; i < 9; i++){
			botones[i] = new JButton();
			botones[i].addActionListener(manejador);
			botones[i].setBackground(Color.DARK_GRAY);
			botones[i].setFont(fuente);
			botones[i].setFocusable(false); // Elimina lineas que asoman al rededor del texto del boton
			panelBotones.add(botones[i]);
		}
		
		nuevoJuego.addActionListener(manejador);
		salir.addActionListener(manejador);
		acercaDe.addActionListener(manejador);
		
		add(panelBotones);
		
		getContentPane().setBackground(Color.GRAY);
		setTitle("Tres en raya");
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class ManejadorInteraccion implements ActionListener {
		public void actionPerformed(ActionEvent evento){
			if(evento.getSource() == nuevoJuego){
				restablecer();
			}
			if(evento.getSource() == salir){
				System.exit(0);
			}
			if(evento.getSource() == acercaDe){
				JOptionPane.showMessageDialog(rootPane, "Campoverde Esteban, Apolo Juan, Cabrera Franck", "Acerca De", JOptionPane.INFORMATION_MESSAGE);
			}
			for(int i = 0; i < 9; i++){
				if(evento.getSource() == botones[i] && finJuego == false){
					if(turnoJugador1){
						if(botones[i].getText().equals("")){
							botones[i].setForeground(Color.BLUE);
							botones[i].setText("X");
							turnoJugador1 = false;
							texto.setText("Turno del jugador 2");
							revisarGanador();
						}
					}
					else {
						if(botones[i].getText().equals("")){
							botones[i].setForeground(Color.RED);
							botones[i].setText("O");
							turnoJugador1 = true;
							texto.setText("Turno del jugador 1");
							revisarGanador();
						}
					}
				}
			}
		}
		public void revisarGanador() {
			if(
					(botones[0].getText().equals("X")) &&
					(botones[1].getText().equals("X")) &&
					(botones[2].getText().equals("X"))
					) {
				finJuego = true;
				jugador1Gana(0, 1, 2);
			}
			else if(
					(botones[3].getText().equals("X")) &&
					(botones[4].getText().equals("X")) &&
					(botones[5].getText().equals("X"))
					) {
				finJuego = true;
				jugador1Gana(3, 4, 5);
			}
			else if(
					(botones[6].getText().equals("X")) &&
					(botones[7].getText().equals("X")) &&
					(botones[8].getText().equals("X"))
					) {
				finJuego = true;
				jugador1Gana(6, 7, 8);
			}
			else if(
					(botones[0].getText().equals("X")) &&
					(botones[3].getText().equals("X")) &&
					(botones[6].getText().equals("X"))
					) {
				finJuego = true;
				jugador1Gana(0, 3, 6);
			}
			else if(
					(botones[1].getText().equals("X")) &&
					(botones[4].getText().equals("X")) &&
					(botones[7].getText().equals("X"))
					) {
				finJuego = true;
				jugador1Gana(1, 4, 7);
			}
			else if(
					(botones[2].getText().equals("X")) &&
					(botones[5].getText().equals("X")) &&
					(botones[8].getText().equals("X"))
					) {
				finJuego = true;
				jugador1Gana(2, 5, 8);
			}
			else if(
					(botones[0].getText().equals("X")) &&
					(botones[4].getText().equals("X")) &&
					(botones[8].getText().equals("X"))
					) {
				finJuego = true;
				jugador1Gana(0, 4, 8);
			}
			else if(
					(botones[2].getText().equals("X")) &&
					(botones[4].getText().equals("X")) &&
					(botones[6].getText().equals("X"))
					) {
				finJuego = true;
				jugador1Gana(2, 4, 6);
			}
			else if(
					(botones[0].getText().equals("O")) &&
					(botones[1].getText().equals("O")) &&
					(botones[2].getText().equals("O"))
					) {
				finJuego = true;
				jugador2Gana(0, 1, 2);
			}
			else if(
					(botones[3].getText().equals("O")) &&
					(botones[4].getText().equals("O")) &&
					(botones[5].getText().equals("O"))
					) {
				finJuego = true;
				jugador2Gana(3, 4, 5);
			}
			else if(
					(botones[6].getText().equals("O")) &&
					(botones[7].getText().equals("O")) &&
					(botones[8].getText().equals("O"))
					) {
				finJuego = true;
				jugador2Gana(6, 7, 8);
			}
			else if(
					(botones[0].getText().equals("O")) &&
					(botones[3].getText().equals("O")) &&
					(botones[6].getText().equals("O"))
					) {
				finJuego = true;
				jugador2Gana(0, 3, 6);
			}
			else if(
					(botones[1].getText().equals("O")) &&
					(botones[4].getText().equals("O")) &&
					(botones[7].getText().equals("O"))
					) {
				finJuego = true;
				jugador2Gana(1, 4, 7);
			}
			else if(
					(botones[2].getText().equals("O")) &&
					(botones[5].getText().equals("O")) &&
					(botones[8].getText().equals("O"))
					) {
				finJuego = true;
				jugador2Gana(2, 5, 8);
			}
			else if(
					(botones[0].getText().equals("O")) &&
					(botones[4].getText().equals("O")) &&
					(botones[8].getText().equals("O"))
					) {
				finJuego = true;
				jugador2Gana(0, 4, 8);
			}
			else if(
					(botones[2].getText().equals("O")) &&
					(botones[4].getText().equals("O")) &&
					(botones[6].getText().equals("O"))
					) {
				finJuego = true;
				jugador2Gana(2, 4, 6);
			}
			else {
				boolean empate = true;
				for(int i = 0; i < 9; i++){
					// Si quedan botones sin marcar, no existe empate
					if(botones[i].getText().equals("")){
						empate = false;
						break;
					}
				}
				if(empate){
					finJuego = true;
					esEmpate();
				}
			}
		}

		// Cambia el color de todas las casillas
		public void esEmpate(){
			for(int i = 0; i < 9; i++){
				botones[i].setBackground(Color.ORANGE);
				texto.setText("Es un empate!");
			}
		}
		
		// Las funciones de jugadorGana cambian el color de las tres casillas en linea
		public void jugador1Gana(int a, int b, int c) {
			botones[a].setBackground(Color.GREEN);
			botones[b].setBackground(Color.GREEN);
			botones[c].setBackground(Color.GREEN);
			
			texto.setText("Jugador 1 Gana!");
		}
		
		public void jugador2Gana(int a, int b, int c) {
			botones[a].setBackground(Color.GREEN);
			botones[b].setBackground(Color.GREEN);
			botones[c].setBackground(Color.GREEN);
			
			texto.setText("Jugador 2 Gana!");
		}
		

		public void restablecer(){
			for(int i = 0; i < 9; i++){
				botones[i].setText("");
				botones[i].setBackground(Color.DARK_GRAY);
				turnoJugador1 = true;
				finJuego = false;
				texto.setText("Turno del Jugador 1");
			}
		}
	}
    public static void main(String[] args) {
		TresEnRaya aplicacion = new TresEnRaya();
    }
}
