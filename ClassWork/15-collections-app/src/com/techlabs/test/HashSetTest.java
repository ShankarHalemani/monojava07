package com.techlabs.test;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("Abc");
		set.add("Xyz");
		set.add("mnop");

		System.out.println(set);

		set.add(null);
		System.out.println(set.size());

	}

}
