import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class FileRead {
	private static final int sTimeout = 120000;
    private static final int conTimeout = 10000;
    
	public static boolean sendGetRequest(String url) throws IOException, Exception{
		@SuppressWarnings("resource")
		String body = "";
		CloseableHttpClient cli = HttpClients.createDefault();
		HttpGet req = new HttpGet(url);
//	    req.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
	    RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(sTimeout).setConnectTimeout(conTimeout).build();
	    req.setConfig(requestConfig);
	    
	    try{
	        HttpResponse resp = cli.execute(req);
	 
	        if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
//	            body = EntityUtils.toString(resp.getEntity(), "utf-8");
	        	return true;
	        }
	    }catch(Exception e){
	 
	    }finally{
	        if(cli != null){
	            try{
	                cli.close();
	            }catch(Exception e){}
	        }
	    }
	    
	    return false;
	  }
	
	
	public static void readFile(String fileName) throws IOException {
		
		File f = new File(fileName);
		FileReader file = new FileReader(f);
		BufferedReader br = new BufferedReader(file);
		while (br.ready()) {
			System.out.println(br.readLine());
		}
		br.close();
		file.close();
	}
	
	
	public static void main(String[] args) throws IOException {
		String fileName = "xx.txt";

		readFile(fileName);
		
	}
}
