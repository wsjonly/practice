package com.wsjonly.httpclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class WebpageSocket {

	private static int port = 80;

	private static String hostname = "http://www.baidu.com";

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket(hostname, port);

		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));

		writer.write("GET " + "/intl/policies/privacy/ " + "HTTP/1.1\r\n");

		writer.write("HOST:" + hostname + "\r\n");

		writer.write("Accept:*/*\r\n");

		writer.write("\r\n");

		writer.flush();
		
		System.out.println("connection built");

		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

		String line = null;

		while ((line = reader.readLine()) != null) {

			System.out.println(line);

		}

		reader.close();

		writer.close();

		socket.close();

	}
}