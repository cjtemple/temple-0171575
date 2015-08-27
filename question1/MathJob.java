import java.io.*;
import java.util.*;

public class MathJob {
	
	public static void main(String[] args) {
		Double d = new Double("0.00");
		Integer i = 0;
		File f = null;
		File[] paths;
		
		try {
			f = new File("data/");
			paths = f.listFiles();
		
			for (File path:paths) {
				FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while((line = br.readLine()) != null) {
					String[] temp = line.split(" ");
					for (String value:temp) {
						if(isDouble(value)) {
							Double curr = d.parseDouble(value);
							i++;
							d = d + curr;
						}
					}
				}
				fr.close();				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(i>0) {
			System.out.println("mean: " + d/i);
		}
	}
	
	private static boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}