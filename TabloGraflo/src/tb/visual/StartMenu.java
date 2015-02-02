package tb.visual;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import tb.properties.WhatIsOS;

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
	
	JMenu menuWork = new JMenu("DataInput");
	JMenuItem workTimesheet = new JMenuItem("TimeSheet");
	JMenuItem workPlansheet = new JMenuItem("PlanSheet");
	
	JMenu menuOptions = new JMenu("Options");
	JMenuItem optionsDBProperties = new JMenuItem("DBProperties");
	
	void setMenuFile() {
		this.fileCalc.setIcon(new ImageIcon(getClass().getResource("/icons/сalculator.png")));
		this.menuFile.add(this.fileCalc);
		this.fileNotepad.setIcon(new ImageIcon(getClass().getResource("/icons/notepad.png")));
		this.menuFile.add(this.fileNotepad);
		this.menuFile.addSeparator();
		this.fileExit.setIcon(new ImageIcon(getClass().getResource("/icons/cancel.png")));
		this.menuFile.add(this.fileExit);
		
		this.workPlansheet.setIcon(new ImageIcon(getClass().getResource("/icons/plan.png")));
		this.menuWork.add(this.workPlansheet);
		this.workTimesheet.setIcon(new ImageIcon(getClass().getResource("/icons/tabel.png")));
		this.menuWork.add(this.workTimesheet);

		this.dictionaryHumans.setIcon(new ImageIcon(getClass().getResource("/icons/humans.png")));
		this.menuDictionary.add(this.dictionaryHumans);
		this.dictionaryTime.setIcon(new ImageIcon(getClass().getResource("/icons/time.png")));
		this.menuDictionary.add(this.dictionaryTime);
		this.menuDictionary.addSeparator();
		this.dictionaryRegulations.setIcon(new ImageIcon(getClass().getResource("/icons/regulation.png")));
		this.menuDictionary.add(this.dictionaryRegulations);
		this.dictionaryRegulationsTime.setIcon(new ImageIcon(getClass().getResource("/icons/regulationtime.png")));
		this.menuDictionary.add(this.dictionaryRegulationsTime);
		
		this.optionsDBProperties.setIcon(new ImageIcon(getClass().getResource("/icons/database.png")));
		this.menuOptions.add(this.optionsDBProperties);
	}

	public void menuBuild(JMenuBar menuBar) {
		setMenuFile();
		setListeners();
		menuBar.add(this.menuFile);
		menuBar.add(this.menuDictionary);
		menuBar.add(this.menuWork);
		menuBar.add(this.menuOptions);
		
	}
	
	void setListeners(){
		
		this.fileCalc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Runtime r = Runtime.getRuntime();
								
				try {
					if(WhatIsOS.getI()==0){
						r.exec("calc");
					}
					else if(WhatIsOS.getI()==1){
						r.exec("kcalc");
					}
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
				
				try {
					if(WhatIsOS.getI()==0){
						r.exec("notepad");
					}
					else if(WhatIsOS.getI()==1){
						r.exec("kjots");
					}
				}
				catch (Exception err) {
					JOptionPane.showMessageDialog(null, err);
				}
				
			}
		});
		
		this.fileExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		this.optionsDBProperties.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FormProperties();
			}
		});
	}
	
	
	
	
	
}
