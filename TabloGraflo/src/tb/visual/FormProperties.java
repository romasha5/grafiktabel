package tb.visual;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tb.properties.Properties;

public class FormProperties extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public FormProperties() throws HeadlessException {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(600,400));
		setResizable(false);
		setModal(true);
		setTitle("Properties");
		
		this.contentPane = new JPanel();
		add(contentPane);
		this.contentPane.setLayout(null);
		
		JLabel jl1 = new JLabel("DBase Path:");
		jl1.setBounds(10, 10, 150, 20);
		jl1.setFont(new Font("Tahoma", Font.BOLD, 14));;
		this.contentPane.add(jl1);
		
		JTextField tf1 = new JTextField();
		tf1.setBounds(100, 10, 490, 20);
		tf1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Properties pr = new Properties();
		tf1.setText(pr.getProperties());
		this.contentPane.add(tf1);
		
		this.contentPane.add(new JButton("Ok"));
		
		pack();
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
	
}
