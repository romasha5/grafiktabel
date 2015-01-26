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
	JMenuItem fileNotepad = new JMenuItem ("Notepad");
	JMenuItem fileExit = new JMenuItem ("Exit");
	
	JMenu menuDictionary =new JMenu("Dictionary");
	JMenuItem dictionaryHumans = new JMenuItem("Humans");
	JMenuItem dictionaryTime = new JMenuItem("Time");
	JMenuItem dictionaryRegulations = new JMenuItem("Regulations");
	JMenuItem dictionaryRegulationsTime = new JMenuItem("RegulationsTime");
	
	JMenu menuOptions = new JMenu("Options");
	JMenuItem optionsDBProperties = new JMenuItem("DBProperties");
	
	void setMenuFile() {
		this.menuFile.add(this.fileCalc);
		this.menuFile.add(this.fileNotepad);
		this.menuFile.addSeparator();
		this.menuFile.add(this.fileExit);

		this.menuDictionary.add(this.dictionaryHumans);
		this.menuDictionary.add(this.dictionaryTime);
		this.menuDictionary.addSeparator();
		this.menuDictionary.add(this.dictionaryRegulations);
		this.menuDictionary.add(this.dictionaryRegulationsTime);
		
		this.menuOptions.add(this.optionsDBProperties);
	}

	public void menuBuild(JMenuBar menuBar) {
		setMenuFile();
		setListeners();
		menuBar.add(this.menuFile);
		menuBar.add(this.menuDictionary);
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
		
		this.fileNotepad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Runtime r = Runtime.getRuntime();
				Process p = null;
				
				try {
					p = r.exec("notepad");
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
