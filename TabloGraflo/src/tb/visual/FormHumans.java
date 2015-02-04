package tb.visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tb.start.Start;

public class FormHumans extends JFrame {

	/**
	 * 
	 * @author Roma
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel contentPane;
	JTable jt;
	JScrollPane jsp;
	

	/**
	 * @throws HeadlessException
	 */
	public FormHumans(Start str) throws HeadlessException {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(800,600));
		setResizable(false);
		ImageIcon img =new ImageIcon(getClass().getResource("/icons/address-book.png"));
		setIconImage(img.getImage());
		this.contentPane = new JPanel();
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				str.setVisible(true);
				}
		});

		
		
		this.jt = new JTable(2,7);
		this.jt.setBounds(10, 10, 780, 400);
		this.jt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		this.jsp = new JScrollPane(jt);
		
		
		this.contentPane.add(jt);
		this.contentPane.add(jsp);
		
		
		
		
		pack();
		setLocationRelativeTo(null);
		
		setVisible(true);
		
	}
	
	
	
}
