/**
 *
 *  @author Shevchenko Dariia S14145
 *
 */

package zad1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;

public class Main {

	public static void main(String[] args) { 
  	
  	LinkedTransferQueue<Towar> towarTransQueue = new LinkedTransferQueue<Towar>();
  
  	ExecutorService exService = Executors.newFixedThreadPool(2);
  	Runnable producer = new TowarReader(towarTransQueue);
  	Runnable consumer = new TowarProcessor(towarTransQueue);
  	System.err.println("Start producer");
	exService.execute(producer);
	System.err.println("Start consumer");
	exService.execute(consumer);
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.err.println("Shutdown threads.");
	exService.shutdown();
	System.err.println("Done.");  
  }
}
