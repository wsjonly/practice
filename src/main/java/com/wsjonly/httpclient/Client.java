package com.wsjonly.httpclient;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("http://www.baidu.com", 80);

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"));
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		sendMessage(out, new File("/Users/shijinweng/Documents/Github/practice/src/main/java/pac"));
		readResponse(in);

		out.close();
		in.close();
		
		socket.close();
	}

	private static void sendMessage(BufferedWriter out, File request) throws IOException {
		System.out.println(" * Request");

		for (String line : getContents(request)) {
			System.out.println(line);
			out.write(line + "\r\n");
		}

		out.write("\r\n");
		out.flush();
	}

	private static void readResponse(BufferedReader in) throws IOException {
		System.out.println("\n * Response");

		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
	}

	private static List<String> getContents(File file) throws IOException {
		List<String> contents = new ArrayList<String>();

		BufferedReader input = new BufferedReader(new FileReader(file));
		String line;
		while ((line = input.readLine()) != null) {
			contents.add(line);
		}
		input.close();

		return contents;
	}
}
