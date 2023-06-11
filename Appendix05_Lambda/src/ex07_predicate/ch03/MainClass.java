package ex07_predicate.ch03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MainClass {
	
	public static double getAverage(Predicate<Person> predicate, List<Person> list) {
		int total = 0;
		int count = 0;
		for(Person p : list) {
			if(predicate.test(p)) {
				total += p.getAge();
				count++;
			}
		}
		return (double)total / count;
	}
	
	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
			new Person("정숙", 5),
			new Person("백호", 6),
			new Person("재홍", 20),
			new Person("정희", 21)
		);
		
		double youngAge = getAverage( t -> t.getAge() < 20 , people );
		double oldAge = getAverage( t -> t.getAge() >= 20 , people );
		
		System.out.println("미성년자 평균 나이: " + youngAge);
		System.out.println("성인 평균 나이: " + oldAge);
		
	}

}
