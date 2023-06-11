package ex03_functional_interface.ch01;

public class MainClass {

	public static void main(String[] args) {

		/*
			MyInterface myInterface = new MyInterface() {
				@Override
				public void method() {
					System.out.println("나는 집에 가고 싶다.");
				}
			};
		*/
		
		MyInterface myInterface = () -> System.out.println("나는 집에 가고 싶다.");
		myInterface.method();

	}

}
