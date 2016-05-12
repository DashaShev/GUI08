package zad1;

import java.util.concurrent.LinkedTransferQueue;

public class TowarProcessor implements Runnable {
	
    private int waga;
	private  LinkedTransferQueue<Towar> towarTransQueue;
	
	  public TowarProcessor(LinkedTransferQueue z){
		  this.towarTransQueue = z;
	  }
	
	@Override
	public void run() {
		try {
			Integer counter = 0;
			Towar towar = towarTransQueue.take();
			waga+=towar.weight;
			counter++;
			if(counter % 100 == 0){
      		  System.out.println("counted weight of " + counter + " goods");
      	  }
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

}
