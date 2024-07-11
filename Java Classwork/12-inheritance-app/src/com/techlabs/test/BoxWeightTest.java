package com.techlabs.test;

import com.techlabs.model.BoxWeight;

public class BoxWeightTest {

	public static void main(String[] args) {
		BoxWeight boxWeight = new BoxWeight();

		boxWeight.setWidth(10);
		boxWeight.setHeight(20);
		boxWeight.setDepth(30);
		boxWeight.setWeight(40);

		System.out.println("Box width : " + boxWeight.getWidth());
		System.out.println("Box height : " + boxWeight.getHeight());
		System.out.println("Box depth : " + boxWeight.getDepth());
		System.out.println("Box weight : " + boxWeight.getWeight());

	}

}
