package com.wsjonly.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializedUtil{
	public static byte[] ObjectToByte(java.lang.Object obj) {
		byte[] bytes = null;
		try {
		    if(obj == null)
		        return bytes;
		    
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);

			bytes = bo.toByteArray();

			bo.close();
			oo.close();
		} catch (Exception e) {
			return null;
		}
		return bytes;
	}

	public static Object ByteToObject(byte[] bytes) {
		java.lang.Object obj = null;
		try {
		    if(bytes == null)
		        return obj;
		    
			ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
			ObjectInputStream oi = new ObjectInputStream(bi);

			obj = oi.readObject();

			bi.close();
			oi.close();
		} catch (Exception e) {
			return null;
		}
		return obj;
	}
}
