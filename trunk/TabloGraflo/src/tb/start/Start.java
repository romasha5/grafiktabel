package tb.start;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import tb.dbprovider.*;
import tb.visual.StartMenu;

public class Start extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new Start();
		Provider.connectToDeBase("jdbc:sqlite:baseSQLite\\grafiktabel.db");
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
		StartMenu stm = new StartMenu();
		stm.menuBuild(menuBar);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
