package tb.visual;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		setTitle("Properties");
		
		this.contentPane = new JPanel();
		add(contentPane);
		this.contentPane.setLayout(new FlowLayout());
		
		
		this.contentPane.add(new JLabel("ConnectionString:"),FlowLayout.LEFT);
		JTextField tf = new JTextField();
		
		this.contentPane.add(tf);
		
		this.contentPane.add(new JButton("Ok"));
		
		pack();
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
	
}
