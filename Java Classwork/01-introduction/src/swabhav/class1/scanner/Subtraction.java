package swabhav.class1.scanner;
import java.util.*;
public class Subtraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter first number");
		int a  = sc.nextInt();
		System.out.println("Enter second number");
		int b = sc.nextInt();
		
		int sub= a-b;
		
		System.out.println("Subtraction : "+sub);
		sc.close();
		
	}

}
