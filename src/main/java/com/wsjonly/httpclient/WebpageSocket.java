package com.wsjonly.httpclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class WebpageSocket {

	private static int port = 80;

	private static String hostname = "www.baidu.com";

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket(hostname, port);

		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));

		writer.write("GET" + "/ask" + "HTTP/1.0rn");

		writer.write("HOST:" + hostname + "rn");

		writer.write("Accept:*/*rn");

		writer.write("rn");

		writer.flush();

		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

		String line = null;

		if ((line = reader.readLine()) != null) {

			System.out.println(line);

		}

		reader.close();

		writer.close();

		socket.close();

	}
}