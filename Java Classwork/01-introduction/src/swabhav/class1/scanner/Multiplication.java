package swabhav.class1.scanner;
import java.util.*;

public class Multiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter first number");
		int a = sc.nextInt();
		System.out.println("Enter Second number");
		int b= sc.nextInt();
		
		int mulTi = a*b;
		
		System.out.println("Product of two numbers : "+mulTi);
		sc.close();
	}

}
