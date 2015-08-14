package com.wsjonly.io;

import com.wsjonly.util.ObjectSerializedUtil;

public class ObjectSerializedTest {
	public static void main(String[] args) {
		Info info = new Info();
		info.setAge(24);
		info.setName("ShijinWeng");
		byte[] bytes = ObjectSerializedUtil.ObjectToByte(info);
		for(byte b : bytes) {
			System.out.print(b + " ");
		}
		System.out.println();
		System.out.println(bytes.length);
		System.out.println(bytes);
		
		Object object = ObjectSerializedUtil.ByteToObject(bytes);
		if (object instanceof Info) {
			Info info2 = (Info) object;
			System.out.println(info2);
		}
	}
}
