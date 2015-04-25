package it.piergiuseppe82.hangapp.services.supports;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConvertHtmlToJavascriptString {
	
	public static void convert(String filePath) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filePath)); 
		System.out.println("var item = \"\";");
		while(scanner.hasNextLine()){			
			System.out.println("item = item + \""+scanner.nextLine().replaceAll("\"","'")+"\";");
		}
		scanner.close();
	}
}
