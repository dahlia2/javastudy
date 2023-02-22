package service;

public class Car {
	
	private String num;
	private String model;
	
	public Car(String num, String model) {
		super();
		this.num = num;
		this.model = model;
	}

	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getModel() {
		return model;
	}
		
	public void setModel(String model) {
		this.model = model;
	}

}
