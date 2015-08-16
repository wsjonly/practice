package com.wsjonly.io.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * 使用 Buffer 进行 I/O 操作

除 NIO 外，使用 Java 进行 I/O 操作有两种基本方式：

使用基于 InputStream 和 OutputStream 的方式；
使用 Writer 和 Reader。
无论使用哪种方式进行文件 I/O，如果能合理地使用缓冲，就能有效地提高 I/O 的性能。

下面显示了可与 InputStream、OutputStream、Writer 和 Reader 配套使用的缓冲组件。

OutputStream-FileOutputStream-BufferedOutputStream

InputStream-FileInputStream-BufferedInputStream

Writer-FileWriter-BufferedWriter

Reader-FileReader-BufferedReader

使用缓冲组件对文件 I/O 进行包装，可以有效提高文件 I/O 的性能。
 * @author shijinweng
 *
 */
public class StreamVSBuffer {
	public static void streamMethod() throws IOException {
		try {
			long start = System.currentTimeMillis();
			// 请替换成自己的文件
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("StreamVSBuffertest.txt"));
			for (int i = 0; i < 10000; i++) {
				dos.writeBytes(String.valueOf(i) + "\r\n");// 循环 1 万次写入数据
			}
			dos.close();
			DataInputStream dis = new DataInputStream(new FileInputStream("StreamVSBuffertest.txt"));
			while (dis.readLine() != null) {
				
			}
			dis.close();
			System.out.println(System.currentTimeMillis() - start);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void bufferMethod() throws IOException {
		try {
			long start = System.currentTimeMillis();
			// 请替换成自己的文件
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(
					"StreamVSBuffertest.txt")));
			for (int i = 0; i < 10000; i++) {
				dos.writeBytes(String.valueOf(i) + "\r\n");// 循环 1 万次写入数据
			}
			dos.close();
			DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(
					"StreamVSBuffertest.txt")));
			while (dis.readLine() != null) {

			}
			dis.close();
			System.out.println(System.currentTimeMillis() - start);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			StreamVSBuffer.streamMethod();
			StreamVSBuffer.bufferMethod();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}