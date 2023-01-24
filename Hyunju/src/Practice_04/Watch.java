package Practice_04;

public class Watch {
	
	private int hour;  // 0 ~ 23
	private int minute;  // 0 ~ 59
	private int second;  // 0 ~ 59
	
	public Watch(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	// 메소드 (시간 더하기)
	public void addHour(int hour) {
		if(hour <= 0) {
			return;
		}
		this.hour += hour;
		this.hour %= 24;  // 24보다 작으면 본인 숫자가 답으로 나옴
	}
	
	public void addMinute(int minute) {
		if(minute <= 0) {
			return;
		}
		this.minute += minute;
		addHour(this.minute / 60); // 60당 1시간이니까 나눈 값으로 시간 추가해줌
		this.minute %= 60; // minute을 항상 0~59의 범위로 만들어 주는 코드
	}
	
	public void addSecond(int second) {
		if(second <= 0) {
			return;
		} this.second += second;
		addMinute(this.second / 60);
		this.second %= 60;
	}
	
	public void see() {
		System.out.println(hour + "시 " + minute + "분 " + second + "초");
	}
	
}

