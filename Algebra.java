// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum=x1;
		if (x2>0){
			while (x2>0){
				sum++;
				x2--;
			}
		}
		else{
			while (x2<0) {
				sum--;
				x2++;
			}
		}
		return sum;
		
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x1 == x2)
		return 0;
		int difference=x1;
		if (x2>0){
			while (x2>0){
				difference--;
				x2--;
			}
		}
		if (x2<0){
			while (x2<0) {
				difference++;
				x2++;				
			}
		}
		return difference;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 == 0 || x2 == 0)
		return 0;
			int counter = 0;
			int multiplication=0;
			boolean flag = false;
			if (x1<0){
				flag = !flag;
				x1 = minus(0, x1);
			}
			if (x2<0){
				flag = !flag;
				x2 = minus(0, x2);
			}
			while (counter<x2){
				counter++;
				multiplication = plus(multiplication, x1);
		}
		if (flag == true)
		multiplication= minus(0, multiplication);
		return multiplication;
		}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (x == 0)
		return 0;
		if (n == 0)
		return 1;
		else {
			int counter = 1;
			int power = x;
			while (counter < n){
				power = times(power, x);
				counter ++;
			}
			return power;
		}
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x2==0)
		return 0;
		boolean positive=true;
		int counter=0;
		if (x1<0){
			x1=minus(0, x1);
			positive=!positive;
		}
		if (x2<0){
			x2=minus(0, x2);
			positive=!positive;
		}
		while (x1>=x2) {
			x1=minus(x1, x2);
			counter++;
			
		}
		if (!positive)
		counter=minus(0, counter);
		return counter;
	}


	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x1==0)
		return 0;
		int n=div(x1, x2);
		if (times(x2, n) == x1)
		return 0;
		else 
		return minus(x1, times(x2, n));
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x ==0)
		return 0;
		int g = 1;
		while (times(g, g) < x){
			g++;
		}
		if (times(g,g) > x)
		return g-1;
		else
		return g;
	}	  	  
}