package tb.visual;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import tb.dbprovider.SelectDB;
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

	SelectDB sdb;
	private Object[][] rowdatas;	

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
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
					closeApp(str);
				}
		});

		sdb = new SelectDB();
		
		try {
			sdb.queryDbHumans();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ArrayList<DbHumans> listDBH = sdb.listDBH;
		rowdatas = new Object[listDBH.size()][sdb.namefields.length];
		DefaultTableModel model = new DefaultTableModel();
		
		

		for (int i = 0; i < sdb.namefields.length; i++) {
			model.addColumn(sdb.namefields[i]);			
		}
	
		
		for(int i = 0; i < listDBH.size(); i++){
				rowdatas[i][0]=listDBH.get(i).getId();
				rowdatas[i][1]=listDBH.get(i).getLastname();
				rowdatas[i][2]=listDBH.get(i).getName();
				rowdatas[i][3]=listDBH.get(i).getFathersname();
				rowdatas[i][4]=listDBH.get(i).getPosition();
				rowdatas[i][5]=listDBH.get(i).getTablenumber();
				rowdatas[i][6]=listDBH.get(i).getPercent();
				rowdatas[i][7]=listDBH.get(i).getSex();
				rowdatas[i][8]=listDBH.get(i).getTimeId();
				rowdatas[i][9]=listDBH.get(i).getTimeName();
			model.addRow(rowdatas[i]);
		}

		jsp = new JScrollPane(jt);
		jsp.setBounds(10, 10, 780, 400);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(jsp);
		
		jt = new JTable(model){
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int arg0, int arg1) {
                return false;
            }
        };;
		jsp.setViewportView(jt);
		
		jt.removeColumn(jt.getColumnModel().getColumn(8));
		jt.getTableHeader().setReorderingAllowed(false);
	    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
	    jt.setRowSorter(sorter);
		jt.getColumnModel().getColumn(0).setPreferredWidth(20);
		jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jt.setRowSelectionInterval(0, 0);
		
		jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				jtmode();
				
			}
		});
		
		try {
			sdb.queryDbTime();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		setJTtextFields(str);
		jtmode();
		pack();
		setLocationRelativeTo(null);

		setVisible(true);
		
	}
	
	public void setJTtextFields(Start str) {
		this.jllastname = new JLabel(sdb.namefields[1]+":");
		this.jllastname.setBounds(10, 415, 100, 20);
		this.jllastname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jllastname);
		
		this.jtlastname = new JTextField();
		this.jtlastname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jtlastname.setBounds(125, 415, 150, 20);
		this.jtlastname.setEditable(false);
		this.contentPane.add(this.jtlastname);
		
		this.jlname = new JLabel(sdb.namefields[2]+":");
		this.jlname.setBounds(10, 440, 100, 20);
		this.jlname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jlname);
		
		this.jtname = new JTextField();
		this.jtname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jtname.setBounds(125, 440, 150, 20);
		this.jtname.setEditable(false);
		this.contentPane.add(this.jtname);
		
		this.jlfathersname = new JLabel(sdb.namefields[3]+":");
		this.jlfathersname.setBounds(10, 465, 150, 20);
		this.jlfathersname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jlfathersname);
		
		this.jtfathersname = new JTextField();
		this.jtfathersname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jtfathersname.setBounds(125, 465, 150, 20);
		this.jtfathersname.setEditable(false);
		this.contentPane.add(this.jtfathersname);
		
		this.jlposition = new JLabel(sdb.namefields[4]+":");
		this.jlposition.setBounds(10, 490, 150, 20);
		this.jlposition.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jlposition);
		
		this.jtposition = new JTextField();
		this.jtposition.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jtposition.setBounds(125, 490, 150, 20);
		this.jtposition.setEditable(false);
		this.contentPane.add(this.jtposition);
		
		this.jltablenumber = new JLabel(sdb.namefields[5]+":");
		this.jltablenumber.setBounds(285, 415, 150, 20);
		this.jltablenumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jltablenumber);
		
		this.jttablenumber = new JTextField();
		this.jttablenumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jttablenumber.setBounds(360, 415, 150, 20);
		this.jttablenumber.setEditable(false);
		this.contentPane.add(this.jttablenumber);
		
		this.jlpercent = new JLabel(sdb.namefields[6]+":");
		this.jlpercent.setBounds(285, 440, 150, 20);
		this.jlpercent.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jlpercent);
		
		this.jtpercent = new JTextField();
		this.jtpercent.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jtpercent.setBounds(360, 440, 150, 20);
		this.jtpercent.setEditable(false);
		this.contentPane.add(this.jtpercent);
		
		this.jlsex = new JLabel(sdb.namefields[7]+":");
		this.jlsex.setBounds(285, 465, 150, 20);
		this.jlsex.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jlsex);
		
		this.jtsex = new JComboBox<Sex>(Sex.values());
		this.jtsex.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jtsex.setBounds(360, 465, 150, 20);
		this.jtsex.setEnabled(false);
		this.contentPane.add(this.jtsex);
		
		this.jlidname = new JLabel(sdb.namefields[9]+":");
		this.jlidname.setBounds(285, 490, 150, 20);
		this.jlidname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jlidname);
		
		this.jtidname = new JComboBox<String>();
		for (int i = 0; i < sdb.timefields.length; i++) {
			this.jtidname.addItem(sdb.timefields[i]);
		}
		
		this.jtidname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jtidname.setBounds(360, 490, 150, 20);
		this.jtidname.setEnabled(false);
		this.contentPane.add(this.jtidname);
		
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
		
		this.jbexit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closeApp(str);	
			}
		});
	}
	
	public void jtmode(){
		int sr = jt.getSelectedRow();
		jtlastname.setText(jt.getValueAt(sr, 1).toString());
		jtname.setText(jt.getValueAt(sr, 2).toString());
		jtfathersname.setText(jt.getValueAt(sr, 3).toString());
		jtposition.setText(jt.getValueAt(sr, 4).toString());
		jttablenumber.setText(jt.getValueAt(sr, 5).toString());
		jtpercent.setText(jt.getValueAt(sr, 6).toString());
		
		if (jt.getValueAt(sr, 7).toString().length()==7) {
			jtsex.setSelectedItem(Sex.Чоловік);
		}
		else {
			jtsex.setSelectedItem(Sex.Жінка);
		}
		
		jtidname.setSelectedItem(jt.getValueAt(sr, 8).toString());
	}
	
	public void closeApp(Start str){
		dispose();
		str.setVisible(true);
	}
}
