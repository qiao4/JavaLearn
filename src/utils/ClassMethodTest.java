package utils;

public class ClassMethodTest {

	//String.format
	public void TestStringFormat() {
		for(int i = 0; i < 20000; i += ++i) {
			String str1 = String.format("%04d", i);
			log(str1);
		}
		
	}
	
	public void log(String msg) {
		System.out.println("TAG--" + msg + "--");
	}
}
