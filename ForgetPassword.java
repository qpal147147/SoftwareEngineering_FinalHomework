import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgetPassword extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Account;
	private JLabel UserName;
	private JLabel UserAccount;
	private JLabel UserPassword;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ForgetPassword frame = new ForgetPassword();
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
	public ForgetPassword() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(14, 13, 57, 19);
		contentPane.add(lblNewLabel);
		
		Name = new JTextField();
		Name.setBounds(81, 10, 337, 25);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5E33\u865F");
		lblNewLabel_1.setBounds(14, 51, 57, 19);
		contentPane.add(lblNewLabel_1);
		
		Account = new JTextField();
		Account.setBounds(81, 48, 337, 25);
		contentPane.add(Account);
		Account.setColumns(10);
		
		UserName = new JLabel("\u4F7F\u7528\u8005\u59D3\u540D");
		UserName.setBounds(14, 119, 164, 19);
		contentPane.add(UserName);
		
		UserAccount = new JLabel("\u4F7F\u7528\u8005\u5E33\u865F");
		UserAccount.setBounds(14, 172, 164, 19);
		contentPane.add(UserAccount);
		
		UserPassword = new JLabel("\u4F7F\u7528\u8005\u5BC6\u78BC");
		UserPassword.setBounds(14, 221, 164, 19);
		contentPane.add(UserPassword);
		
		User u = new User("","","");
		btnNewButton = new JButton("\u67E5\u8A62");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(u.forgetPassword(Name.getText().trim(), Account.getText().trim()).equals("N")){
					JOptionPane.showMessageDialog(null, "無資料!", "錯誤", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					UserName.setText("使用者姓名:" + Name.getText().trim());
					UserAccount.setText("使用者帳號:" + Account.getText().trim());
					UserPassword.setText("使用者密碼:" + u.forgetPassword(Name.getText().trim(), Account.getText().trim()));
				}
			}
		});
		btnNewButton.setBounds(192, 119, 226, 121);
		contentPane.add(btnNewButton);
	}

}
