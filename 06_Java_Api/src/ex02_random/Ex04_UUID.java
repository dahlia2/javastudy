package ex02_random;

import java.util.UUID;

public class Ex04_UUID {

	public static void main(String[] args) {

		/*
			java.util.UUID
			1. 전역 고유 식별자(University Unique IDentifier)
			2. 32개의 16진수와 4개의 하이픈(-)로 구성된 식별자 값이다.
		*/
		
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		System.out.println(str);
		
		// 하이픈(-) 모두 없애기 : 모든 하이픈(-)을 빈 문자열("")로 바꾸기
		String str2 = str.replace("-", " ");
		System.out.println(str2);
		
	}
}
		
