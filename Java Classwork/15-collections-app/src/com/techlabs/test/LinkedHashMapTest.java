package com.techlabs.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		Map<Integer, String> hashmap = new LinkedHashMap<Integer, String>();
		hashmap.put(1, "Abc");
		hashmap.put(2, "pqr");
		hashmap.put(3, "xyz");
		hashmap.put(6, "kbc");
		hashmap.put(5, "hwr");

		System.out.println(hashmap);

	}

}
