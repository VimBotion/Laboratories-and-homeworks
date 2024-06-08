/*
*
*	@author Campoverde Esteban, Cabrera Franck, Apolo Juan
*/
import java.text.DecimalFormat;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.JScrollPane;

public class EvaluacionConCasillas extends JFrame {
	String[] preguntas = {"1. ¿Qué paradigma de programación permite construir programas instrucción a instrucción utilizando las tres estructuras básicas de control?                                                                                                                                                             ",
		"2. Enfocarse más en los beneficios prácticos que en cuestiones éticas o de libertad, es una característica de:                                                                                                                                                                          ",
		"3. El código ISO 8859-1 utiliza para la representación de los caracteres:                                                                                                                                                                                                                    ",
		"4. ¿Qué unidad de la CPU maneja las operaciones en punto flotante?                                                                                                                                                                                                                           ",
		"5. ¿Qué bus se utiliza para la conexión de las tarjetas de red?                                                                                                                                                                                                                                "};
	
	String[][] opciones = {{"Funcional", "Orientado a eventos", "Lógico", "Imperativo"},
		{"Shareware", "Código abierto", "Software Libre", "Freeware"},
		{"32 bits", "16 bits", "8 bits", "7 bits"},
		{"Control", "Aritmético", "Lógica", "Procesamiento numérico"},
		{"USB", "PCIe 1x", "ISA", "PCI"}};
	
	JLabel pregunta1, pregunta2, pregunta3, pregunta4, pregunta5;
	
	JRadioButton funcional, orientadoObjetos, logico, imperativo,
			shareware, codigoAbierto, softwareLibre, freeWare,
			bits32, bits16, bits8, bits7,
			contro, aritmetico, logica, procesamientoNumerico,
			USB, pcie1X, ISA, PCI;
	
	ButtonGroup grupoPregunta1, grupoPregunta2, grupoPregunta3, grupoPregunta4, grupoPregunta5;
	
