package dto;

public class ContactDTO {
	
	private int car_no;
	private String num;
	private String model;
	
	public ContactDTO() {}

	public ContactDTO(int car_no, String num, String model) {
		super();
		this.car_no = car_no;
		this.num = num;
		this.model = model;
	}

	public int getCar_no() {
		return car_no;
	}

	public void setCar_no(int car_no) {
		this.car_no = car_no;
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

	@Override
	public String toString() {
		return "ContactDTO [car_no=" + car_no + ", num=" + num + ", model=" + model + "]";
	}
	
}
