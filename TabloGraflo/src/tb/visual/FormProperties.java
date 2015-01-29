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
	private Properties pr;
	private JLabel jl1;
	private JTextField tf1;
	private JTextField tf2;

	public FormProperties() throws HeadlessException {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(600,400));
		setResizable(false);
		setModal(true);
		setTitle("Properties");
		
		this.contentPane = new JPanel();
		this.contentPane.setBounds(0, 0, 600, 300);
		add(contentPane);
		this.contentPane.setLayout(null);
		
		this.jl1 = new JLabel("DBase Path:");
		this.jl1.setBounds(10, 40, 150, 20);
		this.jl1.setFont(new Font("Tahoma", Font.BOLD, 14));;
		this.contentPane.add(this.jl1);
		
		this.tf1 = new JTextField();
		this.tf1.setBounds(100, 38, 490, 20);
		this.tf1.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.pr = new Properties();
		this.tf1.setText(pr.getProperties());
		this.contentPane.add(this.tf1);
		
		this.tf2= new JTextField();
		this.tf2.setBounds(10,10,580,20);
		this.tf2.setEditable(false);
		this.contentPane.add(this.tf2);
		
		this.contentPane.add(new JButton("Ok"));
		
		pack();
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
	
}
