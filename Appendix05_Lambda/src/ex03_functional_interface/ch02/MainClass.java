package ex03_functional_interface.ch02;

public class MainClass {

	public static void main(String[] args) {
		
		/*
			MyInterface myInterface = new MyInterface() {
				@Override
				public void method(int a) {
					System.out.println(a);
				}
			};
			myInterface.method(10);
		*/
		
		MyInterface myInterface = (a) -> System.out.println(a);
		myInterface.method(10);
		
	}

}
