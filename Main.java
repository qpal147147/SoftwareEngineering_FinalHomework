import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.filechooser.FileSystemView;

public class Main {
	
	static FileSystemView fsv = FileSystemView.getFileSystemView();// 取得桌面路徑
	static String filePath = fsv.getHomeDirectory() + "/Account.csv";//儲存檔案路徑
	
	public static void main(String[] args) throws Exception {
		User.readFile();
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					UserWB frame = new UserWB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}
}
