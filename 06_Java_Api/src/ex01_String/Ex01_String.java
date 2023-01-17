package ex01_String;

public class Ex01_String {

	public static void literal() {
		
		// 문자열 리터럴(Literal)
		String str1 = "Hello";
		String str2 = "hello";
		
		// 문자열 리터럴은 Java에 의해서 최적화 되기 때문에
		// 동일한 리터럴("hello")를 2번 이상 사용하면
		// 기존에 사용한 리터럴을 재사용한다. ("hello"라는 리터럴이 2개 이상 만들어 지지 않는다.)
		
	/*
        |-------|
    str1| 0x123 |
        |-------|         
    str2| 0x123 |          
        |-------|          
        |  ...  | 0x123    
        |-------|          

	*/
		
	// 참조값이 같다는 의미이다. 저장된 문자열이 같다는 의미가 아니다.
	System.out.println(str1 == str2);
		
	}
	
	public static void stringObject() {
		
		// 문자열 객체(Object)
		String str1 = new String ("hello");
		String str2 = new String ("hello");
		
		// 문자열 객체는 언제나 새로 생성된다
		
	/*
        |-------|
    str1| 0x123 |
        |-------|         
    str2| 0x456 |          
        |-------|          
        |  ...  | 0x123    
        |-------|          
		|"hello"|
        |-------|         
		| ...   |          
        |-------|          
        |"hello"|    
        |-------|          

	 */
		
	// 참조값이 다르다는 의미이다. 저장된 문자열이 다르다는 의미가 아니다.
	System.out.println(str1 == str2);
		
	}
	
	public static void equals() {
		
		// equals 메소드
		// 비교하는 문자열이 동일하면 true, 아니면 false 반환
		// 오직 문자열만 비교 가능
		
		String str1 = "Hello";
		String str2 = new String("HELLO");
		
		// 대소문자도 일치해야 함
		if(str1.equals(str2)) {
			System.out.println("str1과 str2는 같은 문자열이다.");
		} else {
			System.out.println("str1과 str2는 다른 문자열이다.");
		}
		
		// 대소문자는 무시함
		// equalsIgnoreCase 메소드  -> Case(upper case, lower case)를 무시함
		if(str1.equalsIgnoreCase(str2)) {
			System.out.println("str1과 str2는 같은 문자열이다.");
		} else {
			System.out.println("str1과 str2는 다른 문자열이다.");
		}
	}
	
	public static void length() {
		
		// length 메소드
		// 문자열의 길이(글자수)를 반환
		
		String str = "Hello\nWorld";
		int length = str.length();
		System.out.println("글자수 : " + length);
		
		// 배열의 length: 필드    arr.length 괄호 사용 X
		// 문자의 length: 메소드  str.length() 괄호 사용 O
		
	}

	public static void charAt() {
		
		// charAt 메소드
		// 문자열의 특정 인덱스 문자(char)를 반환
		
		String name = "이현주";
		System.out.println(name.charAt(0));
		System.out.println(name.charAt(1));
		System.out.println(name.charAt(2));
		
		for(int i = 0; i < name.length(); i ++) {   // name.length();은 메소드 실행을 반복하는 것임으로 메모리 낭비 -> 안 좋은 코드 -> 리팩토링
			System.out.println(name.charAt(i));
		}
		
	}
		
	public static void substring() {
		
		// substring 메소드
		// 문자열의 일부 문자열을 반환
		
		// substring 사용법
		// 1. substring(int begin) : 인덱스 begin부터 끝까지 반환
		// 2. substring(int begin, int end) : 인덱스 begin부터 end 이전까지 반환(begin <=     < end)
			
			String name = "이현주";
			String familyName = name.substring(0,1);  // String 타입이므로 charAt 메소드 사용 X
			String givenName = name.substring(1);
			
			System.out.println(familyName);
			System.out.println(givenName);
			
		}
		
	public static void indexOf() {
			
			// indexOf
			// 특정 문자열의 인덱스 정보를 반환
			// 발견된 첫 번째 문자열의 인덱스 정보를 반환
			// 발견된 문자열이 없는 경우 -1을 반환
			
			// indexOf 사용법
			// 1. indexOf(String str) : 인덱스 0부터 str을 검색
			// 2. indexOf (String str, int index) : 인덱스 index부터 str을 검색
			
			String slogan = "걱정한다고 걱정이 없어지면 걱정이 없겠네";
			int idx1 = slogan.indexOf("걱정");
			int idx2 = slogan.indexOf("걱정", idx1 + 1);
			int idx3 = slogan.indexOf("걱정", idx2 + 1);
			
			int idx4 = slogan.indexOf("이현주");
			
			System.out.println(idx1);
			System.out.println(idx2);
			System.out.println(idx3);
			System.out.println(idx4);
			
		}
		
	public static void lastIndexOf() {
			
			// lastIndexOf
			// 발견된 마지막 문자열의 인덱스를 반환
			// 나머지 특성은 indexOf와 동일
			
			String slogan = "걱정한다고 걱정이 없어지면 걱정이 없겠네";
			int idx1 = slogan.lastIndexOf("걱정");
			int idx2 = slogan.lastIndexOf("이현주");
			
			System.out.println(idx1);
			System.out.println(idx2);
			
		}
	
