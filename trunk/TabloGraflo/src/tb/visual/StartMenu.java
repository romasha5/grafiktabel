package tb.visual;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import tb.properties.WhatIsOS;
import tb.start.Start;

public class StartMenu {
	
	JMenu menuFile = new JMenu("Файл");
	JMenuItem fileCalc = new JMenuItem ("Калькулятор");
	JMenuItem fileNotepad = new JMenuItem ("Блокнот");
	JMenuItem fileExit = new JMenuItem ("Вихід");
	
	JMenu menuDictionary =new JMenu("Довідники");
	JMenuItem dictionaryHumans = new JMenuItem("Працівники");
	JMenuItem dictionaryTime = new JMenuItem("Часові графіки");
	JMenuItem dictionaryRegulations = new JMenuItem("Норми робочих днів");
	JMenuItem dictionaryRegulationsTime = new JMenuItem("Норми робочого часу");
	
	JMenu menuWork = new JMenu("Введення даних");
	JMenuItem workTimesheet = new JMenuItem("Табель");
	JMenuItem workPlansheet = new JMenuItem("Графік");
	
	JMenu menuOptions = new JMenu("Параметри");
	JMenuItem optionsDBProperties = new JMenuItem("Налаштування БД");
	
	void setMenuFile() {
		this.fileCalc.setIcon(new ImageIcon(getClass().getResource("/icons/ator.png")));
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

	public void menuBuild(JMenuBar menuBar, Start str) {
		setMenuFile();
		setListeners(str);
		menuBar.add(this.menuFile);
		menuBar.add(this.menuDictionary);
		menuBar.add(this.menuWork);
		menuBar.add(this.menuOptions);
		
	}
	
	void setListeners(Start str){
		
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
		
		this.dictionaryHumans.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				str.setVisible(false);
				new FormHumans(str);
				
			}
		});
	}
	
	
	
	
	
}
