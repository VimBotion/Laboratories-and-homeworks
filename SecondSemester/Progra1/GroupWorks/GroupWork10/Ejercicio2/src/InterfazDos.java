/**
 *
 * @author Campoverde Esteban, Apolo Juan, Cabrera Franck
 */
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class InterfazDos extends JFrame {
    JPanel panelPrincipal, panelNombre, subpanelNombre, panelEmail, panelBotones, panelFormatoEmail, panelBotones2, panelBotonesFinal;
    JLabel etiqueta, etiquetaNombre, etiquetaApellido, etiquetaTitulo, etiquetaApodo, etiquetaFormato, etiquetaEmail;
    JTextField campoNombre, campoApellido, campoTitulo, campoApodo, campoEmail;

    JComboBox<String> comboBox;
    JButton addButton, editButton, removeButton, defaultButton, OK, deleteButton;
    ButtonGroup mailFormatGroup;
    JRadioButton htmlRadio, plainTextRadio, customRadio;
    GridBagConstraints restriccionesPanelCorreo, restriccionesPanelNombre;

	String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
	
    InterfazDos() {
		// Esquema de la ventana principal con gaps the 0 y 5
        setLayout(new BorderLayout(0, 5));

		// Border es una interface que genera un borde para un componente swing
		// EtchedBorder sirve para generar un borde grabado, en este caso da la ilusion de un borde 3D
        Border degradado = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		// Un borde de "color" degradado, con titulo, justificacion izquierda y alineado arriba
        Border NombreBorde = BorderFactory.createTitledBorder(degradado, "Name", TitledBorder.LEFT, TitledBorder.TOP);
        Border EmailBorde = BorderFactory.createTitledBorder(degradado, "E-mail", TitledBorder.LEFT, TitledBorder.TOP);
		// EmptyBorder para utilizar los metodos de border, como agregar el titulo sin mostrar las lineas del borde
        Border noBorde = BorderFactory.createEmptyBorder();
        Border TitleEmail = BorderFactory.createTitledBorder(noBorde, "Mail Format:", TitledBorder.LEFT, TitledBorder.TOP);

        panelNombre = new JPanel(new BorderLayout());
		// Borde con titulo Name
        panelNombre.setBorder(NombreBorde);

        panelEmail = new JPanel(new GridBagLayout());
		// Borde con titulo E-Mail
        panelEmail.setBorder(EmailBorde);

		// Restricciones para poder posicionar los elementos
        restriccionesPanelCorreo = new GridBagConstraints();
        restriccionesPanelNombre = new GridBagConstraints();

		// Panel principal contenedor
        panelPrincipal = new JPanel(new GridBagLayout());

		// Inicio del subpanel Nombre
        subpanelNombre = new JPanel(new GridBagLayout());

		// Etiquetas con texto justificado a la derecha
        etiquetaNombre = new JLabel("First Name: ", SwingConstants.RIGHT);
        etiquetaApellido = new JLabel("Last Name: ", SwingConstants.RIGHT);
        etiquetaTitulo = new JLabel("Title: ", SwingConstants.RIGHT);
        etiquetaApodo = new JLabel("Nickname: ", SwingConstants.RIGHT);
        etiquetaFormato = new JLabel("Display Format: ", SwingConstants.RIGHT);

		// Lista desplegable y Campos de texto
        comboBox = new JComboBox(items);
        campoNombre = new JTextField(15);
        campoApellido = new JTextField(15);
        campoTitulo = new JTextField(15);
        campoApodo = new JTextField(15);

		// Los componenentes dentro del Panel Nombre pueden crecer horizontalmente
        restriccionesPanelNombre.fill = GridBagConstraints.HORIZONTAL;
		// Insets es utilizado para el relleno (pading) externo de los componentes
		restriccionesPanelNombre.insets = new Insets(5, 5, 5, 5);

        restriccionesPanelNombre.gridx = 0;
        restriccionesPanelNombre.gridy = 0;
        restriccionesPanelNombre.gridwidth = 1;
        restriccionesPanelNombre.gridheight = 1;
        subpanelNombre.add(etiquetaNombre, restriccionesPanelNombre);

        restriccionesPanelNombre.gridx = 1;
        restriccionesPanelNombre.gridy = 0;
        restriccionesPanelNombre.gridwidth = 1;
        restriccionesPanelNombre.gridheight = 1;
        subpanelNombre.add(campoNombre, restriccionesPanelNombre);

        restriccionesPanelNombre.gridx = 2;
        restriccionesPanelNombre.gridy = 0;
        restriccionesPanelNombre.gridwidth = 1;
        restriccionesPanelNombre.gridheight = 1;
        subpanelNombre.add(etiquetaApellido, restriccionesPanelNombre);

        restriccionesPanelNombre.gridx = 3;
        restriccionesPanelNombre.gridy = 0;
        restriccionesPanelNombre.gridwidth = 1;
        restriccionesPanelNombre.gridheight = 1;
        subpanelNombre.add(campoApellido, restriccionesPanelNombre);

        restriccionesPanelNombre.gridx = 0;
        restriccionesPanelNombre.gridy = 1;
        restriccionesPanelNombre.gridwidth = 1;
        restriccionesPanelNombre.gridheight = 1;
        subpanelNombre.add(etiquetaTitulo, restriccionesPanelNombre);

        restriccionesPanelNombre.gridx = 1;
        restriccionesPanelNombre.gridy = 1;
        restriccionesPanelNombre.gridwidth = 1;
        restriccionesPanelNombre.gridheight = 1;
        subpanelNombre.add(campoTitulo, restriccionesPanelNombre);

        restriccionesPanelNombre.gridx = 2;
        restriccionesPanelNombre.gridy = 1;
        restriccionesPanelNombre.gridwidth = 1;
        restriccionesPanelNombre.gridheight = 1;
        subpanelNombre.add(etiquetaApodo, restriccionesPanelNombre);

        restriccionesPanelNombre.gridx = 3;
        restriccionesPanelNombre.gridy = 1;
        restriccionesPanelNombre.gridwidth = 1;
        restriccionesPanelNombre.gridheight = 1;
        subpanelNombre.add(campoApodo, restriccionesPanelNombre);

        restriccionesPanelNombre.gridx = 0;
        restriccionesPanelNombre.gridy = 2;
        restriccionesPanelNombre.gridwidth = 1;
        restriccionesPanelNombre.gridheight = 1;
        subpanelNombre.add(etiquetaFormato, restriccionesPanelNombre);

        restriccionesPanelNombre.gridx = 1;
        restriccionesPanelNombre.gridy = 2;
        restriccionesPanelNombre.gridwidth = 3;
        restriccionesPanelNombre.gridheight = 1;
        subpanelNombre.add(comboBox, restriccionesPanelNombre);

		// Fin del subPanelNombre

        panelNombre.add(subpanelNombre, BorderLayout.NORTH);

		// Inicio del panel Email
		restriccionesPanelCorreo.insets = new Insets(1, 5, 1, 5);
        etiquetaEmail = new JLabel("E-mail Address:");
        restriccionesPanelCorreo.gridx = 0;
        restriccionesPanelCorreo.gridy = 0;
        restriccionesPanelCorreo.gridwidth = 1;
        restriccionesPanelCorreo.gridheight = 1;
        panelEmail.add(etiquetaEmail, restriccionesPanelCorreo);

        campoEmail = new JTextField();
        restriccionesPanelCorreo.gridx = 1;
        restriccionesPanelCorreo.gridy = 0;
        restriccionesPanelCorreo.gridwidth = 2;
        restriccionesPanelCorreo.gridheight = 1;
        restriccionesPanelCorreo.weightx = 20;
        restriccionesPanelCorreo.fill = GridBagConstraints.HORIZONTAL;
        panelEmail.add(campoEmail, restriccionesPanelCorreo);

		// Inicio del Panel Botones
        panelBotones = new JPanel(new GridLayout(4, 1, 0, 4));
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        removeButton = new JButton("Remove");
        defaultButton = new JButton("As Default");

        panelBotones.add(addButton);
        panelBotones.add(editButton);
        panelBotones.add(removeButton);
        panelBotones.add(defaultButton);

        restriccionesPanelCorreo.gridx = 3;
        restriccionesPanelCorreo.gridy = 0;
        restriccionesPanelCorreo.gridwidth = 1;
        restriccionesPanelCorreo.gridheight = 2;

        panelEmail.add(panelBotones, restriccionesPanelCorreo);

		// Fin panel Botones

		JTextArea email = new JTextArea("Item 1\nItem 2\nItem 3\nItem 4\nItem 5");
        restriccionesPanelCorreo.gridx = 0;
        restriccionesPanelCorreo.gridy = 1;
        restriccionesPanelCorreo.gridwidth = 3;
        restriccionesPanelCorreo.gridheight = 2;
        restriccionesPanelCorreo.weightx = 100;
        restriccionesPanelCorreo.fill = GridBagConstraints.BOTH;
        panelEmail.add(email, restriccionesPanelCorreo);

		// Panel para los radioButtons 
        panelFormatoEmail = new JPanel(new GridLayout(1,3));
        panelFormatoEmail.setBorder(TitleEmail);
        htmlRadio = new JRadioButton("HTML");
        plainTextRadio = new JRadioButton("Plain Text");
        customRadio = new JRadioButton("Custom");

        mailFormatGroup = new ButtonGroup();
        mailFormatGroup.add(htmlRadio);
        mailFormatGroup.add(plainTextRadio);
        mailFormatGroup.add(customRadio);

        panelFormatoEmail.add(htmlRadio);
        panelFormatoEmail.add(plainTextRadio);
        panelFormatoEmail.add(customRadio);

        JPanel panelMailFor = new JPanel(new BorderLayout());

        panelMailFor.add(panelFormatoEmail, BorderLayout.WEST);

        restriccionesPanelCorreo.gridx = 0;
        restriccionesPanelCorreo.gridy = 3;
        restriccionesPanelCorreo.gridwidth = 2;
        restriccionesPanelCorreo.gridheight = 1;
        restriccionesPanelCorreo.fill = GridBagConstraints.BOTH;
        panelEmail.add(panelMailFor, restriccionesPanelCorreo);

        //Panel de botones OK y DELETE
        panelBotonesFinal = new JPanel(new BorderLayout());
        panelBotones2 = new JPanel(new GridLayout(1,2));

        OK = new JButton("OK");
        panelBotones2.add(OK);

        deleteButton = new JButton("Cancel");
        panelBotones2.add(deleteButton);

        panelBotonesFinal.add(panelBotones2, BorderLayout.EAST);

        restriccionesPanelCorreo.fill = GridBagConstraints.BOTH;
        restriccionesPanelCorreo.weightx = 1;
        restriccionesPanelCorreo.weighty = 1;

		// Anadir al panel principal en x = 0 y y = 0 el panelNombre
        restriccionesPanelCorreo.gridx = 0;
        restriccionesPanelCorreo.gridy = 0;
        restriccionesPanelCorreo.gridwidth = 1;
        restriccionesPanelCorreo.gridheight = 1;
        panelPrincipal.add(panelNombre, restriccionesPanelCorreo);

		// Anadir al panel principal en x = 0 y y = 1 el panelNombre
        restriccionesPanelCorreo.gridx = 0;
        restriccionesPanelCorreo.gridy = 1;
        restriccionesPanelCorreo.gridwidth = 1;
        restriccionesPanelCorreo.gridheight = 2;
        panelPrincipal.add(panelEmail, restriccionesPanelCorreo);

		// Anadir el panelPrincipal al esquema de la ventana
        add(panelPrincipal, BorderLayout.CENTER);
		// Anadir el panel de Botones OK y DELTE al esquema de la ventana
        add(panelBotonesFinal, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Design Preview [ContactEditorUI]");
        setSize(600, 400);
        setResizable(false);
        setVisible(true);
    }

	public static void main(String[] args) {
		InterfazDos ventana = new InterfazDos();
    }
}
