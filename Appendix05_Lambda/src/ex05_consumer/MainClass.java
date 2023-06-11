package ex05_consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MainClass {

	/*
		Consumer 인터페이스
		
		1. 매개변수를 받아서 사용하고 어떤 값도 반환하지 않는 함수형 인터페이스이다.
		2. accept() 추상 메소드와 andThen() 디폴트 메소드를 가지고 있다.
		3. 값을 받아가기만 하고 돌려주지 않기 때문에(반환이 없음) 소비자라고 부른다.
		
		4. 형식
		
			@FunctionalInterface
			public interface Consumer<T> {
			
				void accept(T t);  // T 타입의 매개변수를 전달받아서 코드를 수행
				
				// 자신의 accept() 메소드를 실행한 뒤 매개변수로 전달받은 Consumer의 accept() 메소드를 실행하는 andThen() 메소드
				default Consumer<T> andThen(Consumer<? super T> after) {
			    	Objects.requireNonNull(after);
			    	return (T t) -> {
			    		accept(t);
			    		after.accept(t);
			    	};
				}
				
			}
	*/
	
	public static void m1() {
		
		// name을 받아서 출력하는 Consumer
		Consumer<String> consumer = (name) -> {
			System.out.println(name);
		};
		consumer.accept("정숙");
		consumer.accept("상철");
		
	}
	
	public static void m2() {
		
		// num을 받아서 출력하는 Consumer
		Consumer<Integer> consumer = num -> System.out.println(num);
		consumer.accept(1);
		consumer.accept(2);
		consumer.accept(3);
		
	}
	
	public static void m3() {
		
		Consumer<Integer> add = (n) -> System.out.println(n + "+" + n + "=" + (n + n));
		Consumer<Integer> sub = (n) -> System.out.println(n + "-" + n + "=" + (n - n));
		Consumer<Integer> mul = (n) -> System.out.println(n + "*" + n + "=" + (n * n));
		Consumer<Integer> div = (n) -> System.out.println(n + "/" + n + "=" + (n / n));
		
		// add,sub,mul,div는 모두 accept() 메소드를 실행한 뒤 andThen() 메소드를 실행하므로
		// add, sub, mul, div 순으로 실행된다.
		add.andThen(sub.andThen(mul.andThen(div))).accept(10);
		
	}
	
	public static void m4() {
		
		// 2개의 인수를 전달하려면 Consumer가 아닌 BiConsumer 인터페이스를 사용해야 한다.
		BiConsumer<String, String> biConsumer = (a, b) -> System.out.println(a + ", " + b);
		biConsumer.accept("Hello", "World");
		
	}
	
	public static void main(String[] args) {
		m4();
	}

}
