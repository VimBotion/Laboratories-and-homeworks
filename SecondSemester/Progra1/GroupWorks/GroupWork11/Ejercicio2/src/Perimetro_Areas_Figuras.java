/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Perimetro_Areas_Figuras extends JFrame {
	JLabel etiquetaRadio, etiquetaRadioCilindro, etiquetaAltura, etiquetaAlturaCilindroH, etiquetaRadioExterno,
			etiquetaRadioInterno ,etiquetaPerimetro, etiquetaArea, etiquetaAreaCilindro, etiquetaAreaCilindroH,etiquetaVolumen, etiquetaVolumenCilindroH;
	JTextField campoRadioCirculo, campoPerimetroCirculo, campoAreaCirculo, campoRadioCilindro, campoAlturaCilindro, campoAreaCilindro,
			campoVolumenCilindro, campoRadioExterno, campoRadioInterno, campoAlturaCilindroH, campoAreaCilindroH, campoVolumenC;
	
	JPanel subPanelCirculo, subPanelCilindro, subPanelCilindroHueco;

	JTabbedPane tabFiguras;

	Perimetro_Areas_Figuras(){
		tabFiguras = new JTabbedPane();

		etiquetaRadio = new JLabel("Ingrese radio", SwingConstants.LEFT);
		etiquetaRadioCilindro = new JLabel("Ingrese radio", SwingConstants.LEFT);
		etiquetaAltura = new JLabel("Ingrese altura", SwingConstants.LEFT);
		etiquetaAlturaCilindroH = new JLabel("Ingrese altura", SwingConstants.LEFT);
		etiquetaRadioExterno = new JLabel("Ingrese radio externo", SwingConstants.LEFT);
		etiquetaRadioInterno = new JLabel("Ingrese radio interno", SwingConstants.LEFT);
		etiquetaPerimetro = new JLabel("Perimetro", SwingConstants.LEFT);
		etiquetaArea = new JLabel("Area", SwingConstants.LEFT);
		etiquetaAreaCilindro = new JLabel("Area", SwingConstants.LEFT);
		etiquetaAreaCilindroH = new JLabel("Area", SwingConstants.LEFT);
		etiquetaVolumen = new JLabel("Volumen", SwingConstants.LEFT);
		etiquetaVolumenCilindroH = new JLabel("Volumen", SwingConstants.LEFT);

		// Tab del circulo
		JPanel panelCirculo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		subPanelCirculo = new JPanel(new GridBagLayout());
		GridBagConstraints restricciones = new GridBagConstraints();
		restricciones.gridheight = 1;
		restricciones.gridwidth = 1;
		restricciones.insets = new Insets(10, 10, 10, 10);
		restricciones.anchor = GridBagConstraints.WEST;

		// Creacion de campos de texto
		campoRadioCirculo = new JTextField(8);
		campoPerimetroCirculo = new JTextField(8);
		campoPerimetroCirculo.setEditable(false);
		campoAreaCirculo = new JTextField(8);
		campoAreaCirculo.setEditable(false);

		restricciones.gridx = 0;
		restricciones.gridy = 0;
		subPanelCirculo.add(etiquetaRadio, restricciones);
		restricciones.gridx = 1;
		restricciones.gridy = 0;
		subPanelCirculo.add(campoRadioCirculo, restricciones);
		restricciones.gridx = 0;
		restricciones.gridy = 1;
		subPanelCirculo.add(etiquetaPerimetro, restricciones);
		restricciones.gridx = 1;
		restricciones.gridy = 1;
		subPanelCirculo.add(campoPerimetroCirculo, restricciones);
		restricciones.gridx = 0;
		restricciones.gridy = 2;
		subPanelCirculo.add(etiquetaArea, restricciones);
		restricciones.gridx = 1;
		restricciones.gridy = 2;
		subPanelCirculo.add(campoAreaCirculo, restricciones);
		panelCirculo.add(subPanelCirculo);
		tabFiguras.addTab("Circulo", null, panelCirculo);

		// Tab del cilindro
		JPanel panelCilindro = new JPanel(new FlowLayout(FlowLayout.LEFT));
		subPanelCilindro = new JPanel(new GridBagLayout());
		GridBagConstraints restriccionesCilindro = new GridBagConstraints();
		restriccionesCilindro.insets = new Insets(10, 10, 10, 10);
		restriccionesCilindro.anchor = GridBagConstraints.WEST;

		// Creacion de campos de texto para cilindro      
		campoRadioCilindro = new JTextField(8);
		campoAlturaCilindro = new JTextField(8);
		campoAreaCilindro = new JTextField(8);
		campoAreaCilindro.setEditable(false);
		campoVolumenCilindro = new JTextField(8);
		campoVolumenCilindro.setEditable(false);

		restriccionesCilindro.gridx = 0;
		restriccionesCilindro.gridy = 0;
		subPanelCilindro.add(etiquetaRadioCilindro, restriccionesCilindro);
		restriccionesCilindro.gridx = 1;
		restriccionesCilindro.gridy = 0;
		subPanelCilindro.add(campoRadioCilindro, restriccionesCilindro);
		restriccionesCilindro.gridx = 0;
		restriccionesCilindro.gridy = 1;
		subPanelCilindro.add(etiquetaAltura, restriccionesCilindro);
		restriccionesCilindro.gridx = 1;
		restriccionesCilindro.gridy = 1;
		subPanelCilindro.add(campoAlturaCilindro, restriccionesCilindro);
		restriccionesCilindro.gridx = 0;
		restriccionesCilindro.gridy = 2;
		subPanelCilindro.add( etiquetaAreaCilindro, restriccionesCilindro);
		restriccionesCilindro.gridx = 1;
		restriccionesCilindro.gridy = 2;
		subPanelCilindro.add(campoAreaCilindro, restriccionesCilindro);
		restriccionesCilindro.gridx = 0;
		restriccionesCilindro.gridy = 3;
		subPanelCilindro.add(etiquetaVolumen, restriccionesCilindro);
		restriccionesCilindro.gridx = 1;
		restriccionesCilindro.gridy = 3;
		subPanelCilindro.add(campoVolumenCilindro, restriccionesCilindro);

		panelCilindro.add(subPanelCilindro);
		tabFiguras.addTab("Cilindro", null, panelCilindro);

		// Tab del cilindro hueco
		JPanel panelCilindroH = new JPanel(new FlowLayout(FlowLayout.LEFT));
		subPanelCilindroHueco = new JPanel(new GridBagLayout());
		GridBagConstraints restriccionesCilindroH = new GridBagConstraints();
		restriccionesCilindroH.insets = new Insets(10, 10, 10, 10);
		restriccionesCilindroH.anchor = GridBagConstraints.WEST;

		campoRadioExterno = new JTextField(8);
		campoRadioInterno = new JTextField(8);
		campoAlturaCilindroH = new JTextField(8);
		campoAreaCilindroH = new JTextField(8);
		campoAreaCilindroH.setEditable(false);
		campoVolumenC = new JTextField(8);
		campoVolumenC.setEditable(false);

		restriccionesCilindroH.gridx = 0;
		restriccionesCilindroH.gridy = 0;
		subPanelCilindroHueco.add(etiquetaRadioExterno, restriccionesCilindroH);
		restriccionesCilindroH.gridx = 1;
		restriccionesCilindroH.gridy = 0;
		subPanelCilindroHueco.add(campoRadioExterno, restriccionesCilindroH);
		restriccionesCilindroH.gridx = 0;
		restriccionesCilindroH.gridy = 1;
		subPanelCilindroHueco.add(etiquetaRadioInterno, restriccionesCilindroH);
		restriccionesCilindroH.gridx = 1;
		restriccionesCilindroH.gridy = 1;
		subPanelCilindroHueco.add(campoRadioInterno, restriccionesCilindroH);
		restriccionesCilindroH.gridx = 0;
		restriccionesCilindroH.gridy = 2;
		subPanelCilindroHueco.add(etiquetaAlturaCilindroH, restriccionesCilindroH);
		restriccionesCilindroH.gridx = 1;
		restriccionesCilindroH.gridy = 2;
		subPanelCilindroHueco.add(campoAlturaCilindroH, restriccionesCilindroH);
		restriccionesCilindroH.gridx = 0;
		restriccionesCilindroH.gridy = 3;
		subPanelCilindroHueco.add(etiquetaAreaCilindroH, restriccionesCilindroH);
		restriccionesCilindroH.gridx = 1;
		restriccionesCilindroH.gridy = 3;
		subPanelCilindroHueco.add(campoAreaCilindroH, restriccionesCilindroH);
		restriccionesCilindroH.gridx = 0;
		restriccionesCilindroH.gridy = 4;
		subPanelCilindroHueco.add(etiquetaVolumenCilindroH, restriccionesCilindroH);
		restriccionesCilindroH.gridx = 1;
		restriccionesCilindroH.gridy = 4;
		subPanelCilindroHueco.add(campoVolumenC, restriccionesCilindroH);

		panelCilindroH.add(subPanelCilindroHueco);
		tabFiguras.addTab("Cilindro Hueco", null, panelCilindroH);
		add(tabFiguras);

		// Manejadores
		ManejadorCampoTexto manejador = new ManejadorCampoTexto();
		campoRadioCirculo.addActionListener(manejador);
		campoAlturaCilindro.addActionListener(manejador);
		campoAlturaCilindroH.addActionListener(manejador);

		setTitle("Figuras circulo, cilindro, cilindro hueco");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setResizable(false);
		setVisible(true);
	}

	private class ManejadorCampoTexto implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			DecimalFormat formatear = new DecimalFormat("#,###.###");
			if(evento.getSource() == campoRadioCirculo){
				campoPerimetroCirculo.setText(" ");
				campoAreaCirculo.setText(" ");
				if(!validarIngreso(campoRadioCirculo.getText())){
					JOptionPane.showMessageDialog(null, "El valor del radio debe ser uno numerico mayor a 0", "Formato numerico incorrecto", JOptionPane.ERROR_MESSAGE);
					restablecer();
					campoRadioCirculo.requestFocus();
				}
				else {
					double valorRadio = Double.parseDouble(campoRadioCirculo.getText());
					if(valorRadio > 0){
						campoPerimetroCirculo.setText(formatear.format(perimetro(valorRadio)));
						campoAreaCirculo.setText(formatear.format(areaCirculo(valorRadio)));
					}
					else {
						JOptionPane.showMessageDialog(null, "El valor del radio debe ser mayor a 0", "Ingreso incorrecto", JOptionPane.ERROR_MESSAGE);
						restablecer();
						campoRadioCirculo.requestFocus();
					}
				}
			}
			if(evento.getSource() == campoAlturaCilindro){
				campoVolumenCilindro.setText("");
				campoAreaCilindro.setText("");
				if(!validarIngreso(campoRadioCilindro.getText()) || !validarIngreso(campoAlturaCilindro.getText())){
					JOptionPane.showMessageDialog(null, "Debe ingresar valores numericos mayores a 0 en los campos", "Formato numerico invalido", JOptionPane.ERROR_MESSAGE);
					restablecer();
					campoRadioCilindro.requestFocus();
				}
				else {
					double valorRadio = Double.parseDouble(campoRadioCilindro.getText());
					double valorAltura = Double.parseDouble(campoAlturaCilindro.getText());
					if(valorRadio <= 0 || valorAltura <= 0){
						JOptionPane.showMessageDialog(null, "El valor del radio y la altura debe ser mayor a 0", "Ingreso incorrecto", JOptionPane.ERROR_MESSAGE);
						restablecer();
						campoRadioCilindro.requestFocus();
					} else{
						campoAreaCilindro.setText(formatear.format(areaCilindro(valorRadio, valorAltura)));
						campoVolumenCilindro.setText(formatear.format(volumenCilindro(valorRadio, valorAltura)));
					}
				}
			}
			if(evento.getSource() == campoAlturaCilindroH){
				campoAreaCilindroH.setText("");
				campoVolumenC.setText("");
				if(!validarIngreso(campoRadioExterno.getText()) || !validarIngreso(campoRadioInterno.getText()) ||!validarIngreso(campoAlturaCilindroH.getText())){
					JOptionPane.showMessageDialog(null, "Debe ingresar valores numericos en los campos", "Formato numerico invalido", JOptionPane.ERROR_MESSAGE);
					restablecer();
					campoRadioExterno.requestFocus();
				}
				else {
					double valorRadioExterno = Double.parseDouble(campoRadioExterno.getText());
					double valorRadioInterno = Double.parseDouble(campoRadioInterno.getText());
					double valorAltura = Double.parseDouble(campoAlturaCilindroH.getText());
					if(valorRadioExterno <= 0 || valorRadioInterno <= 0 || valorAltura <= 0){
						JOptionPane.showMessageDialog(null, "Los valores de los radios y alturas deben ser mayores a 0", "Ingreso incorrecto", JOptionPane.ERROR_MESSAGE);
						restablecer();
						campoRadioExterno.requestFocus();
					}
					else if(valorRadioExterno < valorRadioInterno){
						JOptionPane.showMessageDialog(null, "El radio Externo debe ser mayor al radio interno", "Ingreso incorrecto", JOptionPane.ERROR_MESSAGE);
						restablecer();
						campoRadioExterno.requestFocus();
					}
					else {
						campoAreaCilindroH.setText(formatear.format(areaCilindroHueco(valorRadioExterno, valorRadioInterno, valorAltura)));
						campoVolumenC.setText(formatear.format(volumenCilindroHueco(valorRadioExterno, valorRadioInterno, valorAltura)));
					}
				}
			}
		}
		
		double perimetro(double radio){
			return Math.PI * radio * 2;
		}

		double areaCirculo(double radio){
			return Math.PI * radio * radio;
		} 

		double areaCilindro(double radio, double altura){
			return 2 * Math.PI * radio * (altura + radio);
		}

		double volumenCilindro(double radio, double altura){
			return Math.PI * radio * radio * altura;
		}

		double areaCilindroHueco(double radioExterno, double radioInterno, double altura){
			return 2*Math.PI * (Math.pow(radioExterno, 2) - Math.pow(radioInterno, 2)) + 2*Math.PI * altura * (radioExterno + radioInterno);
		}

		double volumenCilindroHueco(double radioExterno, double radioInterno, double altura){
			return Math.PI 	* altura * (Math.pow(radioExterno, 2) - Math.pow(radioInterno, 2));
		}

		void restablecer(){
			campoRadioCirculo.setText("");
			campoRadioCilindro.setText("");
			campoRadioExterno.setText("");
			campoRadioInterno.setText("");
			campoAlturaCilindro.setText("");
			campoAlturaCilindroH.setText("");
			campoPerimetroCirculo.setText("");
			campoAreaCirculo.setText("");
			campoAreaCilindro.setText("");
			campoAreaCilindroH.setText("");
			campoVolumenC.setText("");
			campoVolumenC.setText("");
		}

		boolean validarIngreso(String text){
			return text.matches("\\d+|\\d+\\.\\d+");
		}
	}

    public static void main(String[] args) {
		Perimetro_Areas_Figuras aplicacion = new Perimetro_Areas_Figuras();
    }
}
