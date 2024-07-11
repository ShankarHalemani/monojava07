package com.techlabs.isp.violation.test;

import com.techlabs.isp.violation.model.Labour;
import com.techlabs.isp.violation.model.Robot;

public class WorkerTest {

	public static void main(String[] args) {
		Labour labour = new Labour();
		labour.startWork();
		labour.stopWork();
		labour.eat();
		labour.drink();

		System.out.println();

		Robot robot = new Robot();
		robot.startWork();
		robot.stopWork();
		robot.eat();
		robot.drink();

	}

}
