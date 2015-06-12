import java.io.Serializable;
import java.io.UnsupportedEncodingException;

class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

public class Test {
	public static void main(String[] args) throws UnsupportedEncodingException {
		Person person = new Person();
		person.setAge(22);
		person.setName("Xiong Dan");
		byte[] b = MPUtil.ObjectToByte(person);
		System.out.println(new String(b, "utf-8"));
		String s = new String(b);
		Object o = MPUtil.ByteToObject(s.getBytes());
		if (o instanceof Person){
			System.out.println("can be instanced");
			String name = ((Person) o).getName();
			System.out.println(name);
		}
		
	}
}
