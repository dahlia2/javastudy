package ex03_Reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass {

	/* 
		Reader
		1. 문자 기반의 입력 스트림이다.
		2. Reader로 끝나는 이름의 클래스는 모두 문자 기반의 입력 스트림이다. ex) timeReader, BufferedReader
		3. 문자를(데이터를) 읽어들이는 스트림이다. (파일의 내용을 읽는다. 서버로 보낸 내용을 읽는다. 등등)
	*/
	
	public static void ex01() {  // 실전에서 사용 X

		File dir = new File("C:" + File.separator + "storage");
		if (dir.exists() == false) {
			dir.mkdirs();
		}

		File file = new File(dir, "ex01.txt");

		FileReader fr = null;
		
		try {

			fr = new FileReader(file);
			int c; // 1글자를 저장할 변수

			while ((c = fr.read()) != -1) {
				System.out.print((char) c);
				// 한 글자만 읽어오라는 뜻. ((char)c) => int 단위로 받아왔기 때문에 char 타입으로 변환
				// 답이 -1 나왔다면 읽을 값이 없다는 것
			}

		} catch (IOException e) { // FileNotFoundExcepton이 (자식 클래스이기 때문에) 함께 포함됨
			e.printStackTrace();

		} finally {
			try {
				if (fr != null) {
					fr.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ex02() {
		
		File dir = new File("C:" + File.separator + "storage");
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex02.txt");

		FileReader fr = null;
		
		try {

			fr = new FileReader(file);
			int c; // 1글자를 저장할 변수
			StringBuilder sb = new StringBuilder();
			while ((c = fr.read()) != -1) {
				sb.append((char) c);
			}
			System.out.println(sb.toString());
			
		} catch (IOException e) { // FileNotFoundExcepton이 (자식 클래스이기 때문에) 함께 포함됨
			e.printStackTrace();

		} finally {
			try {
				if (fr != null) {
					fr.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ex02_2() {
		
		File dir = new File("C:" + File.separator + "storage");
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex02.txt");

		FileReader fr = null;

		try {

			fr = new FileReader(file);

			char[] cbuf = new char[5]; // 5글자를 읽어 들이는 배열
			int readCount = 0; // 실제로 읽은 글자의 개수
			StringBuilder sb = new StringBuilder();

			while ((readCount = fr.read(cbuf)) != -1) {

				sb.append(cbuf, 0, readCount); // 인덱스 0부터 readCount개 글자를 추가하시오.

				// ex02.txt 읽는 과정
				//	[루프]	 [readCount]	 [cbuf]
				//	1		 5				 a b c d e
				//	2		 2				 f g c d e	=> a,b는 덮여쓰기 하고 나머지 값은 그대로 남아있음.
				//	3		-1

				/* for(int i = 0; i < readCount; i++) {    // 배열을 덮어쓰기 때문에 length가 아닌   count를 사용한다.
					System.out.println(cbuf[i]); */

			}  // while
			System.out.println(sb.toString());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( fr != null ) {
					fr.close();  // 리더는 새롭게 만드는 것이 아니라서, writer와 다르게 생략해도 상관 X
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ex03() {
		
		/*
		  BufferedReader의 장점
		  1. 속도가 빠르다
		  2. readLine 메소드를 사용할 수 있다.
		*/
		
		File dir = new File("C:" + File.separator + "storage");
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex03.txt");
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			System.out.println(sb.toString());
			
			/* char[] cbuf = new char[5];
			int readCount = 0;
			StringBuilder sb = new StringBuilder();
			
			while((readCount = br.read(cbuf)) !=  -1) {
				sb.append(readCount);
			}
			
			System.out.println(sb.toString()); */
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		ex02();
	}
	
}

