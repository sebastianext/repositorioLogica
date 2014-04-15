package co.edu.uniquindio.interfaz;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
	private JEditorPane jEditorPane;
	private JButton jButtonAceptar;

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
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jTextFieldExpresion = new JTextField();
				getContentPane().add(jTextFieldExpresion);
				jTextFieldExpresion.setBounds(125, 31, 325, 27);
			}
			{
				jEditorPane = new JEditorPane();
				getContentPane().add(jEditorPane);
				jEditorPane.setBounds(12, 93, 438, 195);
			}
			{
				jButtonAceptar = new JButton();
				getContentPane().add(jButtonAceptar);
				jButtonAceptar.setBounds(470, 31, 63, 27);
				jButtonAceptar.setText("Aceptar");
			}
			pack();
			this.setSize(592, 459);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
