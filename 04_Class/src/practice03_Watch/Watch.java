package practice03_Watch;

public class Watch {
	
	// 필드
	private int hour;  // 0 ~ 23
	private int minute;  // 0 ~ 59
	private int second;  // 0 ~ 59
	
	// 생성자
	public Watch(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	/************************* 내가 쓴 답안
	

	// 메소드
	public int addHour(int hour) {
		this.hour += hour;
		System.out.println(hour + "시간 후(" + hour / 24 + "시간)");
		return this.hour;
		
	}

	public int addMinute(int minute) {
		this.minute += minute;
		System.out.println(minute + "분 후(" + minute / 60 + "시간 " + minute % 60 + "분)");
		return this.minute;
	}
	
	public int addSecond(int second) {
		this.second += second;
		System.out.println(second + "초 후(" + second / 3600 + "시간 " + second % 60 + "분 " + (second % 3600) % 60 + "초)");
		return this.second;
	}
	
	public void see() {
		System.out.println((hour + minute + second) / 60  + "시" + (hour + minute + second) / 3600 + "분");
	}
	
	****************************************/
	
		
	// 정답
	
	public void addHour(int hour) {
		if (hour < 0) {     // 먼저 음수의 값 제거
			return;
		}
		this.hour += hour;
		this.hour %= 24;   // hour를 0 ~ 23으로 만들어 주는 코드
	}
	
	public void addMinute(int minute) {
		if (minute < 0) {
			return;
		}
		this.minute += minute;
		addHour(this.minute / 60);  // 몇 시간이 추가되었는지는 addHour에게 맡기자.  -> minute가 몇 시간인지 계산 후 전송 -> this.hour에 저장
		this.minute %= 60;   // minute을 0~59로 만들어 주는 코드  -> 123분이라면 3분
	}
	
	public void addSecond(int second) {
		if (second < 0 ) {
			return;
		}
		this.second += second;
		addMinute(this.second / 60); // 몇 분이 추가되었는지는 addMinute에 맡기자.
		this.second %= 60;  // second을 0 ~ 59로 만들어 주는 코드
	}
	
	public void see() {
		System.out.println(hour + "시" + minute + "분" + second + "초");
	}
	
}
