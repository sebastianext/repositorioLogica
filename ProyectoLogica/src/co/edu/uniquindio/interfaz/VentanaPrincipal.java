package co.edu.uniquindio.interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.button.StandardButtonShaper;
import org.jvnet.substance.skin.BusinessBlackSteelSkin;

import co.edu.uniquinido.logica.Constantes;
import co.edu.uniquinido.logica.Formula;
import co.edu.uniquinido.logica.SubFormulaDerecha;
import co.edu.uniquinido.logica.SubFormulaIzquierda;
import co.edu.uniquinido.logica.TablaVerdad;
import co.edu.uniquinido.logica.Validaciones;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class VentanaPrincipal extends javax.swing.JFrame {
	private JPanel jPanelTabla;
	private JScrollPane jScrollPaneTabla;
	private JButton jButtonBorrar;
	private JButton jButtonAceptar;
	private JTextField jTextFieldFomula;
	private JButton jButtonBicondicional;
	private JButton jButtonCondicional;
	private JButton jButtonNegacion;
	private JButton jButtonDisjuncion;
	private JTable jTableVerdad;
	private JMenu jMenuArbol;
	private JMenu jMenuAyuda;
	private JPanel jPanelFormula;
	private JButton jButtonConjuncion;
	private JPanel jPanelOperadores;
	private JMenu jMenu1;
	private JMenuBar jMenuBarOpciones;
	//	String columnaMain="";
	DefaultTableModel modelo;
	//	String []vectoAtomos;
	private TablaVerdad tablaVerdad;
	private Formula formula;



	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SubstanceLookAndFeel.setSkin(new BusinessBlackSteelSkin());
		SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");//Ejemplo de aplicacion de un watermark de Substance
		// mejorar el fondo  SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceCopperplateEngravingWatermark");
		VentanaPrincipal inst = new VentanaPrincipal();
		inst.jButtonAceptar.putClientProperty( SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
		inst.jButtonBorrar.putClientProperty( SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	public VentanaPrincipal() {
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Tabla de Verdad");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("img/tf.png")).getImage());
			{
				jMenuBarOpciones = new JMenuBar();
				setJMenuBar(jMenuBarOpciones);
				{
					jMenu1 = new JMenu();
					jMenuBarOpciones.add(jMenu1);
					jMenu1.setText("Menu");
				}
				{
					jMenuAyuda = new JMenu();
					jMenuBarOpciones.add(jMenuAyuda);
					jMenuAyuda.setText("Ayuda");
				}
				{
					jMenuArbol = new JMenu();
					jMenuBarOpciones.add(jMenuArbol);
					jMenuArbol.setText("Arbol");
				}
			}

			jPanelTabla = new JPanel();
			getContentPane().add(jPanelTabla);
			jPanelTabla.setBounds(12, 228, 1017, 246);
			jPanelTabla.setLayout(null);
			jPanelTabla.setBorder(BorderFactory.createTitledBorder("Tabla de Verdad"));
			{
				jPanelFormula = new JPanel();
				getContentPane().add(jPanelFormula);
				jPanelFormula.setBounds(10, 4, 1017, 212);
				jPanelFormula.setBorder(BorderFactory.createTitledBorder(null, "Formula", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
				jPanelFormula.setLayout(null);

				{
					{
						jTextFieldFomula = new JTextField();
						jPanelFormula.add(jTextFieldFomula);
						jTextFieldFomula.setBounds(241, 15, 472, 41);
						jTextFieldFomula.setFont(new java.awt.Font("Segoe UI",1,22));
						jTextFieldFomula.setForeground(new java.awt.Color(0,0,128));
					}
					jPanelOperadores = new JPanel();
					jPanelFormula.add(jPanelOperadores);
					jPanelOperadores.setBounds(241, 121, 472, 82);
					jPanelOperadores.setBorder(BorderFactory.createTitledBorder("Operadores"));
					jPanelOperadores.setLayout(null);
					{
						jButtonConjuncion = new JButton();
						jPanelOperadores.add(jButtonConjuncion);
						jButtonConjuncion.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/conjuncion.png")));
						jButtonConjuncion.setBounds(13, 15, 72, 65);
						jButtonConjuncion.setPressedIcon(new ImageIcon(getClass().getClassLoader().getResource("img/conjuncionpress.png")));
						jButtonConjuncion.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("img/conjuncionhover.png")));
						jButtonConjuncion.setBorderPainted(false);
						jButtonConjuncion.setContentAreaFilled(false);
						jButtonConjuncion.setFocusPainted(false);
						jButtonConjuncion.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButtonConjuncionActionPerformed(evt);
							}
						});
					}
					{
						jButtonDisjuncion = new JButton();
						jPanelOperadores.add(jButtonDisjuncion);
						jButtonDisjuncion.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/disjuncion.png")));
						jButtonDisjuncion.setBounds(96, 13, 79, 70);
						jButtonDisjuncion.setBorderPainted(false);
						jButtonDisjuncion.setContentAreaFilled(false);
						jButtonDisjuncion.setFocusPainted(false);
						jButtonDisjuncion.setPressedIcon(new ImageIcon(getClass().getClassLoader().getResource("img/disjuncionpress.png")));
						jButtonDisjuncion.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("img/disjuncionhover.png")));
						jButtonDisjuncion.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButtonDisjuncionActionPerformed(evt);
							}
						});
					}
					{
						jButtonNegacion = new JButton();
						jPanelOperadores.add(jButtonNegacion);
						jButtonNegacion.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/negado.png")));
						jButtonNegacion.setBounds(186, 11, 79, 72);
						jButtonNegacion.setBorderPainted(false);
						jButtonNegacion.setContentAreaFilled(false);
						jButtonNegacion.setFocusPainted(false);
						jButtonNegacion.setPressedIcon(new ImageIcon(getClass().getClassLoader().getResource("img/negadopress.png")));
						jButtonNegacion.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("img/negadohover.png")));
						jButtonNegacion.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButtonNegacionActionPerformed(evt);
							}
						});
					}
					{
						jButtonCondicional = new JButton();
						jPanelOperadores.add(jButtonCondicional);
						jButtonCondicional.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/condicional.png")));
						jButtonCondicional.setBounds(276, 6, 84, 74);
						jButtonCondicional.setBorderPainted(false);
						jButtonCondicional.setContentAreaFilled(false);
						jButtonCondicional.setFocusPainted(false);
						jButtonCondicional.setPressedIcon(new ImageIcon(getClass().getClassLoader().getResource("img/condicionalpress.png")));
						jButtonCondicional.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("img/condicionalhover.png")));
						jButtonCondicional.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButtonCondicionalActionPerformed(evt);
							}
						});
					}
					{
						jButtonBicondicional = new JButton();
						jPanelOperadores.add(jButtonBicondicional);
						jButtonBicondicional.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/bicondicional.png")));
						jButtonBicondicional.setBounds(371, 3, 84, 72);
						jButtonBicondicional.setBorderPainted(false);
						jButtonBicondicional.setContentAreaFilled(false);
						jButtonBicondicional.setFocusPainted(false);
						jButtonBicondicional.setPressedIcon(new ImageIcon(getClass().getClassLoader().getResource("img/bicondicionalpress.png")));
						jButtonBicondicional.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("img/bicondicionalhover.png")));
						jButtonBicondicional.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jButtonBicondicionalActionPerformed(evt);
							}
						});
					}
				}
				{
					jButtonAceptar = new JButton();
					jPanelFormula.add(jButtonAceptar);
					jButtonAceptar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/chulo.png")));
					jButtonAceptar.setBounds(308, 66, 146, 39);
					jButtonAceptar.setText("Aceptar");
					jButtonAceptar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonAceptarActionPerformed(evt);
						}
					});
				}
				{
					jButtonBorrar = new JButton();
					jPanelFormula.add(jButtonBorrar);
					jButtonBorrar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/borrar.png")));
					jButtonBorrar.setBounds(527, 65, 146, 39);
					jButtonBorrar.setText("Borrar");
					jButtonBorrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButtonBorrarActionPerformed(evt);
						}
					});
				}
				jScrollPaneTabla = new JScrollPane();
				jPanelTabla.add(jScrollPaneTabla);
				jScrollPaneTabla.setBounds(12, 18, 993, 218);
				{
					//					String[]  cabecera=vectorCabecera;
					//					String[][] datos={ };
					//					modelo=new DefaultTableModel(datos,cabecera);
					jTableVerdad = new JTable();
					jPanelTabla.add(jTableVerdad);
					//					jTableVerdad.setModel(modelo);
					jTableVerdad.setBounds(8, 29, 745, 129);
					jTableVerdad.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jTableVerdad.setRequestFocusEnabled(false);
					jScrollPaneTabla.setViewportView(jTableVerdad);

				}

			}
			pack();
			this.setSize(1057, 551);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

	private void jButtonAceptarActionPerformed(ActionEvent evt) {

		String expresion=jTextFieldFomula.getText();
		try {

			Validaciones validaciones= new Validaciones(expresion);
			validaciones.validarExpresion();
			formula= new Formula(expresion);
			tablaVerdad= new TablaVerdad(formula);
			tablaVerdad.llenarAtomos();

			tablaVerdad.darArbol(expresion);


			tablaVerdad.solucionFormula();
			String cabecera[]=tablaVerdad.llenarCabecera();
			limpiarTabla();
			mostrarTabla(cabecera);
			modelo.setRowCount(0);
			llenarTabla();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public void llenarTabla(){
		ArrayList<Object> soluciones=tablaVerdad.filtrarSubformulas();
		int c= tablaVerdad.getCombinaciones();
		int a=soluciones.size();

		for (int i = 0; i < c; i++) {
			String vector[]=new String[a];
			for (int k = 0; k < a; k++) {
				if (soluciones.get(k) instanceof SubFormulaIzquierda) {
					vector[k]=((SubFormulaIzquierda) soluciones.get(k)).getSoluciones().get(i);
				}
				if (soluciones.get(k) instanceof SubFormulaDerecha) {
					vector[k]=((SubFormulaDerecha) soluciones.get(k)).getSoluciones().get(i);
				}
			}
			modelo.addRow(vector);
		}

	}
	public void mostrarTabla(String []vectorCabecera){
		String[]  cabecera=vectorCabecera;
		String[][] datos={ };
		modelo=new DefaultTableModel(datos,cabecera);
		jTableVerdad.setModel(modelo);
	}

	private void jButtonBorrarActionPerformed(ActionEvent evt) {
		jTextFieldFomula.setText("");
		limpiarTabla();
	}
	private void limpiarTabla(){
		String[]  cabecera={};
		String[][] datos={ };
		modelo=new DefaultTableModel(datos,cabecera);
		jTableVerdad.setModel(modelo);
	}

	private void jButtonConjuncionActionPerformed(ActionEvent evt) {
		jTextFieldFomula.setText(jTextFieldFomula.getText()+Constantes.CONJUNCION2);
		jTextFieldFomula.requestFocus();
	}

	private void jButtonDisjuncionActionPerformed(ActionEvent evt) {
		jTextFieldFomula.setText(jTextFieldFomula.getText()+Constantes.DISYUNCION);
		jTextFieldFomula.requestFocus();
	}

	private void jButtonNegacionActionPerformed(ActionEvent evt) {
		jTextFieldFomula.setText(jTextFieldFomula.getText()+Constantes.NEGADO);
		jTextFieldFomula.requestFocus();
	}

	private void jButtonCondicionalActionPerformed(ActionEvent evt) {
		jTextFieldFomula.setText(jTextFieldFomula.getText()+Constantes.CONDICIONAL);
		jTextFieldFomula.requestFocus();
	}

	private void jButtonBicondicionalActionPerformed(ActionEvent evt) {
		jTextFieldFomula.setText(jTextFieldFomula.getText()+Constantes.BICONDICIONAL);
		jTextFieldFomula.requestFocus();
	}


}
