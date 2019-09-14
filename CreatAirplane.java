

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreatAirplane extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JLabel label_3;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AirplaneWindow frame = new AirplaneWindow();
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
	public CreatAirplane() {
		setTitle("\u5275\u5EFA\u822A\u73ED");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(86, 26, 96, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 69, 96, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(86, 110, 96, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(86, 155, 40, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u822A\u73EDID");
		lblNewLabel.setBounds(30, 29, 56, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u51FA\u767C\u5730");
		lblNewLabel_1.setBounds(30, 72, 56, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u76EE\u7684\u5730");
		lblNewLabel_2.setBounds(30, 113, 56, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u8D77\u98DB\u6642\u9593");
		lblNewLabel_3.setBounds(30, 158, 56, 15);
		contentPane.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(307, 26, 96, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(307, 69, 96, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(307, 110, 96, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(140, 155, 42, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u982D\u7B49\u8259");
		lblNewLabel_4.setBounds(251, 29, 46, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u5546\u52D9\u8259");
		lblNewLabel_5.setBounds(251, 72, 46, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u7D93\u6FDF\u8259");
		lblNewLabel_6.setBounds(251, 113, 46, 15);
		contentPane.add(lblNewLabel_6);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(202, 155, 40, 21);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(263, 155, 37, 21);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(320, 155, 40, 21);
		contentPane.add(textField_10);
		
		JLabel label = new JLabel("/");
		label.setBounds(130, 158, 25, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(192, 158, 25, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel(":");
		label_2.setBounds(307, 158, 46, 15);
		contentPane.add(label_2);
		
		JButton button = new JButton("\u78BA\u8A8D\u5275\u5EFA\u822A\u73ED");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if ((textField.getText().isEmpty() || textField_2.getText().isEmpty()
							|| textField_3.getText().isEmpty() || textField_4.getText().isEmpty()
							|| textField_6.getText().isEmpty() || textField_7.getText().isEmpty()
							|| textField_8.getText().isEmpty() || textField_9.getText().isEmpty()
							|| textField_10.getText().isEmpty() || textField_1.getText().isEmpty()
							|| textField_5.getText().isEmpty()))
					{	
						JOptionPane.showMessageDialog(null, "欄位不能為空!", "錯誤", JOptionPane.INFORMATION_MESSAGE);
					}
					
					else {
						Flight.createFlight(textField.getText(), textField_2.getText(), textField_3.getText(),
								textField_4.getText(), textField_6.getText(), textField_7.getText(),
								textField_8.getText(), textField_9.getText(), textField_10.getText(),
								textField_1.getText(), textField_5.getText());
						JOptionPane.showMessageDialog(null, "成功", "訊息", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
						
				} catch (Exception e2) {
				}
				// System.out.println(Flight.lFlight.get(0));
			}
		});
		button.setBounds(263, 217, 163, 23);
		contentPane.add(button);
		
		label_3 = new JLabel(": 00");
		label_3.setBounds(370, 158, 46, 15);
		contentPane.add(label_3);
	}

}
