import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FlightsNews extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookTicket frame = new BookTicket();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FlightsNews() {
		setTitle("\u822A\u73ED\u8CC7\u8A0A\u7CFB\u7D71");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		User u = new User("","","");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(309, 13, 109, 19);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText(u.s + ",§A¦n!");
		
		JButton btnNewButton = new JButton("\u5275\u5EFA\u822A\u73ED");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CreatAirplane().setVisible(true);
			}
		});
	
		btnNewButton.setBounds(14, 29, 261, 71);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u641C\u5C0B\u822A\u73ED");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SearchFlightNews().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(14, 133, 261, 82);
		contentPane.add(btnNewButton_1);
		
	}
}
