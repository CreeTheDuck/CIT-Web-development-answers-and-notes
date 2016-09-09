
package test;
/* 
 * To change this template, choose Tools | Templates 
 * and open the template in the editor. 
 */ 
import java.awt.*;

import javax.swing.*;

import java.util.ArrayList; 
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Surgey { 

	private int surgeryId ; 
	private String surgeryAdd; 
	private static ArrayList<Doctor> docList = new ArrayList<Doctor>(); 
	static Scanner keyboard = new Scanner (System.in);// Scanner for Keyboard input.


	public static void main(String[] args) { 

		menu menu1 = new menu();
		//swing first = new swing();

		menu1.setTitle("Docotor Software");
	//	first.setSize(500,500);
	//	first.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	first.setVisible(true);





		docList.add(new Doctor("rob", "sss"));
		docList.add(new Doctor("robert", "tyue"));

		login();
		/*	for (int x = 0 ; x <= 2; x++){

			addDoctor();
		} 
		 */
	}


	private static void addDoctor() { 
		String name,password ;

		do{// Start of Do while Loop 
			keyboard.nextLine();
			System.out.print("Please Enters Doctor's Name : ");
			name = keyboard.nextLine();
		}while(!name.matches("^[\\p{L} .'-]+$"));// Validates input and checks that only string is input.


		do{// Start of Do while Loop
			System.out.print("Please Enter "+ name + "'s Password : ");
			password = keyboard.nextLine();
		}while(!name.matches("^[\\p{L} .'-]+$"));// Validates input and checks that only string is input.
		docList.add(new Doctor(name, password));// Adds doctors to class
		saveSystemToFile() ;
	} 

	private static void updateDoctor() { 

	} 
	private static void saveSystemToFile() { 
		BufferedWriter bWriter = null;
		try{
			File file = new File("Database.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fWriter = new FileWriter(file);
			bWriter = new BufferedWriter(fWriter);
			// Goes through each lecturer and writes its details
			for(int i=0; i<docList.size(); i++){
				bWriter.write(docList.get(i).getDoctorName().toString());
				bWriter.write(";");
				bWriter.write(docList.get(i).getDocPasswd().toString());
				bWriter.write(";");
				bWriter.write(docList.get(i).getDoctorId());
				bWriter.newLine();

			}
			System.out.print("Saved");
		}catch(IOException ex){
			ex.printStackTrace();
		}finally{
			try{
				// clears memory and closes writer
				if(bWriter != null){
					bWriter.flush();
					bWriter.close();
				}
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}    
	} 
	private static void restoreSystemFromFile() { 

	} 
	public static boolean login() {

		String name,password ;




		System.out.println("enter name please");

		name = keyboard.next();
		int x =  docList.size();
		System.out.println("enter password");

		password = keyboard.next();
		int i =0;
		for (i = 0 ; i <= x-1; i++){

			if (docList.get(i).getDoctorName().toString().equals(name) && (docList.get(i).getDocPasswd().toString().equals(password))){
				System.out.println("true");
				return true;

			}
		}
		return false;
	} 

	private static void display(){

		int x =  docList.size();
		for (int i =0;i <= x-1;i++) // Start of For Loop
		{
			docList.get(i).print();// Gets Person Information
		}


	}
} 