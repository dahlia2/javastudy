package dto2;


// 스캐너로 입력받은 값들을 전달해주는 역할

public class ContactDTO2 {

	private int contact_no;
	private String name;
	private String tel;
	private String email;
	private String address;
	
	public ContactDTO2 () {}

	public ContactDTO2(int contact_no, String name, String tel, String email, String address) {
		super();
		this.contact_no = contact_no;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.address = address;
	}

	public int getContact_no() {
		return contact_no;
	}

	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "조회된 연락처 : [contact_no=" + contact_no + ", name=" + name + ", tel=" + tel + ", email=" + email
				+ ", address=" + address + "]";
	}

	
}
