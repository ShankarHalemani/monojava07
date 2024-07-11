package com.techlabs.test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		Map<Integer, String> treemap = new TreeMap<Integer, String>();
		treemap.put(1, "Abc");
		treemap.put(2, "pqr");
		treemap.put(3, "xyz");
		treemap.put(6, "kbc");
		treemap.put(5, "hwr");
//		treemap.put(null, null);
//		treemap.put(null, null);
//		treemap.put(null, null); // wont allow null values throws exception

		Set<Map.Entry<Integer, String>> entries = treemap.entrySet();

		for (Map.Entry<Integer, String> entry : entries) {
			System.out.println(entry.getKey() + " ---> " + entry.getValue());
		}

		System.out.println(treemap);
		System.out.println(treemap.size());
	}

}
