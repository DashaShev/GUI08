/**
 *
 *  @author Shevchenko Dariia S14145
 *
 */

package zad1;

import java.io.*;

public class Main {

  public static void main(String[] args) {
	  
	TowarReader towar = new TowarReader();
  	
  	Thread thr = new Thread(towar);
  	thr.start(); 
  
	  
  }
}
