import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import com.ibm.icu.text.SimpleDateFormat;


public class FileTest {
	public static void main(String[] args) throws IOException {
		File file = new File("xxxx");
		FileWriter fw = new FileWriter(file);
		BufferedWriter br = new BufferedWriter(fw);
		br.write("xfdvxfbxfb\n");
		br.write("srgvbdxzfgbizshgloziusr\n");
		br.write("xfgvxdgbvxb\n");
		br.close();
		fw.close();
		
		
		File f = new File("xxxx");
		FileReader fileReader = new FileReader(f);
		BufferedReader br2 = new BufferedReader(fileReader);
		while (br2.ready()) {
			System.out.println(br2.readLine());
		}
		br.close();
		fileReader.close();
		
		
		
		Date date = new Date();
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(d.format(date));
	}
}
