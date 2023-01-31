package ex04_OutputStream;


import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class MainClass {
	
	// Writer는 int, char[], String 타입을 가져올 수 있고,
	// OutputStream은 int, byte[] 타입을 가져올 수 있다.
	
	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex01.bin");
		
		FileOutputStream fos = null; // try-catch문 때문에 선언만 함.
		
		try {
			fos = new FileOutputStream(file);
			// file로 출력 통로 fos를 만들었다. 데이터 보내는 값은 int, byte[]만 보낼 수 있다.
			
			// 출력 단위
			// 1. int	 : 1개 출력
			// 2. byte[] : 2개 이상
			
			int c = 'A';  // -> int와 char 타입은 2바이트, byte는 1바이트 => 변환 불가
			String str = "pple";
			byte[] b = str.getBytes();  // 고로 String으로 선언해서 바이트로 변환할 수 있는 메소드를 사용한다.
			
			// 출력
			fos.write(c);
			fos.write(b);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null){
					fos.close();
				}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	public static void ex02() {
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex02.bin");
		
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			
			String str = "안녕하세요";
			
			
			// getBytes(Charset charset)
			byte[] b = str.getBytes(StandardCharsets.UTF_8);
			
			// getBytes(String charsetName)
			// byte[] b = str.getBytes("UTF-8");
			
			fos.write(b);
			
			System.out.println("ex02.bin 파일의 크기는 " + file.length() + "바이트");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ex03() {
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex03.bin");

		// FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			/* fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos); */

			bos = new BufferedOutputStream(new FileOutputStream(file));
			// bos만 사용

			bos.write("반갑습니다\n또 만나요".getBytes("UTF-8"));
			// 반갑습니다는 String 파일이니까 getBytes을 사용하여 UTF-8 (버전)을 통해 byte를 사용했었음 -> 직접 치니까 오타가
			// 났음.
			// 그래서 자바가 StandardCharSets 클래스를 만들었고, str.getBytes(StandardCharsets.UTF_8) 이런 식으로 사용할 수 있게됨.
			

			// bos.close(); <- 이 자리에도 올 수 있음 =-> finally가 사라짐
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close(); // 여기에 쓰는 걸 권장
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ex03.bin 파일의 크기는 => " + file.length() + "바이트");
	}
	
	public static void ex04() {
		
		// 변수를 그대로 출력하는 DataOutputStream
		// 실제로는 String값을 주고 받긴 함.
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex04.dat");  // 확장자를 dat로 해도 상관 없음
		
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(file));
			
			// 출력할 변수
			String name = "에밀리";   	// 9바이트
			int age = 30;				// 4바이트
			double height = 180.5;		// 8바이트
			boolean isAlive = true;		// 
			
			// 출력(변수 타입에 따라서 메소드가 다름)
			dos.writeUTF(name);
			dos.writeInt(age);
			dos.writeDouble(height);
			dos.writeBoolean(isAlive);
			
			// dos.close(); 가능하지만 finally 연습을 위해 생략
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) {
					dos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ex04.bin 파일의 크기는 => " + file.length() + "바이트");

	}
	
	public static void ex05() {
		
		// 객체를 그대로 출력하는 ObjectOutputstream
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex05.dat");
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			// 출력할 객체
			List<Person> people = Arrays.asList(
					new Person("에밀리", 30, 180.5, true),
					new Person("제시카", 35, 190.5, true)
					);
			
			// 출력할 객체
			Person person = new Person();
			person.setName("제임스");
			person.setAge(40);
			person.setHeight(170.5);
			person.setAlive(false);
			
			// 출력
			oos.writeObject(people);
			oos.writeObject(person);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
			if(oos != null) {
				oos.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
	
	
	public static void main(String[] args) {
		ex01();
	}

}
