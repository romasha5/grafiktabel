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
		
		
		
		DefaultTableModel model = new DefaultTableModel(sdb.namefields,300);

		jt = new JTable(model);	
		
		
		jt.setBounds(10, 50, 780, 400);
		jt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		jsp = new JScrollPane(jt);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		contentPane.add(jt);
		contentPane.add(jsp);
		
		pack();
		setLocationRelativeTo(null);

		setVisible(true);
		
	}
	
	
}
