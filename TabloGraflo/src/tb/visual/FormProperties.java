package tb.visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormProperties extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public FormProperties() throws HeadlessException {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(500,400));
		setResizable(false);
		setModal(true);
		
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
