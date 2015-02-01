package tb.visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

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
	private JTextField jtfPath;
	private JTextField jtfConStr;
	private JButton jbStringBuilder;
	private JButton jbSave;
	private JButton jbExit;
	private JButton jbChange;
	JFileChooser fileopen;
	int ret;

	public FormProperties() throws HeadlessException {
		super();
		jd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jd.setPreferredSize(new Dimension(600,185));
		jd.setResizable(false);
		jd.setModal(true);
		jd.setTitle("Properties");
		
		this.contentPane = new JPanel();
		this.contentPane.setBounds(0, 0, 600, 185);
		jd.add(contentPane);
		this.contentPane.setLayout(null);
		
		this.jl1 = new JLabel("DBase Path:");
		this.jl1.setBounds(10, 70, 150, 20);
		this.jl1.setFont(new Font("Tahoma", Font.BOLD, 14));;
		this.contentPane.add(this.jl1);
		
		this.jtfPath = new JTextField();
		this.jtfPath.setBounds(100, 68, 460, 20);
		this.jtfPath.setEditable(false);
		this.jtfPath.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.pr = new userProperties();
		this.jtfPath.setText(pr.getProperties());
		this.contentPane.add(this.jtfPath);
		
		this.jl2 = new JLabel("CONNECTION STRING:");
		this.jl2.setBounds(10, 10, 300, 20);
		this.jl2.setFont(new Font("Tahoma", Font.BOLD, 14));;
		this.contentPane.add(this.jl2);
		
		this.jtfConStr= new JTextField();
		this.jtfConStr.setBounds(10,38,580,20);
		this.jtfConStr.setEditable(false);
		this.jtfConStr.setFont(new Font("Tahoma",Font.BOLD, 12));
		//this.jtfConStr.setBackground(Color.CYAN);
		//this.jtfConStr.setForeground(Color.MAGENTA);
		this.jtfConStr.setText(pr.getConStr());
		this.contentPane.add(this.jtfConStr);
		
		this.jbChange = new JButton("...");
		this.jbChange.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileopen = new JFileChooser();
				FileFilter fill = new FileNameExtensionFilter("DBase file", "db");
				fileopen.setFileFilter(fill);
				ret = fileopen.showDialog(null, "Open file");
				if(ret==JFileChooser.APPROVE_OPTION){
					jtfPath.setText(fileopen.getSelectedFile().getAbsolutePath());
				}
			}
		});
		this.jbChange.setBounds(563, 68, 27, 20);
		this.contentPane.add(jbChange);
		
		this.jbStringBuilder = new JButton("BuildString");
		this.jbStringBuilder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtfConStr.setText("jdbc:sqlite:"+jtfPath.getText());
				
			}
		});
		this.jbStringBuilder.setBounds(365,95,225,25);		
		this.contentPane.add(jbStringBuilder);
		
		this.jbSave = new JButton("Save");
		this.jbSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pr.putConStr(jtfConStr.getText());
				pr.putProperties(jtfPath.getText());
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
