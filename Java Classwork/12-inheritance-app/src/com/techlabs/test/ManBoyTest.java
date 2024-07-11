package com.techlabs.test;

import com.techlabs.model.Boy;
import com.techlabs.model.Man;

public class ManBoyTest {

	public static void main(String[] args) {
		Man man = new Man();
		man.eat();
		man.play();
		man.work();

		Boy boy = new Boy();
		boy.eat();
		boy.play();
		boy.sleep();

		Man bigBoy = new Boy();
		bigBoy.eat();
		bigBoy.play();
		bigBoy.work();
//		bigBoy.sleep();

	}

}
