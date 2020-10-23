package puertos.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import puertos.control.BarcoException;
import puertos.control.Puerto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

/**
 * Interfaz gráfica sencilla que permite hacer algunas operaciones
 * con barcos en un puerto, principalmente para pruebas.
 * Esta ventana se generó con el WindowsBuilder (plugin de Eclipse).
 * @version 1.5
 */
public class VentanaControlBarcos extends JFrame {
	
	private Puerto puerto;

	private JPanel contentPane;
	private JTextField campoNacionalidad;
	private JTextField campoVolumen;
	private JTextField campoCapacidad;
	private JTextField campoPasajeros;
	private final ButtonGroup opcionesTipoBarco = new ButtonGroup();
	private JCheckBox checkLiquidos;
	private JTextField campoMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaControlBarcos frame = new VentanaControlBarcos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaControlBarcos() {
		
		puerto = new Puerto();
		
		setTitle("Control Barcos");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout constraintscontentPane = new GridBagLayout();
		constraintscontentPane.columnWidths = new int[]{122, 107, 191, 0};
		constraintscontentPane.rowHeights = new int[]{14, 20, 20, 20, 23, 23, 20, 23, 23, 2, 23, 0};
		constraintscontentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		constraintscontentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(constraintscontentPane);
		
		JLabel lblNuevoBarco = new JLabel("Nuevo Barco");
		GridBagConstraints constraintslblNuevoBarco = new GridBagConstraints();
		constraintslblNuevoBarco.anchor = GridBagConstraints.NORTH;
		constraintslblNuevoBarco.insets = new Insets(0, 0, 5, 5);
		constraintslblNuevoBarco.gridx = 1;
		constraintslblNuevoBarco.gridy = 0;
		contentPane.add(lblNuevoBarco, constraintslblNuevoBarco);
		
		JLabel lblMatrcula = new JLabel("Matrícula:");
		GridBagConstraints constraintslblMatrcula = new GridBagConstraints();
		constraintslblMatrcula.anchor = GridBagConstraints.WEST;
		constraintslblMatrcula.insets = new Insets(0, 0, 5, 5);
		constraintslblMatrcula.gridx = 0;
		constraintslblMatrcula.gridy = 1;
		contentPane.add(lblMatrcula, constraintslblMatrcula);
		
		JButton btnCrearBarco = new JButton("Crear Barco");
		btnCrearBarco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearBarco();
			}
		});
		
		campoMatricula = new JTextField();
		GridBagConstraints constraintscampoMatricula = new GridBagConstraints();
		constraintscampoMatricula.anchor = GridBagConstraints.NORTHWEST;
		constraintscampoMatricula.insets = new Insets(0, 0, 5, 0);
		constraintscampoMatricula.gridwidth = 2;
		constraintscampoMatricula.gridx = 1;
		constraintscampoMatricula.gridy = 1;
		contentPane.add(campoMatricula, constraintscampoMatricula);
		campoMatricula.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		GridBagConstraints constraintslblNacionalidad = new GridBagConstraints();
		constraintslblNacionalidad.fill = GridBagConstraints.HORIZONTAL;
		constraintslblNacionalidad.insets = new Insets(0, 0, 5, 5);
		constraintslblNacionalidad.gridx = 0;
		constraintslblNacionalidad.gridy = 2;
		contentPane.add(lblNacionalidad, constraintslblNacionalidad);
		
		campoNacionalidad = new JTextField();
		GridBagConstraints constraintscampoNacionalidad = new GridBagConstraints();
		constraintscampoNacionalidad.anchor = GridBagConstraints.NORTH;
		constraintscampoNacionalidad.fill = GridBagConstraints.HORIZONTAL;
		constraintscampoNacionalidad.insets = new Insets(0, 0, 5, 0);
		constraintscampoNacionalidad.gridwidth = 2;
		constraintscampoNacionalidad.gridx = 1;
		constraintscampoNacionalidad.gridy = 2;
		contentPane.add(campoNacionalidad, constraintscampoNacionalidad);
		campoNacionalidad.setColumns(10);
		
		JLabel lblVolumen = new JLabel("Volumen:");
		GridBagConstraints constraintslblVolumen = new GridBagConstraints();
		constraintslblVolumen.anchor = GridBagConstraints.WEST;
		constraintslblVolumen.insets = new Insets(0, 0, 5, 5);
		constraintslblVolumen.gridx = 0;
		constraintslblVolumen.gridy = 3;
		contentPane.add(lblVolumen, constraintslblVolumen);
		
		campoVolumen = new JTextField();
		GridBagConstraints constraintscampoVolumen = new GridBagConstraints();
		constraintscampoVolumen.anchor = GridBagConstraints.NORTHWEST;
		constraintscampoVolumen.insets = new Insets(0, 0, 5, 5);
		constraintscampoVolumen.gridx = 1;
		constraintscampoVolumen.gridy = 3;
		contentPane.add(campoVolumen, constraintscampoVolumen);
		campoVolumen.setColumns(10);
		
		JLabel lblMetrosCubicos = new JLabel("m3");
		GridBagConstraints constraintslblMetros = new GridBagConstraints();
		constraintslblMetros.anchor = GridBagConstraints.WEST;
		constraintslblMetros.insets = new Insets(0, 0, 5, 0);
		constraintslblMetros.gridx = 2;
		constraintslblMetros.gridy = 3;
		contentPane.add(lblMetrosCubicos, constraintslblMetros);
		
		JLabel lblTipo = new JLabel("Tipo:");
		GridBagConstraints constraintslblTipo = new GridBagConstraints();
		constraintslblTipo.anchor = GridBagConstraints.WEST;
		constraintslblTipo.insets = new Insets(0, 0, 5, 5);
		constraintslblTipo.gridx = 0;
		constraintslblTipo.gridy = 4;
		contentPane.add(lblTipo, constraintslblTipo);
		
		JRadioButton opcionVelero = new JRadioButton("Velero");
		opcionVelero.setActionCommand("velero");
		opcionesTipoBarco.add(opcionVelero);
		GridBagConstraints constraintsopcionVelero = new GridBagConstraints();
		constraintsopcionVelero.anchor = GridBagConstraints.NORTH;
		constraintsopcionVelero.fill = GridBagConstraints.HORIZONTAL;
		constraintsopcionVelero.insets = new Insets(0, 0, 5, 5);
		constraintsopcionVelero.gridx = 1;
		constraintsopcionVelero.gridy = 4;
		contentPane.add(opcionVelero, constraintsopcionVelero);
		
		JRadioButton opcionCarguero = new JRadioButton("Carguero");
		opcionCarguero.setActionCommand("carguero");
		opcionesTipoBarco.add(opcionCarguero);
		GridBagConstraints constraintsopcionCarguero = new GridBagConstraints();
		constraintsopcionCarguero.anchor = GridBagConstraints.NORTH;
		constraintsopcionCarguero.fill = GridBagConstraints.HORIZONTAL;
		constraintsopcionCarguero.insets = new Insets(0, 0, 5, 5);
		constraintsopcionCarguero.gridx = 1;
		constraintsopcionCarguero.gridy = 5;
		contentPane.add(opcionCarguero, constraintsopcionCarguero);
		
		JLabel lblPasajeros = new JLabel("Pasajeros:");
		GridBagConstraints constraintslblPasajeros = new GridBagConstraints();
		constraintslblPasajeros.anchor = GridBagConstraints.SOUTHWEST;
		constraintslblPasajeros.insets = new Insets(0, 0, 5, 5);
		constraintslblPasajeros.gridx = 0;
		constraintslblPasajeros.gridy = 6;
		contentPane.add(lblPasajeros, constraintslblPasajeros);
		
		campoPasajeros = new JTextField();
		GridBagConstraints constraintscampoPasajeros = new GridBagConstraints();
		constraintscampoPasajeros.anchor = GridBagConstraints.NORTHWEST;
		constraintscampoPasajeros.insets = new Insets(0, 0, 5, 5);
		constraintscampoPasajeros.gridx = 1;
		constraintscampoPasajeros.gridy = 6;
		contentPane.add(campoPasajeros, constraintscampoPasajeros);
		campoPasajeros.setColumns(10);
		
		JLabel lblLlevaLquidos = new JLabel("Lleva líquidos:");
		GridBagConstraints constraintslblLlevaLquidos = new GridBagConstraints();
		constraintslblLlevaLquidos.fill = GridBagConstraints.HORIZONTAL;
		constraintslblLlevaLquidos.insets = new Insets(0, 0, 5, 5);
		constraintslblLlevaLquidos.gridx = 0;
		constraintslblLlevaLquidos.gridy = 7;
		contentPane.add(lblLlevaLquidos, constraintslblLlevaLquidos);
		
		checkLiquidos = new JCheckBox("Sí");
		GridBagConstraints constraintscheckLiquidos = new GridBagConstraints();
		constraintscheckLiquidos.anchor = GridBagConstraints.NORTH;
		constraintscheckLiquidos.fill = GridBagConstraints.HORIZONTAL;
		constraintscheckLiquidos.insets = new Insets(0, 0, 5, 5);
		constraintscheckLiquidos.gridx = 1;
		constraintscheckLiquidos.gridy = 7;
		contentPane.add(checkLiquidos, constraintscheckLiquidos);
		GridBagConstraints constraintsbtnCrearBarco = new GridBagConstraints();
		constraintsbtnCrearBarco.anchor = GridBagConstraints.NORTHWEST;
		constraintsbtnCrearBarco.insets = new Insets(0, 0, 5, 5);
		constraintsbtnCrearBarco.gridx = 1;
		constraintsbtnCrearBarco.gridy = 8;
		contentPane.add(btnCrearBarco, constraintsbtnCrearBarco);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints constraintsseparator = new GridBagConstraints();
		constraintsseparator.anchor = GridBagConstraints.NORTH;
		constraintsseparator.fill = GridBagConstraints.HORIZONTAL;
		constraintsseparator.insets = new Insets(0, 0, 5, 0);
		constraintsseparator.gridwidth = 3;
		constraintsseparator.gridx = 0;
		constraintsseparator.gridy = 9;
		contentPane.add(separator, constraintsseparator);
		
		JLabel lblCapacidadTotal = new JLabel("Capacidad total:");
		GridBagConstraints constraintsLblCapacidadTotal = new GridBagConstraints();
		constraintsLblCapacidadTotal.fill = GridBagConstraints.HORIZONTAL;
		constraintsLblCapacidadTotal.insets = new Insets(0, 0, 0, 5);
		constraintsLblCapacidadTotal.gridx = 0;
		constraintsLblCapacidadTotal.gridy = 10;
		contentPane.add(lblCapacidadTotal, constraintsLblCapacidadTotal);
		
		JButton btnCalcularCapacidad = new JButton("Calcular Capacidad");
		btnCalcularCapacidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularCapacidad();
			}
		});
		
		campoCapacidad = new JTextField();
		campoCapacidad.setEditable(false);
		GridBagConstraints constraintsCampoCapacidad = new GridBagConstraints();
		constraintsCampoCapacidad.anchor = GridBagConstraints.WEST;
		constraintsCampoCapacidad.insets = new Insets(0, 0, 0, 5);
		constraintsCampoCapacidad.gridx = 1;
		constraintsCampoCapacidad.gridy = 10;
		contentPane.add(campoCapacidad, constraintsCampoCapacidad);
		campoCapacidad.setColumns(10);
		GridBagConstraints constraintsBtnCalcularCapacidad = new GridBagConstraints();
		constraintsBtnCalcularCapacidad.anchor = GridBagConstraints.NORTHWEST;
		constraintsBtnCalcularCapacidad.gridx = 2;
		constraintsBtnCalcularCapacidad.gridy = 10;
		contentPane.add(btnCalcularCapacidad, constraintsBtnCalcularCapacidad);
	}
	
	/**
	 * Acciones que se toman cuando se presiona el botón "crear Barco".
	 * Se deben obtener los datos necesarios, enviarlos a la clase
	 * de control y mostrar mensaje (dependiendo del resultado).
	 */
	public void crearBarco() {
		String matricula = campoMatricula.getText();
		String nacionalidad = campoNacionalidad.getText();
		double volumen = Double.parseDouble(campoVolumen.getText());
		ButtonModel botonSeleccionado = opcionesTipoBarco.getSelection();
		char tipo = botonSeleccionado.getActionCommand().charAt(0);
		int pasajeros = Integer.parseInt(campoPasajeros.getText());
		boolean liquidos = checkLiquidos.isSelected();
		
		try {
			boolean pudoAdicionar = puerto.adicionarBarco(matricula, nacionalidad, volumen, tipo, pasajeros, liquidos);
			if (pudoAdicionar) {
				JOptionPane.showMessageDialog(this,"Barco registrado");
			}
			else {
				JOptionPane.showMessageDialog(this,"Barco no registrado. Ya existe esa matrícula",
						"Error en registro",JOptionPane.WARNING_MESSAGE);
			}
		}
		catch (BarcoException errorRegistro) {
			JOptionPane.showMessageDialog(this,errorRegistro.getMessage(), 
					"Error en registro",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/**
	 * Acciones que se toman cuando se presiona el botón "calcular capacidad".
	 * Se deben obtener los datos necesarios, enviarlos a la clase
	 * de control y mostrar el valor en el campo correspondiente
	 */
	public void calcularCapacidad() {
		double capacidad = puerto.calcularCapacidadTotal();
		campoCapacidad.setText(""+capacidad);
	}
}
