

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

/**
 * 项目的工具类
 * 
 * @author chenxi
 * 
 */
public class MPUtil {

	public static byte[] ObjectToByte(java.lang.Object obj) {
		byte[] bytes = null;
		try {
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

	public static String generateSMSCode() {
		byte[] src = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random rand = new Random(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			sb.append(src[rand.nextInt(10)]);
		}
		return sb.toString();
	}
}
