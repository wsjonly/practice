package com.wsjonly.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class HttpProxy {

	public static String getWebContentBySetSystemPort(String address) throws IOException {
		System.setProperty("http.proxyHost", "b.qypac.net");
		System.setProperty("http.proxyPort", "34027");
		URL url = new URL(address);
		URLConnection connetcion = url.openConnection();
		connetcion.setConnectTimeout(5000);
		InputStream is = connetcion.getInputStream();
		byte[] b = new byte[1000];
		String content = "";
		while (is.read(b) > 0) {
			content += new String(b, "utf-8");
		}

		return content;
	}
	
	public static String getWebContentByAddPorxy(String address) throws IOException {
		URL url = new URL(address);
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("b.qypac.net", 34027));
		URLConnection connetcion = url.openConnection(proxy);
		connetcion.setConnectTimeout(5000);
		InputStream is = connetcion.getInputStream();
		byte[] b = new byte[1000];
		String content = "";
		while (is.read(b) > 0) {
			content += new String(b, "utf-8");
		}

		return content;
	}
	

	public static void main(String[] args) throws IOException {
		String result = getWebContentBySetSystemPort("http://www.google.com");
//		String result = getWebContentByAddPorxy("http://www.google.com");
		System.out.println(result);

	}
}
