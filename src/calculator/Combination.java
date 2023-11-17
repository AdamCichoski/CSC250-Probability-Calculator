package calculator;

import java.math.BigInteger;

/**
 * This class holds the methods to calculate cominatorics using the provided formulas in 
 * the CSC 250 slides
 * 
 * @Author Adam Cichoski, Natalie Hildreth, Bennet Scott, Joseph Holly, Alex Bonaker
 */
public class Combination{
    private int ntotal=1;
    private int rset;
    int diff;

    /**
     * This is the constructor for this class
     * @param ntotal
     * @param rset
     */
    public Combination(int ntotal, int rset){
        this.ntotal=ntotal;
        this.rset=rset;
    }
    /**
     * Calculates the combination
     * @return the double value of the combination
     */
    public BigInteger calculate(){
        BigInteger nfact = factorial(ntotal); 
        BigInteger rfact = factorial(rset);
        BigInteger diff = factorial(ntotal-rset);
        return nfact.divide(rfact.multiply(diff));
    }
    /**
     * Calculates a factorial
     * @param n inputted value
     * @return n! (must be a big integer)
     */
    private BigInteger factorial(long n) {
        long x = n;
        BigInteger fact = BigInteger.ONE;
        if ((n == 0) || (n == 1)) {
            return fact;
        } else {
            fact = BigInteger.valueOf(n);
            while (n > 1) {
                fact = fact.multiply(BigInteger.valueOf(n - 1));
                n--;
            }
        }
        return fact;
    }
}
