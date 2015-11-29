package com.wsjonly.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpUtils {
	
	private static Logger log = LoggerFactory.getLogger(HttpUtils.class);
	
	private static final int readTimeout = 30000;
	private static final int conTimeout = 3000;
	    
	public static void downloadImage(String url, String savePath) {
        InputStream in = null;
        InputStream in2 = null;
        FileOutputStream fos = null;
        HttpURLConnection httpConnection = null;
        try {
            long startTime = System.currentTimeMillis();
            URL rURL = new URL(url);
            httpConnection = (HttpURLConnection) rURL.openConnection();
            httpConnection.setConnectTimeout(conTimeout);
            httpConnection.setReadTimeout(readTimeout);
            httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.111 Safari/537.36");
//            httpConnection.
            in = httpConnection.getInputStream();
            
            File file = new File(savePath);
            fos = new FileOutputStream(file);
            
            int len = 0;
            final int MAXLEN = 1024*10;
            byte[] b = new byte[MAXLEN];
            while ((len = in.read(b)) > 0) {
                fos.write(b, 0, len);
                System.out.println(len);
            }
            
            log.info("download image end, use time="+(System.currentTimeMillis()-startTime)+"ms");
        } catch (MalformedURLException me) {
            log.error("MalformedURL error. " + me.toString() + " " + url);
        } catch (IOException ie) {
            log.error("downloadImage io error. " + ie.toString() + " " + url);
        } catch (Exception e) {
            log.error("downloadImage error. " + e.toString() + " " + url);
        } finally {
            try {
                if(in != null)
                    in.close();
                if(fos != null)
                    fos.close();
                if(httpConnection != null)
                    httpConnection.disconnect();
            } catch (Exception fe) {
                log.error("close error. " + fe.toString());
            }
        }
    }
	
//	public static void main(String[] args) {
//		HttpUtils.downloadImage("http://pic4.zhimg.com/5941d70f11e1405854a5bf84500a4261_b.jpg", "/opt/pics/test.jpg");
//	}
//	
	
    public static void main(String[] args) throws Exception {
        URL oracle = new URL("http://www.baidu.com/");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
	
}
