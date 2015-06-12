
import java.lang.StringBuffer;
import java.lang.reflect.Field;
import java.util.HashMap;

enum E { A, B }

public class ClassesTest {
	public static void main(String[] args) throws SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException {
		System.out.println(Boolean.class);
		
		Field f = System.class.getField("out");
		Class c = f.getDeclaringClass();
		System.out.println(c);
		
		System.out.println("shijin".getClass());
//		Class c = System.console().getClass();
//		System.out.println(c.newInstance());
		
//		Class c = A.getClass();
		Class<?>[] c2 = Character.class.getClasses();  
		System.out.println(c2[1]);
	}
}
