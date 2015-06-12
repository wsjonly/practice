import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ConnectionTest {
	private static final int sTimeout = 120000;
    private static final int conTimeout = 10000;
    
    public static void sendGetRequest(String url) throws IOException, Exception{
		CloseableHttpClient cli = HttpClients.createDefault();
		HttpPost req = new HttpPost(url);
	    req.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
	    RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(sTimeout).setConnectTimeout(conTimeout).build();
	    req.setConfig(requestConfig);
	    HttpResponse resp = cli.execute(req);
	   
	    if (resp.getStatusLine().getStatusCode()/100 != 2){
	    	System.out.println(url);
	    };
    }
	
	public static void main(String[] args) throws Exception {
		 FileReader reader = new FileReader("url.txt");
         BufferedReader br = new BufferedReader(reader);
         String str = null;
         while((str = br.readLine()) != null) {
        	 String s = str.substring(str.indexOf("http"), str.length());
        	 sendGetRequest(s);
         }
         
	}
}
