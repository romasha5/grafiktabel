package tb.visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JDialog jd = new JDialog();
	private JPanel contentPane;
	private userProperties pr;
	private JLabel jl1;
	private JLabel jl2;
	private JTextField tf1;
	private JTextField tf2;
	private JButton jbStringBuilder;
	private JButton jbSave;
	private JButton jbExit;

	public FormProperties() throws HeadlessException {
		super();
		jd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jd.setPreferredSize(new Dimension(600,200));
		jd.setResizable(false);
		jd.setModal(true);
		jd.setTitle("Properties");
		
		this.contentPane = new JPanel();
		this.contentPane.setBounds(0, 0, 600, 200);
		jd.add(contentPane);
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
		
		this.jbStringBuilder = new JButton("BuildString");
		this.jbStringBuilder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tf2.setText("jdbc:sqlite:"+tf1.getText());
				
			}
		});
		this.jbStringBuilder.setBounds(480,90,110,25);
		this.contentPane.add(jbStringBuilder);
		
		this.jbSave = new JButton("Save");
		this.jbSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pr.putConStr(tf2.getText());
			}
		});
		this.jbSave.setBounds(365, 125, 110, 25);
		this.contentPane.add(jbSave);
		
		this.jbExit = new JButton("Exit");
		this.jbExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jd.dispose();
			}
		});
		this.jbExit.setBounds(480, 125, 110, 25);
		this.contentPane.add(jbExit);
		
		jd.pack();
		jd.setLocationRelativeTo(null);
		
		jd.setVisible(true);
	}
	
}
