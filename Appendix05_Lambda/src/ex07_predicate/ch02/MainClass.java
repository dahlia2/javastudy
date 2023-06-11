package ex07_predicate.ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MainClass {

	public static<T> void filter(Predicate<T> predicate, List<T> list) {  // filter( (t) -> t % 2 == 1, numbers ); 호출의 경우 아래와 같이 매개변수가 처리된다.
		                                                                  // Predicate<T> predicate = (t) -> t % 2 == 1
		                                                                  // List<T> list = numbers
		
		List<T> result = new ArrayList<T>();
		for(T item : list) {
			if(predicate.test(item)) {  // filter( (t) -> t % 2 == 1, numbers ); 호출의 경우 item % 2 == 1의 결과가 true이면 result.add(item)이 동작하므로 item이 홀수이면 result에 저장된다.
				result.add(item);
			}
		}
		System.out.println(result);
		
	}
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		filter( (t) -> t % 2 == 1, numbers );
		
	}

}
