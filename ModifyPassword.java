import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ModifyPassword extends JFrame{

	private JPanel contentPane;
	private JTextField Account;
	private JPasswordField Password;
	private JPasswordField NewPassword;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					modifyPassword frame = new modifyPassword();
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
	public ModifyPassword() {
		setTitle("\u4FEE\u6539\u5BC6\u78BC");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5E33\u865F");
		lblNewLabel.setBounds(14, 13, 57, 19);
		contentPane.add(lblNewLabel);
		
		Account = new JTextField();
		Account.setBounds(114, 10, 304, 25);
		contentPane.add(Account);
		Account.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u78BC");
		lblNewLabel_1.setBounds(14, 48, 57, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u65B0\u5BC6\u78BC");
		lblNewLabel_2.setBounds(14, 86, 75, 19);
		contentPane.add(lblNewLabel_2);
		

		JButton btnNewButton = new JButton("\u4FEE\u6539\u5BC6\u78BC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if (Account.getText().trim().equals("") || Password.getText().trim().equals("") || NewPassword.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "欄位不能為空!", "錯誤", JOptionPane.INFORMATION_MESSAGE);
				} else
					try {
						if(User.modifyPassword(Account.getText().trim(),Password.getText().trim(),NewPassword.getText().trim())) {
							JOptionPane.showMessageDialog(null, "修改成功", "訊息", JOptionPane.INFORMATION_MESSAGE);
							Account.setText("");
							Password.setText("");
							NewPassword.setText("");
							dispose();
						}
						else JOptionPane.showMessageDialog(null, "帳號或密碼錯誤!", "錯誤", JOptionPane.INFORMATION_MESSAGE);
					}  catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setBounds(99, 148, 253, 56);
		contentPane.add(btnNewButton);
		
		Password = new JPasswordField();
		Password.setBounds(114, 45, 304, 25);
		contentPane.add(Password);
		
		NewPassword = new JPasswordField();
		NewPassword.setBounds(114, 83, 304, 25);
		contentPane.add(NewPassword);
	}
}
