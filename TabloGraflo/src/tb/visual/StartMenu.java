package tb.visual;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class StartMenu {
	
	JMenu menuFile = new JMenu("File");
	JMenuItem fileCalc = new JMenuItem ("Calc");
	JMenuItem fileExit = new JMenuItem ("Exit");
	
	JMenu menuOptions = new JMenu("Options");
	
	void setMenuFile() {
		this.menuFile.add(this.fileCalc);
		this.menuFile.addSeparator();
		this.menuFile.add(this.fileExit);
	}

	public void menuBuild(JMenuBar menuBar) {
		setMenuFile();
		setListeners();
		menuBar.add(this.menuFile);
		menuBar.add(this.menuOptions);
		
	}
	
	void setListeners(){
		
		this.fileCalc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Runtime r = Runtime.getRuntime();
				Process p = null;
				
				try {
					p = r.exec("calc");
					p.waitFor();
				}
				catch (Exception err) {
					JOptionPane.showMessageDialog(null, err);;
				}
				
			}
		});
		
		this.fileExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
	}
	
	
	
	
	
}
