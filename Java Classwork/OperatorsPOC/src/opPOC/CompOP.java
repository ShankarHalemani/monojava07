package opPOC;

public class CompOP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		`==` (Equal to): Returns true if the operands are equal, otherwise false.
		`!=` (Not equal to): Returns true if the operands are not equal, otherwise false.
		`>, <` (Greater than, Less than): Returns true if the left operand is greater than or less than the right operand, respectively.
		`>=, <=` (Greater than or equal to, Less than or equal to): Returns true if the left operand is greater than or equal to, or less than or equal to the right operand, respectively.
		 */
		int a = 10;
		int b = 5;
		boolean isEqual = (a==b);
		System.out.println("a is Eqaul to b : "+isEqual);
		boolean isNotEqual = (a!=b);
		System.out.println("a is not Eqaul to b : "+isNotEqual);
		boolean isGreater = (a>b);
		System.out.println("a is Greater than b : "+isGreater);
		boolean isLess = (a<b);
		System.out.println("a is Less than b : "+isLess);
		boolean isGreaterOrEqual = (a>=b);
		System.out.println("a is Greater than or equal to b : "+isGreaterOrEqual);
		boolean isLessOrEqual = (a<=b);
		System.out.println("a is less than or equal to b : "+isLessOrEqual);
	}

}
