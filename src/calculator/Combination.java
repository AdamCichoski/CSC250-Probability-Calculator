package calculator;
/**
 * This class holds the methods to calculate cominatorics using the provided formulas in 
 * the CSC 250 slides
 * 
 * @Author Adam Cichoski, Natalie Hildreth, Bennet Scott, Joseph Holly, Alex Bonaker
 */
public class Combination {
    private int ntotal;
    private int rset;

    /**
     * This is the constructor for this class
     * @param ntotal
     * @param rset
     */
    Combination(int ntotal, int rset){
        this.ntotal=ntotal;
        this.rset=rset;
    }
    /**
     * Calculates the combination
     * @return the double value of the combination
     */
    public double calculate(){
        return (factorial(this.ntotal))/((double)((factorial(this.rset))*(factorial(this.ntotal-this.rset))));
    }

    private int factorial(int x){
        int total=1;
        if(x<0){
            return -1;
        }
        for(int i=x;i>0;i--){
            total*=i;
        }
        return total;
    }
}
