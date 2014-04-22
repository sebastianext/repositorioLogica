package co.edu.uniquindio.interfaz;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import co.edu.uniquinido.logica.Formula;
import co.edu.uniquinido.logica.SubFormula;
import co.edu.uniquinido.logica.TablaVerdad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

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
public class NewJFrame extends javax.swing.JFrame {
	private JTextField jTextFieldExpresion;
	private JButton jButtonAceptar;
	private JPanel jPanelTabla;
	private JScrollPane jScrollPaneTabla;
	private JTable jTableContactos;
	DefaultTableModel modelo;
	String []vectoAtomos;
	private TablaVerdad tablaVerdad;
	private Formula f;
	String columnaMain="";


	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewJFrame inst = new NewJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public NewJFrame() {
		super();

		f= new Formula("pqrsty");
		tablaVerdad= new TablaVerdad(f);
		vectoAtomos= new String[f.getAtomos().size()];
		llenarVector();
		initGUI();
	}
	public void llenarVector(){

		for (int i = 0; i < vectoAtomos.length; i++) {
			columnaMain+="\""+f.getAtomos().get(i).getLexema()+"\",";
			vectoAtomos[i]=f.getAtomos().get(i).getLexema();
		}
		System.out.println(columnaMain);
		columnaMain=columnaMain.substring(0,columnaMain.length()-1).toString();
		System.out.println(columnaMain);
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			jPanelTabla = new JPanel();
			getContentPane().add(jPanelTabla);
			jPanelTabla.setBounds(12, 195, 878, 199);
			jPanelTabla.setLayout(null);
			jPanelTabla.setBorder(BorderFactory.createTitledBorder("Lista de Contactos"));

			{
				jScrollPaneTabla = new JScrollPane();
				jPanelTabla.add(jScrollPaneTabla);
				jScrollPaneTabla.setBounds(8, 18, 858, 171);
				{
					String[]  cabecera=vectoAtomos;
					String[][] datoss={ };
					modelo=new DefaultTableModel(datoss,cabecera);
					jTableContactos = new JTable();
					jPanelTabla.add(jTableContactos);
					jTableContactos.setModel(modelo);
					jTableContactos.setBounds(8, 29, 745, 129);
					jTableContactos.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jTableContactos.setRequestFocusEnabled(false);
					jScrollPaneTabla.setViewportView(jTableContactos);

				}
			}


			{
				jTextFieldExpresion = new JTextField();
				getContentPane().add(jTextFieldExpresion);
				jTextFieldExpresion.setBounds(125, 31, 325, 27);
			}
			{
				jButtonAceptar = new JButton();
				getContentPane().add(jButtonAceptar);
				jButtonAceptar.setBounds(470, 31, 98, 27);
				jButtonAceptar.setText("Aceptar");
				jButtonAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButtonAceptarActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(946, 465);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

	private void jButtonAceptarActionPerformed(ActionEvent evt) {
		tablaVerdad.llenarAtomos();

		int c= tablaVerdad.getCombinaciones();
		int a=f.getAtomos().size();
		ArrayList<SubFormula> sol=tablaVerdad.getSolocionesAtomos();
		for (int i = 0; i < tablaVerdad.getCombinaciones(); i++) {
			String vecto[]=new String[f.getAtomos().size()];
			for (int k = 0; k < f.getAtomos().size(); k++) {
//				vecto[k]=tablaVerdad.getSolocionesAtomos().get(k).getSoluciones().get(i);
			}
			modelo.addRow(vecto);
		}







	}

}
