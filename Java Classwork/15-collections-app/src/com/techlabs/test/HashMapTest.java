package com.techlabs.test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		Map<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(1, "Abc");
		hashmap.put(2, "pqr");
		hashmap.put(3, "xyz");
		hashmap.put(6, "kbc");
		hashmap.put(5, "hwr");
		hashmap.put(null, null);
		hashmap.put(null, null);
		hashmap.put(null, null);
		// HashMap allows only single null set

		System.out.println(hashmap);
		System.out.println(hashmap.size());

	}

}
