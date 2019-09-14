import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;

public class UserWB extends JFrame {

	private JPanel contentPane;
	private JTextField Account;
	private JTextField Name;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserWB frame = new UserWB();
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
	public UserWB() {
		setTitle("\u767B\u5165");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u5275\u5EFA\u5E33\u865F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CreatAccount().setVisible(true);
			}
		});
		btnNewButton.setBounds(14, 130, 99, 27);
		contentPane.add(btnNewButton);
		
		Account = new JTextField();
		Account.setBounds(85, 48, 333, 25);
		contentPane.add(Account);
		Account.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5E33\u865F");
		lblNewLabel.setBounds(14, 51, 57, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u78BC");
		lblNewLabel_1.setBounds(14, 89, 57, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D");
		lblNewLabel_2.setBounds(14, 13, 57, 19);
		contentPane.add(lblNewLabel_2);
		
		Name = new JTextField();
		Name.setBounds(85, 10, 333, 25);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u5FD8\u8A18\u5BC6\u78BC");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ForgetPassword().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(14, 163, 99, 27);
		contentPane.add(btnNewButton_1);
		
		User u = new User("","","");
		JButton btnNewButton_2 = new JButton("\u767B\u5165");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(u.Login(Name.getText().trim(),Account.getText().trim(),Password.getText().trim())) {
					JOptionPane.showMessageDialog(null, "登入成功", "訊息", JOptionPane.INFORMATION_MESSAGE);
					new FlightsNews().setVisible(true);
				}
				else JOptionPane.showMessageDialog(null, "登入失敗", "錯誤", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_2.setBounds(239, 124, 179, 104);
		contentPane.add(btnNewButton_2);
		//修改密碼
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539\u5BC6\u78BC");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ModifyPassword().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(128, 130, 99, 27);
		contentPane.add(btnNewButton_3);
		
		Password = new JPasswordField();
		Password.setBounds(85, 92, 333, 25);
		contentPane.add(Password);
	}
}
