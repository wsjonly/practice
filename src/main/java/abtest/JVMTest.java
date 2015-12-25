package abtest;

public class JVMTest {
	public static void main(String[] args) {
		Integer a = (Integer)20;
		Integer b = (Integer)20;
		System.out.println(a == b); // true
		Integer a1 = (Integer)200;
		Integer b1 = (Integer)200;
		System.out.println(a1 == b1); //false
	}
}
