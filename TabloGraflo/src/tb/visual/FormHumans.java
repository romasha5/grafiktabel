package tb.visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tb.start.Start;

public class FormHumans extends JFrame {

	/**
	 * 
	 * @author Roma
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel contentPane;

	/**
	 * @throws HeadlessException
	 */
	public FormHumans(Start str) throws HeadlessException {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(1024,768));
		setResizable(false);
		ImageIcon img =new ImageIcon(getClass().getResource("/icons/address-book.png"));
		setIconImage(img.getImage());
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				str.setVisible(true);
				}
		});
		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());

		
		pack();
		setLocationRelativeTo(null);
		
		setVisible(true);
		
	}
	
	
	
}
