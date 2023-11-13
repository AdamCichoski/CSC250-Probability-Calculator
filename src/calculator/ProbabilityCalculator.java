package calculator;
/**
 * This program will perform different probability equations
 * 
 * @Author Adam Cichoski, Bennet Scott, Natalie Hildreth, Joseph Holly
 */
public class ProbabilityCalculator {
	public static void main(String[] args) {
		// doesn't work in VS Code debugger for some reason, only in netbeans
		Program program = new Program();
		program.start();
		
		// uncomment if debugging in VS Code and comment code above instead
		/*
		double event1=0.1;
		double event2=0.5;
		Probability p = new Probability(event1,event2);
		System.out.printf("%-21s = %5f\n", "P(event1 or event2)",(p.or(event1, event2)));
		System.out.printf("%-21s = %5f\n", "P(event1 and event2)", (p.and(event1, event2)));
		System.out.printf("%-21s = %5f\n", "P(~event1)", (p.not(event1)));
		System.out.printf("%-21s = %5f\n", "P(~event1 or ~event2)", (p.nor(event1, event2)));
		System.out.printf("%-21s = %5f\n", "P(event1 | event2)", (p.given(event1, event2)));
	
		System.out.println("");

		System.out.println("P(event1 or event2) = " + String.format("%.1f", p.or(event1, event2) * 100) + '%');
		System.out.println("P(event1 and event2) = " + String.format("%.1f", p.and(event1, event2) * 100) + '%');
		System.out.println("P(~event1) = " + String.format("%.1f", p.not(event1) * 100) + '%');
		System.out.println("P(~event1 or ~event2) = " + String.format("%.1f", p.nor(event1, event2) * 100) + '%');
		System.out.println("P(event1 | event2) = " + String.format("%.1f", p.given(event1, event2) * 100) + '%');*/
	}
}
