

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SearchFlightNews extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowHome frame = new windowHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public SearchFlightNews() {
		setTitle("\u641C\u5C0B\u822A\u73ED");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(14, 25, 313, 23);
		contentPane.add(comboBox);
		//comboBox.addItem(item);;
		
		
		JButton btnGTj = new JButton("\u522A\u9664");
		btnGTj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Flight.deleteFlight(comboBox.getSelectedItem().toString());
				comboBox.removeItem(comboBox.getSelectedItem().toString());
				//comboBox.getSelectedItem().toString()
				}catch(Exception e1) {
					e1.getMessage();
					JOptionPane.showMessageDialog(null, "請點選清單!", "錯誤", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnGTj.setBounds(341, 25, 85, 65);
		contentPane.add(btnGTj);
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Flight.deleteFlight(comboBox.getSelectedItem().toString());
				comboBox.removeItem(comboBox.getSelectedItem().toString());
				new CreatAirplane().setVisible(true);
				dispose();
				}catch(Exception e1) {
					e1.getMessage();
					JOptionPane.showMessageDialog(null, "請點選清單!", "錯誤", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button_1.setBounds(341, 103, 85, 72);
		contentPane.add(button_1);
		
		
		
		
		for(Flight f:Flight.lFlight) {
			comboBox.addItem(f.toString());
		}
	}
}

