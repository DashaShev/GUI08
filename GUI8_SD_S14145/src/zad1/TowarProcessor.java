package zad1;

import java.util.concurrent.LinkedTransferQueue;

public class TowarProcessor implements Runnable {

	static LinkedTransferQueue<Object> towarTransQueue = new LinkedTransferQueue<Object>();
	
	  public TowarProcessor(LinkedTransferQueue z){
		  this.towarTransQueue = z;
	  }
	
	@Override
	public void run() {
		try {
			Object towar = towarTransQueue.take();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

}
