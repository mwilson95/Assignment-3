package edu.yale.cpsc112_assignment3;

import java.util.Random;

public class CPSC112_Assignment3 {

  public static String mySecret = "";
  public static boolean DEBUG = true;
  public static Random r = new Random();
  public static int exceptions =3;
  public static int highestGuess=0;
  public static int liePossible=1;


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
  		System.out.println("Secret: "+mySecret);
	    }
  }

  public static boolean isGuessValid(String input) {
    // Part 2 code goes here
	  try
	  {
		  //this checks the length
		  int l = input.length();
		  if (l != 4){
			  System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
			  return false; 	
		  }
		  //tests if each number is between 1 and 7
		  for (int i = 0; i <4; i++){
			  int j;
			  j= Integer.parseInt(input.substring(i, i+1));
			  if (j<1 || j>7){
				  System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
				  return false;
			  }
		  }
		  int signal=1;
		  //this tests if each number is equal to any of the others
		  int w = Integer.parseInt(input.substring(0,1));
		  int x = Integer.parseInt(input.substring(1,2));
		  if (x==w){
			  signal=0;
		  }
		  int y = Integer.parseInt(input.substring(2,3));
		  if (y==w || y==x){
			  signal=0;
		  }
		  int z = Integer.parseInt(input.substring(3,4));
		  if (z==w || z==x || z==y){
			  signal=0;
		  } 
		  if (signal==0){
			  System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
			  return false;
		  }
		  return true;
	  }
	  catch (Exception e)
	  {
		  System.out.println("Input must be a 4-digit number with digits between 1 and 7."); 
		  return false;
	  }
  }
	public static boolean isGameOver(String input) {
		//3.1
		boolean guessCheck = isGuessValid(input);
		if (guessCheck == false){
			return false;
		}
		//4.1
		int currentGuess = Integer.parseInt(input);
		if (currentGuess > highestGuess){
			 highestGuess = currentGuess;
		 }
		if(currentGuess < highestGuess && exceptions >= 0 && Integer.parseInt(input) != Integer.parseInt(mySecret)){
			if (exceptions > 0){
				exceptions--;
			}
			System.out.println("Your guess was lower than allowed. You have " + exceptions + " exceptions remaining.");
			
		}
		if (currentGuess > Integer.parseInt(mySecret) && exceptions==0){
			System.out.println("You're out of exceptions and you've guessed too high! The secret was " + mySecret +".");
			return true;
		}
		//3.2
		//Does this go here or down there? can you lie but also turn this out?
		if(Integer.parseInt(input)==Integer.parseInt(mySecret)){
			System.out.println("You won!");
			return true;
		}		
		int a = Integer.parseInt(mySecret.substring(0,1));
		int b = Integer.parseInt(mySecret.substring(1,2));
		int c = Integer.parseInt(mySecret.substring(2,3));
		int d = Integer.parseInt(mySecret.substring(3,4));
		int w = Integer.parseInt(input.substring(0,1));
		int x = Integer.parseInt(input.substring(1,2));
		int y = Integer.parseInt(input.substring(2,3));
		int z = Integer.parseInt(input.substring(3,4));
		//this part finds the second number
		int num1= 0;
		if(a==w || a==x || a==y || a==z){
			num1=num1 + 1;
		}
		if(b==w || b==x || b==y || b==z){
			num1=num1 + 1;
		}
		if(c==w || c==x || c==y || c==z){
			num1=num1 + 1;
		}
		if(d==w || d==x || d==y || d==z){
			num1=num1 + 1;
		}
		int num2= 0;
		if (a==w){
			num2=num2 + 1;
		}
		if (b==x){
			num2=num2 + 1;
		}
		if (c==y){
			num2=num2 + 1;
		}
		if (d==z){
			num2=num2 + 1;
		}
		System.out.print("Guess: " + input + "; ");
		//4.2
		int lie=0;
		if (liePossible== 1){
			lie=1;
		}
		if(liePossible== -1){
		//generates the lie variable
			lie = r.nextInt(3)+1;
		}
		//if it lies and it prints out lies. 
		if (lie==3){
			int whichNum = r.nextInt(2)+1;
			if (whichNum==1){
				int lie1 = r.nextInt(4) + 1;
				if (lie1==num1 || lie1 < num2){
					while(lie1==num1 || lie1 < num2){
						lie1 = r.nextInt(4) + 1;
					}
				}
				System.out.println("Result: "+ lie1 + "," + num2);
			}
			if (whichNum==2){
				int lie2 = r.nextInt(4) + 1;
				//could add in lie2==3 for both if we never want 4,3 when num1=4
				if( lie2==num2 || lie2 > num1 || (num1==4 && lie2==4)){
					while(lie2==num2 || lie2 > num1 || (num1==4 && (lie2==4 || lie2==3))){
						lie2 = r.nextInt(4)+1;
					}
				}
				System.out.println("Result: "+ num1 + "," + lie2);	
			}
			if (DEBUG==true){
				System.out.println("Lie");
			}
		}
		if (lie==1 || lie==2){
			if (num2 < 4){
				System.out.println("Result: " + num1+","+num2);
			}
		}
		liePossible *= -1;
		return false;
	 	}  
}
