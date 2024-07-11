package opPOC;

public class AssignmentOP {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// "=" (Assignment): Assigns the value of the right operand to the left operand.
		// "+=", "-=", "*=", "/=", "%=": Perform the corresponding arithmetic operation and assign the result to the left operand.
		int x = 10;
		x+=2;
		System.out.println("Equalent to x = x+2 : "+ x);
		x-=3;
		System.out.println("Equalent to x = x-3 : "+ x);
		x*=4;
		System.out.println("Equalent to x = x*4 : "+ x);
		x/=6;
		System.out.println("Equalent to x = x/6 : "+ x);
		x%=5;
		System.out.println("Equalent to x = x%5 : "+ x);
	}
}
