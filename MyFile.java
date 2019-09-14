import static java.lang.System.out;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.filechooser.FileSystemView;


public class MyFile {
	static FileSystemView fsv = FileSystemView.getFileSystemView();// ���o�ୱ���|
	static String filePath = fsv.getHomeDirectory() + "/Account.csv";//�x�s�ɮ׸��|
	
	public static ArrayList<User> readUserFile() {
		
		ArrayList<User> dataFile = new ArrayList<>();

		try {
			File file = new File(filePath);
			
			if (!file.exists()) {
				try {
					file.createNewFile();
				} 
				catch (IOException e) {

				}
			} 
			else {
				Scanner scn = new Scanner(file);
				
				scn.nextLine();
				while (scn.hasNext()) {
					String sentence = scn.nextLine();
					String[] part = sentence.split(",");
					User tempUser = new User(part[0],part[1],part[2]);

					dataFile.add(tempUser);

				}
				scn.close();
			}
		} 
		catch (IOException e) {

		}
		return dataFile;
	}
	public static void writeUserFile(List<User> userData) {
		
		try {
			FileWriter file = new FileWriter(filePath,false);
			BufferedWriter fout = new BufferedWriter(file);

			fout.write("�ϥΪ�,�b��,�K�X\n");
			for(User i:userData){
				fout.write(i.toString()+"\n");
			}
			fout.close();
		} 
		catch (IOException e) {

		}
	}
	public static void readFilghtFile() {

		try {
			File file = new File("Flight.csv");
			
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {

				}
			}
			else {
				Scanner scn = new Scanner(file);
				
				while (scn.hasNext()) {
					String sentence = scn.nextLine();
					String[] part = sentence.split(",|:| |/");
					
					try {
						Flight.createFlight(part[0], part[1], part[2], part[3], part[4], part[5], part[6], part[7],
								part[8], part[9], part[10]);
					} 
					catch (Exception e) {

					}
				}
				scn.close();
			}
		} 
		catch (IOException e) {
			out.println(e.getMessage());
		}
	}
	public static void writeFlightFile(List<Flight> flightData) {
		
		try {
			FileWriter file = new FileWriter("Flight.csv",false);
			BufferedWriter fout = new BufferedWriter(file);

			fout.write("��Z,�Y����,�Ӱȿ�,�g�ٿ�,�X�o�ɶ�,�X�o�a,�ت��a\\n");
			for(Flight i:flightData){
				fout.write(i.toString()+"\n");
			}
			fout.close();
		} 
		catch (IOException e) {

		}
	}
}
