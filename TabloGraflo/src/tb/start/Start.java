package tb.start;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import tb.dbprovider.*;

public class Start extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new Start();
		Provider.connectToDeBase("jdbc:sqlite:grafiktabel.db");
		Provider.closeDeBase();
	}

	/**
	 * @throws HeadlessException
	 */
	public Start() throws HeadlessException {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(800,600));
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu [] menuTest = new JMenu [] {new JMenu("Файл"),new JMenu("Вигляд"),new JMenu("Вихід")};
		
		
		for (int i = 0; i<menuTest.length;i++) {
			menuBar.add(menuTest[i]);
		}
		
		JMenuItem [] menuItem0 = new JMenuItem []{new JMenuItem("Vasya"),new JMenuItem("Petya")};
		
		for (int i = 0; i<menuItem0.length;i++) {
			menuTest[0].add(menuItem0[i]);
		}
		

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	

}
