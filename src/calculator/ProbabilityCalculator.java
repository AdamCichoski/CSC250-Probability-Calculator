package calculator;
/**
 * This program will perform different probability equations
 * 
 * @Author Adam Cichoski, Bennet Scott, Natalie Hildreth, Joseph Holly
 */
public class ProbabilityCalculator {
	public static void main(String[] args) {
		double event1=0.1;
		double event2=0.5;
		double both=0;
		boolean mExclusive = true;
		Probability p = new Probability(event1,event2, mExclusive);
		System.out.printf("%-21s = %5f\n", "P(event1 or event2)",(p.or(event1, event2)));
		System.out.printf("%-21s = %5f\n", "P(event1 and event2)", (p.and(event1, event2)));
		System.out.printf("%-21s = %5f\n", "P(~event1)", (p.not(event1)));
		System.out.printf("%-21s = %5f\n", "P(~event1 or ~event2)", (p.not(event1, event2)));
		System.out.printf("%-21s = %5f\n", "P(event1 | event2)", (p.given(event1, event2)));

		System.out.println("Moving onto combinatorics!!!!!!!!!!!!!!!!!!!!!!!");
	}
}
