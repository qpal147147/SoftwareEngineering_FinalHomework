import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.filechooser.FileSystemView;

public class Main {
	
	static FileSystemView fsv = FileSystemView.getFileSystemView();// ���o�ୱ���|
	static String filePath = fsv.getHomeDirectory() + "/Account.csv";//�x�s�ɮ׸��|
	
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
