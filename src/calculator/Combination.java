package calculator;

import java.math.BigInteger;

/**
 * This class holds the methods to calculate cominatorics using the provided formulas in 
 * the CSC 250 slides. This class will also include functions for permutations. 
 * 
 * @Author Adam Cichoski, Natalie Hildreth, Bennet Scott, Joseph Holly, Alex Bonaker
 */
public class Combination{
    private int ntotal=1;
    private int rset;
    int diff;

    /**
     * This is the constructor for this class
     * @param ntotal is the variable n from typical combinatorics formulas
     * @param rset is the variable r from typical combinatorics formulas
     */
    public Combination(int ntotal, int rset){
        this.ntotal=ntotal;
        this.rset=rset;
    }
    /**
     * Calculates the combination
     * @return the double value of the combination
     */
    public BigInteger combination(){
        BigInteger nfact = factorial(ntotal); 
        BigInteger rfact = factorial(rset);
        BigInteger diff = factorial(ntotal-rset);
        return nfact.divide(rfact.multiply(diff));
    }
    /**
     * This method calculates the permutation of a given 
     * total and the given items taken at a time
     * @return the permutation
     */
    public BigInteger permutation(){
        BigInteger nfact = factorial(ntotal); 
        BigInteger rfact = factorial(rset);
        return nfact.divide(rfact);
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
