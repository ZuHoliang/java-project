import java.io.*;

public class Caseconversion {

	public static void main(String[] args) {
		boolean toUp = false;
		if(args.length==0) {
			System.err.println("JAVA Caseconversion U/L");
			System.exit(0);
		} else if(args[0].equalsIgnoreCase("U")) {
			toUp = true;
		} else if(args[0].equalsIgnoreCase("L")) {
			toUp = false;
		} else {
			System.err.println("JAVA Caseconversion U/L");
			System.exit(0);
		}
		try(FileReader fr = new FileReader("source.txt");
			FileWriter fw = new FileWriter("result.txt")){
			char[] input = new char[100];
			int count=0;
			while ((count=fr.read(input))>0) {
				String line = new String(input,0,count);
				String output = "";
				if(toUp) {
					output = line.toUpperCase();
				} else {
					output = line.toLowerCase();
				}
				fw.write(output);
			}
			fw.flush();
			System.out.println("檔案輸出完畢");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
