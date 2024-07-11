package com.techlabs.test;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>();
		set.add("Abc");
		set.add("Xyz");
		set.add("mnop");

		System.out.println(set);

	}

}
