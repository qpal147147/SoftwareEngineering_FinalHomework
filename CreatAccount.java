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
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CreatAccount extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Account;
	private JPasswordField Password;
	private JPasswordField ConfirmPassword;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login frame = new Login();
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
	public CreatAccount() {
		setTitle("\u5275\u5EFA\u5E33\u865F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(14, 13, 57, 19);
		contentPane.add(lblNewLabel);

		Name = new JTextField(); // 姓名
		Name.setBounds(83, 10, 335, 25);
		contentPane.add(Name);
		Name.setColumns(10);

		JLabel label = new JLabel("\u5E33\u865F");
		label.setBounds(14, 51, 57, 19);
		contentPane.add(label);

		Account = new JTextField(); // 帳號
		Account.setBounds(83, 48, 335, 25);
		contentPane.add(Account);
		Account.setColumns(10);

		JLabel label_1 = new JLabel("\u5BC6\u78BC");
		label_1.setBounds(14, 89, 57, 19);
		contentPane.add(label_1);

		// 創建帳號
		User u = new User("", "", "");
		JButton btnNewButton = new JButton("\u5275\u5EFA\u5E33\u865F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Name.getText().equals("") || Account.getText().equals("") || Password.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "欄位不能為空!", "錯誤", JOptionPane.INFORMATION_MESSAGE);
					} 
					else {
						String s = "";
						if((s = u.creatAccount(Name.getText().trim(), Account.getText().trim(), Password.getText().trim(),ConfirmPassword.getText().trim())) == "非法字元或長度錯誤") {
							JOptionPane.showMessageDialog(null, "非法字元或長度錯誤!", "錯誤", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(s == "密碼錯誤") {
							JOptionPane.showMessageDialog(null, "密碼錯誤!", "錯誤", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(s == "帳號重複") {
							JOptionPane.showMessageDialog(null, "帳號重複!", "錯誤", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "創建成功", "訊息", JOptionPane.INFORMATION_MESSAGE);
							Name.setText("");
							Account.setText("");
							Password.setText("");
							ConfirmPassword.setText("");
							dispose();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(103, 166, 232, 60);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u78BA\u8A8D\u5BC6\u78BC");
		lblNewLabel_1.setBounds(14, 127, 71, 19);
		contentPane.add(lblNewLabel_1);
		
		Password = new JPasswordField();
		Password.setBounds(83, 86, 335, 25);
		contentPane.add(Password);
		
		ConfirmPassword = new JPasswordField();
		ConfirmPassword.setBounds(83, 124, 335, 25);
		contentPane.add(ConfirmPassword);
	}
}