	public static void startsWith() {
		
		// startsWith
		// 문자열이 지정된 정규식 패턴(Regular Expression)으로 시작하면 true 반환
		
		// endsWith
		// 문자열이 지정된 정규식 패턴(Regular Expression)으로 끝나면 true 반환
		
		// matches
		// 문자열이 지정된 정규식 패턴(Regular Expression)을 포함하면 true 반환
		
		String name = "이현주";
		
		if(name.startsWith("이")) {
			System.out.println("이씨다.");
		} else {
			System.out.println("민씨가 아니다.");
		}
		
	}

	public static void containts() {
		
		// containts
		// 문자열이 지정된 CharSequence(String, char[] 등)를 포함하면 true 반환
		// charsequence -> string이라고 생각하면 됨
		
		// 참고
		// public interface CharSequence { }
		// public class String implements CharSequence { }
		
		String email = "dahlia2@gmail.com";
		if(email.contains("@")) {
			System.out.println("이메일이 맞다.");
		} else {
			System.out.println("이메일이 아니다.");
		}
		
	}
	
	public static void toCase() {
		
		// toUpperCase
		// 대문자로 변환
		
		// toLowerCase
		// 소문자로 변환
		
		String str = "I am a boy";
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		
		}
	
	public static void trim() {
		
	// trim
	// 문자열의 앞뒤에 포함된 공백 문자를 제거
	String str = "   hahaha   hohoho ";
	
	System.out.println(("(" +  str + ")"));
	System.out.println(("(" +  str.trim() + ")"));
	
	}
	
	public static void replace() {
	
	// replace
	// 기존 문자열을 새로운 문자열로 변환
	
	// replace 사용법
	// replace(String str1, String str2)
	// 모든 str1을 str2로 변환
		
	String str = "best of the best";
	String result = str.replace("best", "worst");
	System.out.println(result);
	
	// replaceAll
	// 정규식 패턴(Regular Expression)을 만족하는 부분을 변환한 결과를 반환
	// 정규식 패턴: [0-9] [a-z] [0-9a-z]
	String ip = "61.78.121.242";
	String replacedIp = ip.replaceAll(".", "_");   // 정규식에서 마침표 -> 모든 문자를 의미   // replace와 헷갈림 주의  
	System.out.println(replacedIp);

	}
	
	public static void isEmpty() {
		
		// isEmpty
		// 빈 문자열이면 true 반환
		// 빈 문자열(""): 문자열의 길이가 0이면 빈 문자열
		
		String str = " ";
		
		if(str.trim().isEmpty()) {    // 공백을 먼저 없앤다음
			System.out.println("빈 문자열이다.");
		} else {
			System.out.println("빈 문자열이 아니다.");
		}
		
		// isBlank
		// 빈 문자열이거나 공백 문자로만 구성되었다면 true 반환
		// JDK 11 이후에서만 사용 가능
		if(str.isBlank()) {    // 공백을 먼저 없앤다음
			System.out.println("빈 문자열이다.");
		} else {
			System.out.println("빈 문자열이 아니다.");
			
		}
		
	}
		
	public static void format() {
		
		// format
		// 문자열을 지정한 형식으로 반환
		
		// 숫자 형식 지정하기
		int number = 10000;
		
		System.out.println(String.format("%o", number));  //%o : 8진수로 표시하시오
		System.out.println(String.format("%d", number));  //%d : 10진수로 표시하시오
		System.out.println(String.format("%x", number));  //%d : 16진수로 표시하시오 (0~9, a, b, c, d, e, f)
		System.out.println(String.format("%x", number));  //%d : 16진수로 표시하시오 (0~9, A, B, C, D, E, F)
		
		
		// 문자열 형식 지정학
		String str = "hi";
		System.out.println(String.format("%s", str));
		
		// 출력 폭 
		System.out.println(String.format("%10d", number));  // %10d : 10자리로 표시하시오
		System.out.println(String.format("%10d", number));  // %-10d : 10자리로 표시하시오. 숫자는 오른쪽에
		System.out.println(String.format("%5s", number));  // %5s : 10자리로 표시하시오
		System.out.println(String.format("%-5s", number));  // %-5s : 10자리로 표시하시오
	}
	
	
	
	public static void ex01() {
			
			String url = "https://comic.naver.com/webtoon/list?titleId=758037&weekday=mon";
			
			String requestURI = url.substring(0, url.indexOf("?"));
			
			for(int i = 0; i < url.length(); i++); {
			System.out.println(requestURI);
			}
			
			String params = url.substring(url.indexOf("?") + 1);
			System.out.println(params);
			
		}
	
	public static void ex02() {
			
			/* String fullName =  "apple.jpg"; // "a.p.p.l.e.jpg"; // 파일명은 글자마다 .로 되어있음
			
			String fileName = fullName.substring(0, fullName.lastIndexOf("."));
			
			String extName = fullName.substring(fullName.indexOf(".") + 1);
			
			System.out.println(fullName);
			System.out.println(fileName);
			System.out.println(extName); */
		
		String fullName = "a.p.p.l.e.tar.gz";
		
		String fileName = "";
		String extName = "";
		if(fullName.endsWith(".tar.gz")) {
			fileName = fullName.substring(0, fullName.lastIndexOf(".tar.gz"));
			extName = ".tar.gz";
		} else  {
			fileName = fullName.substring(0, fullName.lastIndexOf("."));
			extName = fullName.substring(0, fullName.lastIndexOf("."));
		}
		
		System.out.println(fileName);
		System.out.println(extName);
		
		}
		
	
	public static void main(String[] args) {
		indexOf();
	}
	
}
