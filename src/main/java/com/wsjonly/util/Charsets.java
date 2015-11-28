package com.wsjonly.util;

import java.io.UnsupportedEncodingException;

public enum Charsets {

	GBK("GBK"), UTF8("UTF-8");

	public final String encoding;

	private Charsets(String value) {
		this.encoding = value;
	}

	public String toString(byte[] bytes) {
		return toString(bytes, encoding);
	}

	public byte[] getBytes(String s) {
		return getBytes(s, encoding);
	}

	public static byte[] getBytes(String s, String encoding) {
		try {
			return s.getBytes(encoding);
		} catch (UnsupportedEncodingException e) {
			return s.getBytes();
		}
	}

	public static String toString(byte[] bytes, String encoding) {
		try {
			return new String(bytes, encoding);
		} catch (UnsupportedEncodingException e) {
			return new String(bytes);
		}
	}

	public static void main(String[] args) {
		String s = "翁世进shijinweng";
		byte[] bytes = getBytes(s, Charsets.UTF8.encoding);
		for (int i = 0; i < bytes.length; i++) {
			System.err.print(bytes[i] + ":");
		}

		System.out.println();

		String ss = toString(bytes, Charsets.UTF8.encoding);
		System.out.println(ss);

	}
}
