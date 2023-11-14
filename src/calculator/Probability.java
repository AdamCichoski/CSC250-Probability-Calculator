package calculator;
/**
 * This class will hold the methods to determine create a probability question
 * for two possible events and to determine the probability of something happening
 * 
 * @Author Adam Cichoski, Bennet Scott, Natalie Hildreth, Joseph Holly
 */
public class Probability {
	private double event1=0;
	private double event2=0;
	private double event1and2=0;
	private char or ='+', and ='*';
	
	public Probability(double event1, double event2) {
		this.event1 = event1;
		this.event2 = event2;
	}
	public Probability(double event1, double event2, double event1and2) {
		this.event1 = event1;
		this.event2 = event2;
		this.event1and2 = event1and2;
	}
	/**
	 * This method calculates a non-mutually exclusive or probability
	 * @param event1
	 * @param event2
	 * @return P(event1 or event2)
	 */
	public double or(double event1, double event2) {
		return event1+event2 - event1and2;
	}
	
	/**
	 * This method calculates an and probability
	 * @param event1
	 * @param event2
	 * @return P(event1 and event2)
	 */
	public double and(double event1, double event2) {
		return event1*event2;
	}
	/**
	 * This method calculates probability of one event happening and another not happening
	 * @param event
	 * @param event1
	 * @return P(event and ~event2)
	 */
	public double andNot(double event, double event2) {
		return event*(1-event2);
	}
	/**
	 * This method calculates the chances that an event doesn't happen
	 * @param event
	 * @return 1-event +event1and2
	 */
	public double not(double event) {
		return 1-event+event1and2;
	}
	/**
	 * This method checks a not on two events; P(~event1 or ~event2)
	 * @return
	 */
	public double nor(double event1, double event2) {
		return 1-(event1+event2+event1and2);
	}
	/**
	 * This method calculates the probability of an event given another event
	 * @param event1
	 * @param event2
	 * @return
	 */
	public double given(double event1, double event2) {
		return and(event1, event2) / event2;
	}
	/**
	 * Sets event1
	 * @param event1
	 */
	public void setEvent1(double event1) {
		this.event1=event1;
	}
	/**
	 * Sets event2
	 * @param event2
	 */
	public void setEvent2(double event2) {
		this.event1and2=event2;
	}
	/**
	 * Sets the likelyhood of both happening
	 * @param event1and2 new chances of both events happening
	 */
	public void setEvent1and2(double event1and2){
		if(event1and2<0){
			throw new IllegalArgumentException("Invalid input for event!");
		}
		this.event1and2 = event1and2;
	}
	/**
	 * Gets event1and2
	 * @return event1and2
	 */
	public double getEvent1and2(){
		return this.event1and2;
	}
}
