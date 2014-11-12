package edu.yale.cpsc112_assignment3;

import java.util.Random;

public class CPSC112_Assignment3 {

  public static String mySecret = "";
  public static boolean DEBUG = true;
  public static Random r = new Random();

  public static void main(String[] args) {
    makeMySecret();
    isGameOver("1234");
    isGameOver("4321");
    isGameOver("2567");
    isGameOver("1432");
    }
  public static void makeMySecret() {
     // Part 1 code goes here (please leave the next few lines at the end of the makeMySecret method)
	    int a = r.nextInt(7)+1;
		int b = r.nextInt(7)+1;
		if (b == a){
			while (b == a)
			{
				b= r.nextInt(7)+1;
			}
		}
		int c = r.nextInt(7)+1;
		if (c==a || c==b){
			while (c==a || c==b)
			{
				c = r.nextInt(7)+1;
			}
		}
		int d = r.nextInt(7)+1;
		if (d==a || d==b || d==c){
			while (d==a || d==b || d==c){
				d = r.nextInt(7)+1;			
			}	
		} 
  	mySecret =  a+""+b+""+c+""+d;
  	if (DEBUG)
	    {
  		System.out.println(mySecret);
	    }
	  
  }

  public static boolean isGuessValid(String input) {
    // Part 2 code goes here
	
  }

  public static boolean isGameOver(String input) {
    // Parts 3 and 4 code goes here
  }
}
