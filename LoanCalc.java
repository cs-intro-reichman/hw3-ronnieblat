// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	private static double endBalance(double loan, double rate, int n, double payment) {	
		int counter = 0;
		double r = 1.0+rate;
		while (counter <n){
			loan = loan*r-payment;
			counter++;

		}
		if (loan<=0)
		return 0;
		else
		return loan;
	}
	
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double g=loan/n;
		iterationCounter=0;
		while (endBalance(loan, rate, n, g)>0 && g<=loan){
			g+=epsilon;
			iterationCounter++;

		}
		return g;
    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) { 
		iterationCounter=0;
        double l=loan/n;
		double h=loan;
		double g=(l+h)/2.0;
		while (h-l>epsilon){
			if(endBalance(loan, rate, n, g)>0)
				l=g;
			else
				h=g;
			g=(l+h)/2.0;
			iterationCounter++;
			
		}
		return g;
    }
}