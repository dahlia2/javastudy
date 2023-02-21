package main;

import controller.ContactController;
import dto.ContactDTO;

public class MainClass {
	
	public static void main(String[] args) {
		new ContactController().play();   // 객체 생성없이 따로 만들 수 있는 이유.. 까먹음
		new ContactDTO().getNum();
	}

}
