import java.io.*;

public class ExceptionMain {

	public static void main(String[] args) {
		try{
			System.out.println("Reading from file:" + args[0]);
		} catch(ArrayIndexOutOfBoundsException ex) {
			System.err.println("未輸入檔案名稱，程式結束!");
			System.exit(0);
		}
		
		try(BufferedReader b = new BufferedReader(new FileReader(args[0]))) {	
			String s = null;			
			while((s = b.readLine()) != null) {
			System.out.println(s);
			}
		} catch(FileNotFoundException fe) {
			System.err.println("檔案("+args[0]+")不存在，程式結束!");
		} catch(IOException ie) {
			System.err.println("檔案內容讀取失敗，程式結束!");
		} 
		System.out.println("程式結束");
	}

}
