package com.techlabs.test;

import java.util.Set;
import java.util.TreeSet;

public class TreesetTest {

	public static void main(String[] args) {
		Set<String> set = new TreeSet<String>();
		set.add("Abc");
		set.add("Xyz");
		set.add("mnop");
		set.add("aaaa");

		System.out.println(set);

		set.add(null);
		System.out.println(set.size());

		String str = null;
		set.add(str);
		System.out.println(set);
		System.out.println(set.size());

	}

}
