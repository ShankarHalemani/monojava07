package swabhav.class1.scanner;
import java.util.*;
public class Swapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number");
		int a = sc.nextInt();
		System.out.println("Enter second number");
		int b = sc.nextInt();
		
		System.out.println("Numbers before swapping : "+a+" "+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("Numbers After swapping : "+a+" "+b);
		sc.close();
		
	}

}
