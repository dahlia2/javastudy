package Practice_04;

public class MainClass {

	public static void main(String[] args) {
		BankAccount myAcc = new BankAccount("12345-67656456", 123_840);
		BankAccount yourAcc = new BankAccount("6789094-56456", 240_000);
		
		myAcc.trasfer(yourAcc, 5000);
		
		yourAcc.inquiry();
		
	}

}
