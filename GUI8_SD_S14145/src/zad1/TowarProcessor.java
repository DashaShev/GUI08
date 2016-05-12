package zad1;

import java.util.concurrent.LinkedTransferQueue;

public class TowarProcessor implements Runnable {
	
    private int waga;
	private  LinkedTransferQueue<Towar> towarTransQueue;
	
	  public TowarProcessor(LinkedTransferQueue<Towar> z){
		  this.towarTransQueue = z;
		  this.waga = 0;
	  }
	
	@Override
	public void run() {
		System.err.println("TowarProcessor.run() started");
		try {
			Integer counter = 0;
			Towar towar = this.towarTransQueue.take();
			while (towar != null) {
				waga += towar.weight;
				counter++;
				if (counter % 100 == 0){
	      		  System.out.println("counted weight of " + counter + " goods");
	      	    }
				towar = this.towarTransQueue.take();
			}
			System.out.println("Total weight is: " + waga);
		} catch (InterruptedException ex) {			
			ex.printStackTrace();
		}
		System.err.println("TowarProcessor.run() finished");
	}

}
