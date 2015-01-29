package tb.visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tb.properties.userProperties;

public class FormProperties extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private userProperties pr;
	private JLabel jl1;
	private JLabel jl2;
	private JTextField tf1;
	private JTextField tf2;
	private JButton jb1;

	public FormProperties() throws HeadlessException {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(600,200));
		setResizable(false);
		setModal(true);
		setTitle("Properties");
		
		this.contentPane = new JPanel();
		this.contentPane.setBounds(0, 0, 600, 200);
		add(contentPane);
		this.contentPane.setLayout(null);
		
		this.jl1 = new JLabel("DBase Path:");
		this.jl1.setBounds(10, 70, 150, 20);
		this.jl1.setFont(new Font("Tahoma", Font.BOLD, 14));;
		this.contentPane.add(this.jl1);
		
		this.tf1 = new JTextField();
		this.tf1.setBounds(100, 68, 490, 20);
		this.tf1.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.pr = new userProperties();
		this.tf1.setText(pr.getProperties());
		this.contentPane.add(this.tf1);
		
		this.jl2 = new JLabel("CONNECTION STRING");
		this.jl2.setBounds(10, 10, 300, 20);
		this.jl2.setFont(new Font("Tahoma", Font.BOLD, 14));;
		this.contentPane.add(this.jl2);
		
		this.tf2= new JTextField();
		this.tf2.setBounds(10,38,580,20);
		this.tf2.setEditable(false);
		this.tf2.setFont(new Font("Tahoma",Font.BOLD, 12));
		this.tf2.setBackground(Color.BLUE);
		this.tf2.setForeground(Color.YELLOW);
		this.tf2.setText(pr.getConStr());
		this.contentPane.add(this.tf2);
		
		this.jb1 = new JButton("BuildString");		
		this.jb1.setBounds(480,90,110,25);
		this.contentPane.add(jb1);
		
		pack();
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
	
}
