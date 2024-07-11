package com.techlabs.isp.solution.test;

import com.techlabs.isp.solution.model.IWorkable;
import com.techlabs.isp.solution.model.IWorker;
import com.techlabs.isp.solution.model.Labour;
import com.techlabs.isp.solution.model.Robot;

public class WorkTest {

	public static void main(String[] args) {
		IWorkable robot = new Robot();
		robot.start();
		robot.stop();

		System.out.println();

		IWorker labour = new Labour();
		labour.start();
		labour.stop();
		labour.eat();
		labour.rest();
	}

}
