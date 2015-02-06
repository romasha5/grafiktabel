package tb.visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

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

		SelectDB sdb = new SelectDB();
		ArrayList<DbHumans> listDBH = null;
		try {
			listDBH= sdb.queryDbHumans();
			//JOptionPane.showMessageDialog(null, sdb.namefields[1]);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Object[][]rowdata = null;
		
		
		DefaultTableModel model = new DefaultTableModel();
		for (int i = 0; i < sdb.namefields.length; i++) {
			model.addColumn(sdb.namefields[i]);
			
		}
		
		for (int i = 0; i < listDBH.size(); i++) {
			rowdata[i][0]=listDBH.get(i).getId();
			rowdata[i][1]=listDBH.get(i).getLastname();
			rowdata[i][2]=listDBH.get(i).getName();
			rowdata[i][3]=listDBH.get(i).getFathersname();
			rowdata[i][4]=listDBH.get(i).getPosition();
			rowdata[i][5]=listDBH.get(i).getTablenumber();
			rowdata[i][6]=listDBH.get(i).getPercent();
			rowdata[i][7]=listDBH.get(i).getSex();
			rowdata[i][8]=listDBH.get(i).getId_time();
		}
		
		
		
		jsp = new JScrollPane(jt);
		jsp.setBounds(10, 10, 780, 400);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(jsp);
		
		jt = new JTable(model);
		jsp.setViewportView(jt);
		
		//JOptionPane.showMessageDialog(null, sdb.namefields.length);
		
		pack();
		setLocationRelativeTo(null);

		setVisible(true);
		
	}
	
	
}
