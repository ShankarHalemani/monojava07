package com.techlabs.whileloop;

public class TablesOf1_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1;
		
		while(i<=10) {
			int j=1;
			while(j<=10) {
				System.out.print(i*j + "\t");
				j++;
			}
			i++;
			System.out.println();
		}
	}

}
