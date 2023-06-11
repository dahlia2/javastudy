package ex03_functional_interface.ch03;

public class MainClass {

	public static void main(String[] args) {
		
		
		/*
			MyInterface myInterface1 = new MyInterface() {
				@Override
				public int method() {
					int n = 10;
					return n;
				}
			};
			System.out.println(myInterface1.method());
		*/
		MyInterface myInterface1 = () -> {
			int n = 10;
			return n;
		};
		System.out.println(myInterface1.method());
		
		
		/*
		MyInterface myInterface2 = new MyInterface() {
			@Override
			public int method() {
				return 20;
			}
		};
		System.out.println(myInterface2.method());
		*/
		MyInterface myInterface2 = () -> 20;
		System.out.println(myInterface2.method());
		
		
	}

}
