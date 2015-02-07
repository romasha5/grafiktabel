package tb.visual;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
	JTextField jtsex;
	JTextField jtidname;
	
	JButton jbadd;
	JButton jbchange;
	JButton jbcopy;
	JButton jbimport;
	JButton jbsave;

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
				dispose();
				str.setVisible(true);
				}
		});

		sdb = new SelectDB();
		ArrayList<DbHumans> listDBH = null;
		try {
			listDBH= sdb.queryDbHumans();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
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
				rowdatas[i][8]=listDBH.get(i).getId_time();
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
		
	    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
	    jt.setRowSorter(sorter);
		jt.getColumnModel().getColumn(0).setPreferredWidth(20);
		
		setJTtextFields();
		
		pack();
		setLocationRelativeTo(null);

		setVisible(true);
		
	}
	
	public void setJTtextFields() {
		this.jllastname = new JLabel(sdb.namefields[1]+":");
		this.jllastname.setBounds(10, 415, 100, 20);
		this.jllastname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.contentPane.add(this.jllastname);
		
		this.jtlastname = new JTextField();
		this.jtlastname.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.jtlastname.setBounds(105, 415, 150, 20);
		this.contentPane.add(this.jtlastname);
	}
	
}
