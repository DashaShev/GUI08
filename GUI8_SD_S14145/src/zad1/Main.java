/**
 *
 *  @author Shevchenko Dariia S14145
 *
 */

package zad1;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;

public class Main {

	
	
	public static void main(String[] args) { 
  	
  	LinkedTransferQueue<Towar> towarTransQueue = new LinkedTransferQueue<Object>();
  
  	ExecutorService exService = Executors.newFixedThreadPool(2);
  	Runnable producer = new TowarReader(towarTransQueue);
  	Runnable consumer = new TowarProcessor(towarTransQueue);
	exService.execute(producer);
	exService.execute(consumer);
	exService.shutdown();
    
	  
	 
	  
  }
}
