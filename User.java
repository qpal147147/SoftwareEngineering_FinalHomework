import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class User {

	private String Account;
	private String Password;
	private String Name;
	static private ArrayList<User> node = new ArrayList<>();
	
	public static ArrayList<User> getNode() {
		return node;
	}

	static String s = "";
	boolean f = true;
	static FileSystemView fsv = FileSystemView.getFileSystemView();// 取得桌面路徑
	static String filePath = fsv.getHomeDirectory() + "/Account.csv";//儲存檔案路徑
	
	
	public User(String name, String account, String password)  {
		this.Name = name;
		this.Account = account;
		this.Password = password;
	}

	public void setAccount(String account) {
		this.Account = account;
	}

	public String getAccount() {
		return Account;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getPassword() {
		return Password;
	}
	public String creatAccount(String name, String account, String password,String confirmPassword) throws IOException {
		
		if(foolProofing(name, account, password)) {
			if (!node.isEmpty()) {
				if (!searchAccount(account)) {
					if(password.equals(confirmPassword)){
						node.add(new User(name, account, password));
						MyFile.writeUserFile(node);
						return "創建成功";
					}
					else return "密碼錯誤";
				}
				else return "帳號重複";
			}
			else {
				if(password.equals(confirmPassword)) {
					node.add(new User(name, account, password));
					MyFile.writeUserFile(node);
					return "創建成功";
				}
				else return "密碼錯誤";
			}
		}
		else return "非法字元或長度錯誤";
	}

	static public boolean searchAccount(String account) {
		int count = 0;

		for (User u : node) {
			if (u.Account.equals(account))
				count = 1;
		}

		if (count == 1)
			return true;
		else
			return false;
	}

	static public boolean modifyPassword(String account, String beforePassword,String newPassword) throws Exception {
		boolean boo = false;
		if(foolProofing(account,beforePassword,newPassword)) {
			if (searchAccount(account)) {
				for (User u : node) {
					if (u.Account.equals(account) && u.Password.equals(beforePassword)) {
						u.Password = newPassword;
						MyFile.writeUserFile(node);
						boo = true;
					}
				}
			}
			if(boo)return true;
			else return false;
		}
		else return false;
	}

//	static public void saveFile() throws IOException {
//		
//		StringBuilder SB = new StringBuilder();
//
//		FileWriter FW = new FileWriter(filePath);
//		for (User u : node) {
//			SB.append(u);
//			SB.append("\n");
//		}
//		FW.write(SB.toString());
//		FW.close();
//	}
	
	public String forgetPassword(String name,String account) {
		String s = "N";
		
		for(User u:node) {
			if(u.Name.equals(name) && u.Account.equals(account)) {
				s = u.Password;
			}
		}
		return s;
	}
	
	static public boolean foolProofing(String name,String account,String password) {
		for(char c:name.toCharArray()) {
			if("~!@#$%^&*()_+/*-+".indexOf(c) != -1 || name.length() < 1 || name.length() >20) {
				return false;
			}
		}
		
		for(char c:account.toCharArray()) {
			if("~!@#$%^&*()_+/*-+".indexOf(c) != -1 || account.length() < 5 || account.length() >20) {
				return false;
			}
		}
		
		for(char c:password.toCharArray()) {
			if("~!@#$%^&*()_+/*-+".indexOf(c) != -1 || account.length() < 5 || account.length() >20) {
				return false;
			}
		}
		return true;
	}
	
	public boolean Login(String name,String account,String password) {
		boolean boo = false;
		for(User u:node) {
			if(u.Name.equals(name) && u.Account.equals(account) && u.Password.equals(password)) {
				boo = true;
				s = u.Account;
			}
		}
		return boo;
	}
	
	public static void readFile() {
		node = MyFile.readUserFile();
	}

	public String toString() {
		return Name + "," + Account + "," + Password;
	}
}