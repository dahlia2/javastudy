package Practice_04;

public class BankAccount {
	 
	// 필드 (프라이빗 처리)
	private String accNo;  // 통장번호
	private long balance;  // 내 통장 잔액
	
	
	// 생성자 (메소드니까 퍼블릭 처리)
	public BankAccount(String accNo, long balance) {
		this.accNo = accNo;
		this.balance = balance;
	}
	
	// 메소드 생성(입금, 출금, 이체, 조회)
	
	// 입금 (마이너스 처리 x)
	public void desopit(long money) {
		if(money <= 0) {
			return;
		}
		balance += money;    // 반환하는 게 없고 값만 저장하니까 void 타입
	}
	
	// 출금 (마이너스 출금 + 잔액보다 큰 금액이면 처리 x)
	public long withdrawal(long money) {
		if(money <= 0 || money > balance) {
			return 0;    // void 타입이 아니라면 꼭 반환값을 붙여줘야 함
		} balance -= money;
		return money;      // if의 false 경우에도 반환값 넣기
	}
	
	// 이체 (내 통장에서 상대 통장으로)
	public void trasfer(BankAccount other, long money) {
		other.desopit(withdrawal(money));
		// 상대방에게 . 입금 금액은 (내 통장에서 인출)
	}
		
	// 조회
	public void inquiry() {
		System.out.println("계좌번호 : " + accNo);
		System.out.println("잔액 : " + balance);
		
	}

}
