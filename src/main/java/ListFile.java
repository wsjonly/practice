import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ListFile{
	public static void main(String[] str)throws Exception{
		File f=null;
		f = new File("C:/Users/shijinweng/Desktop/mp-acounts-logs");               
		File[] list=f.listFiles();  
		for(int i=0;i<list.length;i++)
//			System.out.println(list[i].getAbsolutePath());
			CalSmsTotal(list[i].getAbsolutePath());
	}

	private static void CalSmsTotal(String absolutePath) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(new File(absolutePath)));
		String line;
		int total = 0;
		while ((line = br.readLine()) != null){
			if (line.contains("Send SMS")) {
//				System.out.println(line);
				total++;
			}
		}
		
		System.out.println(absolutePath.substring(absolutePath.length()-8, absolutePath.length()) + ":" + total);
	}
}
//