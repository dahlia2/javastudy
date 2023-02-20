package dto;

public class ContactDTO {
	
	private int car_no;
	private String model;
	private int num;
	
	public ContactDTO() {}

	public ContactDTO(int car_no, String model, int num) {
		super();
		this.car_no = car_no;
		this.model = model;
		this.num = num;
	}

	public int getCar_no() {
		return car_no;
	}

	public void setCar_no(int car_no) {
		this.car_no = car_no;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "ContactDTO [car_no=" + car_no + ", model=" + model + ", num=" + num + "]";
	}
	
}
