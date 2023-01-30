package practice;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainClass {

	// 문제1. 현재 시간을 이용하여 디렉터리를 생성하시오.
	// 예시)
	// C:\14\31\30
	public static void ex01() {
		
		LocalTime now = LocalTime.now();
		
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		
		String sep = File.separator;
		File dir = new File("C:" + sep + hour + sep + minute + sep + second);
		
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
	}
	
	
	// 문제2. C:\Program Files\Java\jdk-11.0.17 경로의 파일 목록을 아래와 같이 출력하시오.
	/*
		2023-01-04  오후 02:19    <DIR>          bin
		2023-01-04  오후 02:19    <DIR>          conf
		2023-01-04  오후 02:19    <DIR>          include
		2023-01-04  오후 02:19    <DIR>          jmods
		2023-01-04  오후 02:19    <DIR>          legal
		2023-01-04  오후 02:19    <DIR>          lib
		2023-01-04  오후 02:19               160 README.html
		2023-01-04  오후 02:19             1,302 release
		               2개 파일               1,462 바이트
	*/
	public static void ex02() {
		
		File dir = new File("C:" + File.separator + "Program Files" + File.separator + "Java" + File.separator + "jdk-11.0.17");
		
		if(dir.exists()) {
			
			File[] list = dir.listFiles();
			
			int fileCount = 0;
			long totalFileSize = 0;
			for(File file : list) {
				if(file.isHidden()) {
					continue;
				}
				String lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd  a hh:mm").format(file.lastModified());
				String directory = file.isDirectory() ? "<DIR>" : "";
				String size = "";
				if(file.isFile()) {
					long length = file.length();
					size = new DecimalFormat("#,##0").format(length);
					fileCount++;
					totalFileSize += length;
				}
				String name = file.getName();
				String result = String.format("%s%9s%9s %s\n", lastModifiedDate, directory, size, name);
				System.out.print(result);
			}
			System.out.println(fileCount + "개 파일 " + new DecimalFormat("#,##0").format(totalFileSize) + " 바이트");
			
		}
		
	}
	
	
	// 문제3. C:\storage 디렉터리를 삭제하시오.
	// 파일이 저장된 디렉터리는 지워지지 않으므로 먼저 디렉터리에 저장된 파일을 삭제해야 한다.
	public static void ex03() {
		
		File dir = new File("C:" + File.separator + "storage");
		
		File file = new File(dir, "myfile.txt");
		if(file.exists()) {
			file.delete();
		}
		
		if(dir.exists()) {
			dir.delete();
		}
		
	}
	
	
	// 문제 4. 사용자로부터 입력 받은 문자열을 C:\storage\diary.txt 파일로 보내시오.
			// 총 5개 문장을 입력 받아서 보내시오.
	public static void ex04() {
			Scanner sc = new Scanner(System.in);
			
			File dir = new File("C:" + File.separator + "storage");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			
			File file = new File(dir,  "diary.txt");
			
			String[] str = new String[5];
			System.out.println("5문장을 입력하시오. ");
			
			for(int i = 0; i < str.length; i++) {
				str[i] = sc.nextLine();
			}
			
			try(PrintWriter out = new PrintWriter(file)) {
				for(int i = 0; i < str.length; i++) {
					out.println(str[i]);
				}
				
				System.out.println("diary.txt개의 파일이 생성되었다.");
				
			} catch(IOException e) {
				e.printStackTrace();
			}
			sc.close();
			
			}
		
	
	// 문제5. 예외가 발생한 경우 예외 메시지와 예외 발생시간을 저장한 C:\storage\log.txt 파일을 생성하시오.
		// 예시)
		// 2023-01-26 12:08:30 / by zero
		public static void ex05() {
			
			try {
				
				Scanner sc = new Scanner(System.in);
				
				System.out.print("첫 번째 정수를 입력하세요 >>> ");
				int number1 = sc.nextInt();
				
				System.out.print("두 번째 정수를 입력하세요 >>> ");
				int number2 = sc.nextInt();
				
				int add = number1 + number2;
				int sub = number1 - number2;
				int mul = number1 * number2;
				int div = number1 / number2;
				
				System.out.println(number1 + "+" + number2 + "=" + add);
				System.out.println(number1 + "-" + number2 + "=" + sub);
				System.out.println(number1 + "*" + number2 + "=" + mul);
				System.out.println(number1 + "/" + number2 + "=" + div);
		
				sc.close();
			
			} catch(Exception e) {
				
				// 날짜
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String dateTime = dtf.format(now);
				
				// 예외 클래스 이름
				String className = e.getClass().getName();
				
				// 예외 메시지
				String message = e.getMessage();
				
				// 로그 파일 만들기
				File dir = new File("C:" + File.separator + "storage");
				if(dir.exists() == false) {
					dir.mkdirs();
				}
				
				File file = new File(dir, "log.txt");
				
				// 생성 모드(언제나 새로 만든다.)    new FileWriter(file)
				// 추가 모드(기존 내용에 추가한다.)  new FileWriter(file, true)
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
					
					bw.write(dateTime + " " + className + " " + message + "\n");
					// bw.newLine();  \n을 대신할 수 있는 코드
					
					System.out.println("예외 메시지가 log.txt 파일에 기록되었습니다.");
					
				} catch(IOException e2) {
					e2.printStackTrace();
				}
				
			}
			
		}
		
		
	// 문제 6. C:\storage\diary.txt 파일을 C:\storage2\diary.txt 파일로 이동하시오
	// 이동에 소요된 시간을 출력하시오.
		
		/* 내가 푼 것
			File dir = new File("C:" + File.separator + "storage");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			
			File file = new File(dir, "diary.txt");
			int c;
			StringBuilder sb = new StringBuilder();
			
			
			File dir2 = new File("C:" + File.separator + "storage2");
			if(dir2.exists() == false) {
				dir2.mkdirs();
			}
			
			File file2 = new File(dir2, "diary.txt");
			
			try {
				FileReader fr = new FileReader(file);
				
				while((c = fr.read()) != -1) {
					sb.append((char)c);
				}
				String box = sb.toString();
				
				FileWriter fw = new FileWriter(file2);
				fw.write(box);
				
				dir.delete();
				
			} catch(IOException e) {
				e.printStackTrace();
			} */
		
		public static void ex06() {
			// < 정답 > //
			
			// from (폴더 + 파일)값 생성
			File from = new File("C:" + File.separator + "storage", "diary.txt");
			
			// toDir 폴더 값 생성
			File toDir = new File("C:" + File.separator + "storage2");
			
			// to (폴더 + 파일)값 생성
			File to = new File(toDir, from.getName());
			 // ㄴ storage2 폴더, 파일명은 from와 같은 걸로 가져옴
			
			// 보조 스트림 선언
			BufferedReader br = null;
			BufferedWriter bw = null;
			
			//try 문
			try {
				long startTime = System.currentTimeMillis(); // 현재 시간을 롱타입으로 담아줌
				
				// 보조 스트림 생성
				br = new BufferedReader(new FileReader(from));   // 보조스트림을 사용하면 메인은 자동생성'
				// 읽어올 파일 from에 대한 reader 생성
				bw = new BufferedWriter(new FileWriter(to));
				// 적어낼 파일 to에 대한 writer 생성
				
				String line = null;
				while((line = br.readLine()) != null) {
					bw.write(line);
					bw.newLine();  // 한줄 프린트하고 엔터
					}
				
				bw.close();
				br.close();
				
				// 복사에 성공했다면 from 파일은 삭제
				if(from.length() == to.length()) {
					from.deleteOnExit();
				}
				
				long stopTime = System.currentTimeMillis();
				
				System.out.println("이동에 걸린 시간 : " + (stopTime - startTime) + "밀리초");
				
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
	
		// 나 혼자 연습 (diary.txt 읽어오기)
		public static void ex_alone() {
			
		File dir = new File("C:" + File.separator + "storage");
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "diary.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			StringBuilder sb = new StringBuilder();
			String line = null;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println(sb.toString());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		
		// 문제 7. System.in은 키보드로부터 바이트 데이터를 입력 받는 InputStream이다.
		// System.in으로부터 문장 1개를 입력 받아서 출력하시오
		// Scanner 대신 BufferedReader를 사용하시오
		public static void ex07() {
			
			
			BufferedReader br = null;
			
			try {
				br = new BufferedReader(new InputStreamReader(System.in));  // 속도를 향상시켜줌 <- 문자로 바뀌고 <- 키보드로 입력된 게 
				
				System.out.print("문장 입력 >>> ");  // 여기까지 과정을 Scanner가 해줬던 거였음
				String sentence = br.readLine();
				System.out.println("입력된 문장 : " + sentence);
		
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(br != null) {
						br.close();
					}
				} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		
		// 문제 8. 키보드로부터 하나의 문장을 입력 받은 뒤 C:\storage\ex08.txt 파일에 출력하시오.
		// Scanner와 DataOutputStream을 사용하시오.
		public static void ex08() {
			
			Scanner sc = new Scanner(System.in);
			DataOutputStream dos = null;
			
			try {
				dos = new DataOutputStream(new FileOutputStream(new File("C:" + File.separator + "storage", "ex08.bin")));
				
				System.out.print("문장 입력 >>> ");
				String sentence = sc.nextLine();
				
				dos.writeUTF(sentence);
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(dos != null) {
						dos.close();
					}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	
			
		// 문제 9. C:\GDJ61\installer\eclipse-jee-2021-03-R-win32-x86_64.zip 파일을
		// C:\storage\eclipse.zip으로 복사하시오
		public static void ex09() {
			
			File file = new File("C:" + File.separator + "GDJ61" + File.separator + "installer" + File.separator + "eclipse-jee-2021-03-R-win32-x86_64.zip");
			File file2 = new File("C:" + File.separator + "storage" + File.separator + "eclipse-jee-2021-03-R-win32-x86_64.zip");
			BufferedReader br = null;
			BufferedOutputStream bos = null;
			
			try {
				
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				
				String line = null;
				StringBuilder sb = new StringBuilder();
				
				while((line = br.readLine()) != null) {
					sb.append(line + "\n");
				}
				System.out.println("복사 완료되었습니다.");
				
				bos = new BufferedOutputStream(new FileOutputStream(file2));
				bos.write(sb.toString().getBytes());
				
				if(file == file2) {
					file.deleteOnExit();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (bos != null) {
					if (br != null) {
						bos.close(); // 여기에 쓰는 걸 권장
						br.close();
					}
					}
				} catch (IOException e) {
					e.printStackTrace();
					
				}
			}
				
		}
			
	public static void main(String[] args) {
		ex08();
	}

}
