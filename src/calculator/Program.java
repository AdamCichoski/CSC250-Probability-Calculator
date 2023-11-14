package calculator;
import java.util.Scanner;
/**
 * This class starts the terminal program so the user can interface with it.
 * 
 * @Author Adam Cichoski, Bennet Scott, Natalie Hildreth, Joseph Holly
 */
public class Program {
    public static void start() {
        boolean exclusive = false;
        Scanner input = new Scanner(System.in);

        System.out.println("██████  ██████   ██████  ██████   █████  ██████  ██ ██      ██ ████████ ██    ██");
		System.out.println("██   ██ ██   ██ ██    ██ ██   ██ ██   ██ ██   ██ ██ ██      ██    ██     ██  ██ ");
		System.out.println("██████  ██████  ██    ██ ██████  ███████ ██████  ██ ██      ██    ██      ████  ");
		System.out.println("██      ██   ██ ██    ██ ██   ██ ██   ██ ██   ██ ██ ██      ██    ██       ██   ");
		System.out.println("██      ██   ██  ██████  ██████  ██   ██ ██████  ██ ███████ ██    ██       ██   ");
		System.out.println("\n\n");
		System.out.println(" ██████  █████  ██       ██████ ██    ██ ██       █████  ████████  ██████  ██████");
		System.out.println("██      ██   ██ ██      ██      ██    ██ ██      ██   ██    ██    ██    ██ ██   ██");
		System.out.println("██      ███████ ██      ██      ██    ██ ██      ███████    ██    ██    ██ ██████ ");
		System.out.println("██      ██   ██ ██      ██      ██    ██ ██      ██   ██    ██    ██    ██ ██   ██");
		System.out.println(" ██████ ██   ██ ███████  ██████  ██████  ███████ ██   ██    ██     ██████  ██   ██");
		System.out.println("\n");
        
        System.out.println("Enter a probability equation (enter '?' for formatting):");
        while (!input.hasNext("exit")) {
            String probability = input.nextLine();
            // split each word in string so they are seperate elements in a string
            String[] words = probability.split(" ");
            double[] events = new double[words.length - 1];
            double event1 = 0;
            double event2 = 0;
            String keyword;
        
            // check length and each element of array for any invalid inputs
            if (words.length == 1 && words[0].equals("exit")) {
                keyword = "exit";
            } else if (words.length == 1 && words[0].equals("?")) {
                keyword = "?";
                System.out.println("\nWelcome to the Probability Calculator! This program is designed for calculating the results of probability questions. Below are the difference keywords you can use to interface with this program. Make sure to end all values with a '%' symbol.\n");
                
                System.out.println("Keywords:\nProbability:");
                System.out.println("and: [A] and [B]");
                System.out.println("or: [A] or [B]");
                System.out.println("not: not [A]");
                System.out.println("nor: [A] nor [B]");
                System.out.println("notAnd: [A] notAnd [B]");
                System.out.println("given: [A] given [B]");
                System.out.println("setx: sets and/or disables function to mutually exclusive");
                System.out.println("?: lists all keywords.");
                System.out.println("exit: exits the program.\n");
            }else if(words.length == 1 && words[0].equals("setx")){
                keyword = "setx";
                exclusive = (exclusive)? false : true;
                String is = (exclusive)? "is exclusive": "is not exclusive";
                System.out.printf("-->Function %s \n", is);
            } 
            else if (words.length == 2 && words[0].matches("[a-zA-Z]+") && words[1].endsWith("%")) {
                keyword = words[0];
                // convert strings of events into doubles
                words[1] = words[1].substring(0, words[1].length() - 1);
                event1 = Double.parseDouble(words[1]) / 100;
            } else if (words.length == 3 && (words[0].endsWith("%")&& words[1].matches("[a-zA-Z]+") && words[2].endsWith("%"))) {
                keyword = words[1];
                // convert strings of events into doubles
                words[0] = words[0].substring(0, words[0].length() - 1);
                event1 = Double.parseDouble(words[0]) / 100;
                words[2] = words[2].substring(0, words[2].length() - 1);
                event2 = Double.parseDouble(words[2]) / 100;
            } else {
                keyword = "";
                System.out.println("Error: Invalid input!!\n");
            }
            
            if (event1 < 0 || event2 < 0) {
                System.out.println("Error: Invalid input!!\n");
            } else {
                Probability p = new Probability(event1 ,event2);
                // prints a specific result based off the keyword used
                switch(keyword) {
                    case "or":
                        if (event1 == 0.0 || event2 == 0.0) { 
                            System.out.println("Error: Keyword requires two events!!\n"); 
                        } else {
                            System.out.println("P(A or B): " + String.format("%.1f", p.or(event1, event2) * 100) + "%\n");
                        }
                        break;
                    case "and":
                        boolean x = exclusive;
                        if(exclusive){
                            System.out.println("P(A and B): 0%");
                        }
                        else if (event1 == 0.0 || event2 == 0.0) { 
                            System.out.println("Error: Keyword requires two events!!\n"); 
                        } else {
                            System.out.println("P(A and B): " + String.format("%.1f", p.and(event1, event2) * 100) + "%\n");
                        }
                        break;
                    case "not":
                        System.out.println("P(~A): " + String.format("%.1f", p.not(event1) * 100) + "%\n");
                        break;
                    case "nor":
                        if (event1 == 0.0 || event2 == 0.0) { 
                            System.out.println("Error: Keyword requires two events!!\n"); 
                        } else {
                            System.out.println("P(~A or ~B): " + String.format("%.1f", p.nor(event1, event2) * 100) + "%\n");
                        }
                        break;
                    case "andNot":
                        if (event1 == 0.0 || event2 == 0.0) { 
                            System.out.println("Error: Keyword requires two events!!\n"); 
                        } else {
                            System.out.println("P(~A and ~B): " + String.format("%.1f", p.andNot(event1, event2) * 100) + "%\n");
                        }
                        break;
                    case "given":
                        if (event1 == 0.0 || event2 == 0.0) { 
                            System.out.println("Error: Keyword requires two events!!\n"); 
                        } else {
                            System.out.println("P(A | B): " + String.format("%.1f", p.given(event1, event2) * 100) + "%\n");
                        }
                        break;
                }
            }
            System.out.println("Enter a probability equation (enter '?' for formatting):");
        }
        
        // close on keyword "exit"
        input.close();
    }
}