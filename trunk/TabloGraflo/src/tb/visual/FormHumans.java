package tb.visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import tb.dbaseclasses.DbHumans;
import tb.dbprovider.QueryHumansTable;
import tb.dbprovider.QueryTimeTable;
import tb.start.Start;

public class FormHumans extends JFrame {

	/**
	 * Клас відповідає за форму "Довідник працівників"
	 * @author Roma
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel contentPane;
	JTable jt;
	JScrollPane jsp;
	
	JLabel jllastname;
	JLabel jlname;
	JLabel jlfathersname;
	JLabel jlposition;
	JLabel jltablenumber;
	JLabel jlpercent;
	JLabel jlsex;
	JLabel jlidname;
	
	JTextField jtlastname;
	JTextField jtname;
	JTextField jtfathersname;
	JTextField jtposition;
	JTextField jttablenumber;
	JTextField jtpercent;
	JComboBox<Sex> jtsex;
	JComboBox<String> jtidname;
	
	JButton jbadd;
	JButton jbchange;
	JButton jbcopy;
	JButton jbdelete;
	JButton jbimport;
	JButton jbexpert;
	JButton jbsave;
	JButton jbexit;

	Integer ld;
	Integer td;
	Integer save=3;
	String idhumans;
	Boolean flag = false;
	Boolean flagaddchange=false;
	Boolean flagdelete = false;
	QueryHumansTable sdb;
	QueryTimeTable tdb;
	DefaultTableModel model;

	private Object[][] listDBH;
	private Object[][] listDBT;

	/**
	 * Конструктор форми "Довідник працівників"
	 * @throws HeadlessException
	 */
	public FormHumans(Start str) throws HeadlessException {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(805,550));
		setTitle("Довідник працівників");
		setResizable(false);
		ImageIcon img =new ImageIcon(getClass().getResource("/icons/address-book.png"));
		setIconImage(img.getImage());
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		getDani();
		getDaniTime();
		setJLabel();
		setJTtextFields();	
		setJButton();		
		allListeners(str);
		setvisualTable();		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);		
	}

	//Метод розміщення Label
	void setJLabel() {
		this.jllastname = new JLabel(sdb.namefields[1]+":");
		this.jllastname.setBounds(10, 415, 100, 20);
		this.jllastname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jllastname);
		
		this.jlname = new JLabel(sdb.namefields[2]+":");
		this.jlname.setBounds(10, 440, 100, 20);
		this.jlname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jlname);
		
		this.jlfathersname = new JLabel(sdb.namefields[3]+":");
		this.jlfathersname.setBounds(10, 465, 150, 20);
		this.jlfathersname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jlfathersname);

		this.jlposition = new JLabel(sdb.namefields[4]+":");
		this.jlposition.setBounds(10, 490, 150, 20);
		this.jlposition.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jlposition);

		this.jltablenumber = new JLabel(sdb.namefields[5]+":");
		this.jltablenumber.setBounds(285, 415, 150, 20);
		this.jltablenumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jltablenumber);
		
		this.jlpercent = new JLabel(sdb.namefields[6]+":");
		this.jlpercent.setBounds(285, 440, 150, 20);
		this.jlpercent.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jlpercent);
	
		this.jlsex = new JLabel(sdb.namefields[7]+":");
		this.jlsex.setBounds(285, 465, 150, 20);
		this.jlsex.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jlsex);

		this.jlidname = new JLabel(sdb.namefields[9]+":");
		this.jlidname.setBounds(285, 490, 150, 20);
		this.jlidname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jlidname);
	}
	

	//Метод розміщення TextFields
	void setJTtextFields() {
		this.jtlastname = new JTextField();
		this.jtlastname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jtlastname.setBounds(125, 415, 150, 20);
		this.jtlastname.setEditable(false);
		this.jtlastname.setFocusTraversalKeysEnabled(false);
		this.contentPane.add(this.jtlastname);

		this.jtname = new JTextField();
		this.jtname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jtname.setBounds(125, 440, 150, 20);
		this.jtname.setEditable(false);
		this.jtname.setFocusTraversalKeysEnabled(false);
		this.contentPane.add(this.jtname);

		this.jtfathersname = new JTextField();
		this.jtfathersname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jtfathersname.setBounds(125, 465, 150, 20);
		this.jtfathersname.setEditable(false);
		this.jtfathersname.setFocusTraversalKeysEnabled(false);
		this.contentPane.add(this.jtfathersname);

		this.jtposition = new JTextField();
		this.jtposition.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jtposition.setBounds(125, 490, 150, 20);
		this.jtposition.setEditable(false);
		this.jtposition.setFocusTraversalKeysEnabled(false);
		this.contentPane.add(this.jtposition);

		this.jttablenumber = new JTextField();
		this.jttablenumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jttablenumber.setBounds(360, 415, 150, 20);
		this.jttablenumber.setEditable(false);
		this.jttablenumber.setFocusTraversalKeysEnabled(false);
		this.contentPane.add(this.jttablenumber);

		this.jtpercent = new JTextField();
		this.jtpercent.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jtpercent.setBounds(360, 440, 150, 20);
		this.jtpercent.setEditable(false);
		this.jtpercent.setFocusTraversalKeysEnabled(false);
		this.contentPane.add(this.jtpercent);

		this.jtsex = new JComboBox<Sex>(Sex.values());
		this.jtsex.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jtsex.setBounds(360, 465, 150, 20);
		this.jtsex.setEnabled(false);
		this.jtsex.setFocusTraversalKeysEnabled(false);
		this.contentPane.add(this.jtsex);

		this.jtidname = new JComboBox<String>();
		for (int i = 0; i < this.tdb.timefields.length; i++) {
			this.jtidname.addItem(this.listDBT[i][1].toString());
		}		
		this.jtidname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jtidname.setBounds(360, 490, 150, 20);
		this.jtidname.setEnabled(false);
		this.jtidname.setFocusTraversalKeysEnabled(false);
		this.contentPane.add(this.jtidname);
	}
	

	//Метод розміщення Button
	void setJButton() {
		this.jbadd = new JButton("Додати");
		this.jbadd.setBounds(530, 415, 100, 20);
		this.contentPane.add(jbadd);
				
		this.jbchange = new JButton("Змінити");
		this.jbchange.setBounds(530, 440, 100, 20);
		this.contentPane.add(jbchange);
		
		this.jbdelete = new JButton("Видалити");
		this.jbdelete.setBounds(530, 465, 100, 20);
		this.contentPane.add(jbdelete);
	
		this.jbsave = new JButton("Зберегти");
		this.jbsave.setBounds(530, 490, 100, 20);
		this.jbsave.setEnabled(false);
		this.contentPane.add(jbsave);
		
		this.jbimport = new JButton("Імпорт");
		this.jbimport.setBounds(635, 415, 100, 45);
		this.contentPane.add(jbimport);
		
		this.jbexpert = new JButton("Ехпорт");
		this.jbexpert.setBounds(635, 465, 100, 45);
		this.contentPane.add(jbexpert);
		
		this.jbexit = new JButton();
		this.jbexit.setIcon(new ImageIcon(getClass().getResource("/icons/door.png")));
		this.jbexit.setBounds(740, 415, 50, 95);
		this.contentPane.add(jbexit);		
	}
	
	
	//Метод заповнює текстові та інші елементи значеннями
	void jtmode(){
		
		if(this.ld>0){
		int sr = jt.getSelectedRow();
		this.idhumans=model.getValueAt(sr, 0).toString();
		this.jtlastname.setText(model.getValueAt(sr, 1).toString());
		this.jtname.setText(jt.getValueAt(sr, 2).toString());
		this.jtfathersname.setText(jt.getValueAt(sr, 3).toString());
		this.jtposition.setText(jt.getValueAt(sr, 4).toString());
		this.jttablenumber.setText(jt.getValueAt(sr, 5).toString());
		this.jtpercent.setText(jt.getValueAt(sr, 6).toString());		
		
		if (jt.getValueAt(sr, 7).toString().length()==7) {
			this.jtsex.setSelectedItem(Sex.Чоловік);
		}
		else {
			this.jtsex.setSelectedItem(Sex.Жінка);
		}
		
		this.jtidname.setSelectedItem(jt.getValueAt(sr, 8).toString());
		}
	}
	
	//Метод підготовка до введення нового запису
	void prepereAdd(){
		jtname.setText(new String());
		jtfathersname.setText(new String());
		jtposition.setText(new String());
		jttablenumber.setText(new String());
		jtpercent.setText(new String());
		jtsex.setSelectedItem(null);
		jtidname.setSelectedItem(null);
		tabevent(jtlastname);
	}
	
	//Метод підготовка до змін
	void gochange(){
		jtlastname.setEditable(true);
		jtname.setEditable(true);
		jtfathersname.setEditable(true);
		jtposition.setEditable(true);
		jttablenumber.setEditable(true);
		jtpercent.setEditable(true);
		jtsex.setEnabled(true);
		jtidname.setEnabled(true);	
	}
	
	//Відміна введення чи зміни
	void revers(){
		jtlastname.setEditable(false);
		jtname.setEditable(false);
		jtfathersname.setEditable(false);
		jtposition.setEditable(false);
		jttablenumber.setEditable(false);
		jtpercent.setEditable(false);
		jtsex.setEnabled(false);
		jtidname.setEnabled(false);	
	}
	
	//Метод закриває фрейм
	void closeApp(Start str){
		dispose();
		str.setVisible(true);
	}
	
	//Заповнює поля текстом "Введіть дані" і передає фокус на наступне
	void tabevent(JTextField tf){
		if(!flagaddchange){
			tf.setText("Введіть дані");
   	 		tf.requestFocus();
   	 		tf.selectAll();
		}
		else {
  	 		tf.requestFocus();
   	 		tf.selectAll();
		}
	}
	
	//Отримання даних із таблиці працівники
	void getDani(){		
		this.sdb = new QueryHumansTable();
		try {
			this.listDBH=this.sdb.queryDbHumans();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
		this.ld = listDBH.length;				
	}
	
	//Отримання даних з таблиці часові графіки
	void getDaniTime(){
		this.tdb = new QueryTimeTable();
		try {
			this.listDBT=this.tdb.queryDbTime();			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		this.td = listDBT.length;
	}

	//model чіпляю до таблиці
	void setTablemodel(){
		jt = new JTable(model){
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int arg0, int arg1) {
                return false;
            }
        };
	}
	
	void setvisualTable(){
		model = new DefaultTableModel(listDBH,sdb.namefields);		
		setTablemodel();    			
		
		jsp = new JScrollPane(jt);
		jsp.setBounds(10, 10, 780, 400);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(jsp);
		
		jsp.setViewportView(jt);
		
		if(ld>0){
			
			
			jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if(!flagdelete){
						jtmode();
						}				
				}
			});

			
		jt.removeColumn(jt.getColumnModel().getColumn(8));
		jt.getTableHeader().setReorderingAllowed(false);
		
		
	    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
	    jt.setRowSorter(sorter);
		jt.getColumnModel().getColumn(0).setPreferredWidth(20);
		jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jt.setRowSelectionInterval(0, 0);
		}
	}

	//Всі слухачі
	void allListeners(Start str){
		//Закриття фрейму (основного)
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
					closeApp(str);
				}
		});
		
		this.jtlastname.addKeyListener(new KeyAdapter() {
		     public void keyPressed(KeyEvent e) {       
		         if ((e.getKeyCode() == KeyEvent.VK_ENTER) | (e.getKeyCode() == KeyEvent.VK_TAB)) {
		        	 tabevent(jtname);
		         }
		      }
		});
		
		this.jtname.addKeyListener(new KeyAdapter() {
		     public void keyPressed(KeyEvent e) {       
		         if ((e.getKeyCode() == KeyEvent.VK_ENTER) | (e.getKeyCode() == KeyEvent.VK_TAB)) {
		        	 tabevent(jtfathersname);
		         }
		      }
		});
		
		this.jtfathersname.addKeyListener(new KeyAdapter() {
		     public void keyPressed(KeyEvent e) {       
		         if ((e.getKeyCode() == KeyEvent.VK_ENTER) | (e.getKeyCode() == KeyEvent.VK_TAB)) {
		        	 tabevent(jtposition);
		         }
		      }
		});
		
		this.jtposition.addKeyListener(new KeyAdapter() {
		     public void keyPressed(KeyEvent e) {       
		         if ((e.getKeyCode() == KeyEvent.VK_ENTER) | (e.getKeyCode() == KeyEvent.VK_TAB)) {
		        	 tabevent(jttablenumber);
		         }
		      }
		});
		
		this.jttablenumber.addKeyListener(new KeyAdapter() {
		     public void keyPressed(KeyEvent e) {       
		         if ((e.getKeyCode() == KeyEvent.VK_ENTER) | (e.getKeyCode() == KeyEvent.VK_TAB)) {
		        	 tabevent(jtpercent);
		         }
		      }
		});
		
		this.jtpercent.addKeyListener(new KeyAdapter() {
		     public void keyPressed(KeyEvent e) {       
		         if ((e.getKeyCode() == KeyEvent.VK_ENTER) | (e.getKeyCode() == KeyEvent.VK_TAB)) {
		        	 jtsex.requestFocus();
		        	 if(!flagaddchange){
		        		 jtsex.setSelectedItem(null);
		        		 }	        	 
		         }
		      }
		});
		
		this.jtsex.addKeyListener(new KeyAdapter() {
		     public void keyPressed(KeyEvent e) {       
		         if ((e.getKeyCode() == KeyEvent.VK_ENTER) | (e.getKeyCode() == KeyEvent.VK_TAB)) {		        	 
		        	 jtidname.requestFocus();
		        	 if(!flagaddchange){
		        		 jtidname.setSelectedItem(null);
		        		 }
		         }
		      }
		});
		
		this.jtidname.addKeyListener(new KeyAdapter() {
		     public void keyPressed(KeyEvent e) {       
		         if ((e.getKeyCode() == KeyEvent.VK_ENTER) | (e.getKeyCode() == KeyEvent.VK_TAB)) {
		        	 if(!flagaddchange){
		        		 jbsave.setEnabled(true);
		        		 jbsave.setForeground(Color.GREEN);
		        		 jbsave.requestFocus();
		        	 }
		        	 else {
		        		 jbsave.requestFocus();
					}
		         }
		      }
		});
		
		this.jbadd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!flag){
					save=1;
					gochange();
					prepereAdd();
					jbadd.setText("Відміна");
					jbadd.setForeground(Color.RED);
					jbchange.setEnabled(false);
					
					flag = true;
				}
				else {
					jtmode();
					revers();
					jbadd.setText("Додати");
					jbadd.setForeground(Color.BLACK);
					jbchange.setEnabled(true);
					jbsave.setEnabled(false);
					flag = false;
				}
			}
		});
		
		this.jbchange.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!flag){
					save=0;
					gochange();
					jbchange.setText("Відміна");
					jbchange.setForeground(Color.RED);
					jbadd.setEnabled(false);
					jtlastname.requestFocus(true);
					jtlastname.selectAll();
					flag = true;
					flagaddchange = true;
					jbsave.setEnabled(true);
					jbsave.setForeground(Color.GREEN);
				}
				else {
					jtmode();
					revers();
					jbchange.setText("Змінити");
					jbchange.setForeground(Color.BLACK);
					flagaddchange = false;
					jbadd.setEnabled(true);
					jbsave.setEnabled(false);
					flag = false;
				}
				
			}
		});
		
		this.jbdelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int dr=JOptionPane.showConfirmDialog(null,"Запис буде вилучено. Продовжити?",
								"Попередження",JOptionPane.YES_NO_OPTION);
				if(dr == JOptionPane.YES_OPTION){
					try{
					flagdelete=!flagdelete;
					String sel = jt.getValueAt(jt.getSelectedRow(), 0).toString();
					}
					catch(IndexOutOfBoundsException ex){

						}
					}
					jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
						
						@Override
						public void valueChanged(ListSelectionEvent e) {
							if(!flagdelete){jtmode();}				
						}
					});
				}						
		});
		
		this.jbexit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closeApp(str);	
			}
		});
		
		this.jbsave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (save==1) {
					insertToTableHumans();					
				}
				else if(save==0) {
					UpdateToTableHumans();
				}
				jbsave.setEnabled(false);
			}
		});
	}
	
	void insertToTableHumans(){
		int id=0;
		for (int i = 0; i < listDBT.length; i++) {			
				if (listDBT[i][1]==this.jtidname.getSelectedItem().toString()) {
					id=(Integer)listDBT[i][0];
				}				
		}	
		
		int tablenumber;
		float percent;
		boolean f=false;
		try {
			tablenumber=Integer.valueOf(this.jttablenumber.getText());	
			f=!f;
			percent=Float.valueOf(this.jtpercent.getText());
			DbHumans dbh = new DbHumans(this.jtlastname.getText(),
					this.jtname.getText(),
					this.jtfathersname.getText(),
					this.jtposition.getText(),
					tablenumber,
					percent,
					this.jtsex.getSelectedItem().toString(),
					id);
            this.sdb.queryInsert(dbh);
		} catch (Exception e) {
			if (f) {
				int dr = JOptionPane.showConfirmDialog(null, "В полі 'Відсоток' не цифрові дані.", 
						"Попередженння", JOptionPane.YES_OPTION);
					if (dr==JOptionPane.YES_OPTION) {
						jtpercent.requestFocus();
						jtpercent.selectAll();
					}
			}
			else{
				int dr = JOptionPane.showConfirmDialog(null, "В полі 'Табельний №' не цифрові дані.", 
												"Попередженння", JOptionPane.YES_OPTION);
				if (dr==JOptionPane.YES_OPTION) {
					jttablenumber.requestFocus();
					jttablenumber.selectAll();
				}
			}
		}		
	}
	
	void UpdateToTableHumans(){
		int id=0;
		
		for (int i = 0; i < listDBT.length; i++) {			
				if (listDBT[i][1]==this.jtidname.getSelectedItem().toString()) {
					id=(Integer)listDBT[i][0];
				}				
		}	
		
		DbHumans dbh = new DbHumans(Integer.valueOf(this.idhumans),
									this.jtlastname.getText(),
									this.jtname.getText(),
									this.jtfathersname.getText(),
									this.jtposition.getText(),
									Integer.valueOf(this.jttablenumber.getText()),
									Float.valueOf(this.jtpercent.getText()),
									this.jtsex.getSelectedItem().toString(),
									id);
		this.sdb.queryUpdate(dbh);
	}
}