	JTextArea campoResultado;
	JMenuBar barraMenu;
	JMenu menuOperaciones, menuAyuda;
	JMenuItem opcionCalcular, opcionRestablecer, opcionSalir, opcionAcercade;
	
	
	public EvaluacionConCasillas(){
		// Alineacion a la izquieda con gap de 20 y 15
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
		
		// Creacion del menu
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		menuOperaciones = new JMenu("Operaciones");
		menuOperaciones.setMnemonic('O');
		barraMenu.add(menuOperaciones);
		
		menuAyuda = new JMenu("Ayuda");
		menuAyuda.setMnemonic('A');
		barraMenu.add(menuAyuda);
		
		opcionCalcular = new JMenuItem("Calcular");
		opcionCalcular.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
		menuOperaciones.add(opcionCalcular);
		opcionRestablecer = new JMenuItem("Restablecer");
		opcionRestablecer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.ALT_MASK));
		menuOperaciones.add(opcionRestablecer);
		opcionSalir = new JMenuItem("Salir");
		opcionSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.ALT_MASK));
		menuOperaciones.add(opcionSalir);
		opcionAcercade = new JMenuItem("Acerca de");
		opcionAcercade.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
		menuAyuda.add(opcionAcercade);
		
		// Pregunta 1 y sus opciones
		pregunta1 = new JLabel(preguntas[0]);
		add(pregunta1);
		funcional = new JRadioButton(opciones[0][0]);
		orientadoObjetos = new JRadioButton(opciones[0][1]);
		logico = new JRadioButton(opciones[0][2]);
		imperativo = new JRadioButton(opciones[0][3]);
		grupoPregunta1 = new ButtonGroup();
		grupoPregunta1.add(funcional);
		grupoPregunta1.add(orientadoObjetos);
		grupoPregunta1.add(logico);
		grupoPregunta1.add(imperativo);
		add(funcional);
		add(orientadoObjetos);
		add(logico);
		add(imperativo);
		
		// Pregunta 2 y sus opciones
		pregunta2 = new JLabel(preguntas[1]);
		add(pregunta2);
		shareware = new JRadioButton(opciones[1][0]);
		codigoAbierto = new JRadioButton(opciones[1][1]);
		softwareLibre = new JRadioButton(opciones[1][2]);
		freeWare = new JRadioButton(opciones[1][3]);
		grupoPregunta2 = new ButtonGroup();
		grupoPregunta2.add(shareware);
		grupoPregunta2.add(codigoAbierto);
		grupoPregunta2.add(softwareLibre);
		grupoPregunta2.add(freeWare);
		add(shareware);
		add(codigoAbierto);
		add(softwareLibre);
		add(freeWare);
		
		// Pregunta 3 y sus opciones
		pregunta3 = new JLabel(preguntas[2]);
		add(pregunta3);
		bits32 = new JRadioButton(opciones[2][0]);
		bits16 = new JRadioButton(opciones[2][1]);
		bits8 = new JRadioButton(opciones[2][2]);
		bits7 = new JRadioButton(opciones[2][3]);
		grupoPregunta3 = new ButtonGroup();
		grupoPregunta3.add(bits32);
		grupoPregunta3.add(bits16);
		grupoPregunta3.add(bits8);
		grupoPregunta3.add(bits7);
		add(bits32);
		add(bits16);
		add(bits8);
		add(bits7);
		
		// Pregunta 4 y sus opciones
		pregunta4 = new JLabel(preguntas[3]);
		add(pregunta4);
		contro = new JRadioButton(opciones[3][0]);
		aritmetico = new JRadioButton(opciones[3][1]);
		logica = new JRadioButton(opciones[3][2]);
		procesamientoNumerico = new JRadioButton(opciones[3][3]);
		grupoPregunta4 = new ButtonGroup();
		grupoPregunta4.add(contro);
		grupoPregunta4.add(aritmetico);
		grupoPregunta4.add(logica);
		grupoPregunta4.add(procesamientoNumerico);
		add(contro);
		add(aritmetico);
		add(logica);
		add(procesamientoNumerico);
		
		// Pregunta 5 y sus opciones
		pregunta5 = new JLabel(preguntas[4]);
		add(pregunta5);
		USB = new JRadioButton(opciones[4][0]);
		pcie1X = new JRadioButton(opciones[4][1]);
		ISA = new JRadioButton(opciones[4][2]);
		PCI = new JRadioButton(opciones[4][3]);
		grupoPregunta5 = new ButtonGroup();
		grupoPregunta5.add(USB);
		grupoPregunta5.add(pcie1X);
		grupoPregunta5.add(ISA);
		grupoPregunta5.add(PCI);
		add(USB);
		add(pcie1X);
		add(ISA);
		add(PCI);
		
		// Campo de resultado
		campoResultado = new JTextArea("Resultados de la evaluacion: \n", 15, 75);
		campoResultado.setEditable(false);
		add(new JScrollPane(campoResultado));
		
		// Manejadores
		ManejadorOpciones manejador = new ManejadorOpciones();
		opcionCalcular.addActionListener(manejador);
		opcionRestablecer.addActionListener(manejador);
		opcionSalir.addActionListener(manejador);
		opcionAcercade.addActionListener(manejador);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Prueba de varias alternativas");
		setSize(900,700);
		setResizable(false);
		setVisible(true);
	}
	
	private class ManejadorOpciones implements ActionListener {
		int puntuacion = 0;
		int preguntasVacias = 0;
		public void actionPerformed(ActionEvent evento){
			if(evento.getSource() == opcionCalcular){
				puntuacion = 0;
				preguntasVacias = 0;
				conteoCorrectas();
				mostrarResultado();
			}
			else if(evento.getSource() == opcionRestablecer){
				restablecer();
			}
			else if(evento.getSource() == opcionSalir){
				System.exit(0);
			}
			else if(evento.getSource() == opcionAcercade){
				JOptionPane.showMessageDialog(EvaluacionConCasillas.this, "Ejercicio 5\nCampoverde Esteban, Apolo Juan, Cabrera Franck\n Mayo 2024",
						"Acerca De", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		void mostrarResultado() {
			campoResultado.setText("Resultados de la evaluacion: \n");
			campoResultado.append("Nota máxima: " + puntuacion + "\n");
			campoResultado.append("Ha dejado sin contestar " + preguntasVacias + " preguntas\n");
			campoResultado.append("Su porcentaje de aciertos es de: " + porcentaje() + "\n");
			campoResultado.append("\n");
			campoResultado.append("Preguntas incorrectas:\n");
			
			mostrarIncorrecta();
		}

		void mostrarIncorrecta(){
			// Si no se selecciona la respuesta correcta pero se selecciona una pregunta 
			if(!imperativo.isSelected() && grupoPregunta1.getSelection() != null){
					campoResultado.append("La pregunta 1 es incorrecta\n");
					campoResultado.append("La respuesta correcta es: Imperativo \n");
					campoResultado.append("\n");
			}
			if(!codigoAbierto.isSelected() && grupoPregunta2.getSelection() != null){
					campoResultado.append("La pregunta 2 es incorrecta\n");
					campoResultado.append("La respuesta correcta es: Codigo abierto \n");
					campoResultado.append("\n");
			}
			if(!bits8.isSelected() && grupoPregunta3.getSelection() != null){
					campoResultado.append("La pregunta 3 es incorrecta\n");
					campoResultado.append("La respuesta correcta es: 8 Bits \n");
					campoResultado.append("\n");
			}
			if(!procesamientoNumerico.isSelected() && grupoPregunta4.getSelection() != null){
					campoResultado.append("La pregunta 4 es incorrecta\n");
					campoResultado.append("La respuesta correcta es: Procesamiento Numerico \n");
					campoResultado.append("\n");

			}

			if(!pcie1X.isSelected() && grupoPregunta5.getSelection() != null){
					campoResultado.append("La pregunta 5 es incorrecta\n");
					campoResultado.append("La respuesta correcta es: PCIe 1x \n");
					campoResultado.append("\n");

			}
		}
		
		void restablecer(){
			grupoPregunta1.clearSelection();
			grupoPregunta2.clearSelection();
			grupoPregunta3.clearSelection();
			grupoPregunta4.clearSelection();
			grupoPregunta5.clearSelection();
			
			campoResultado.setText("Resultados de la evaluacion: \n");
		}
		
		void conteoCorrectas(){
			if(grupoPregunta1.getSelection() == null){
				preguntasVacias++;
			}
			else if(imperativo.isSelected()){
				puntuacion++;
			}
			if(grupoPregunta2.getSelection() == null){
				preguntasVacias++;
			}
			else if(codigoAbierto.isSelected()){
				puntuacion++;
			}
			if(grupoPregunta3.getSelection() == null){
				preguntasVacias++;
			}
			else if(bits8.isSelected()){
				puntuacion++;
			}
			if(grupoPregunta4.getSelection() == null){
				preguntasVacias++;
			}
			else if(procesamientoNumerico.isSelected()){
				puntuacion++;
			}
			if(grupoPregunta5.getSelection() == null){
				preguntasVacias++;
			}
			else if(pcie1X.isSelected()){
				puntuacion++;
			}
		}
		
		String porcentaje(){
			DecimalFormat formatear = new DecimalFormat("0.00%");
			
			double porcentaje = (double) puntuacion / 5.0;
			String formateado = formatear.format(porcentaje);
			
			return formateado;
		}
	}
	
	public static void main(String[] args){
		EvaluacionConCasillas aplicacion = new EvaluacionConCasillas();
	}
}

