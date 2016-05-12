package zad1;

import java.io.*;
import java.util.concurrent.LinkedTransferQueue;

public class TowarReader implements Runnable {
	
	private LinkedTransferQueue<Towar> towarTransQueue;
	
	public TowarReader(LinkedTransferQueue<Towar> z){
		this.towarTransQueue = z;
	}
	

	@Override
	public void run() {
		
		String currentUsersHomeDir = System.getProperty("user.home");
    	String towary_fn = currentUsersHomeDir + File.separator + "Towary.txt";
		System.err.println("TowarReader.run(): process " + towary_fn);
    	try
    	{
    	    String line;
    	    Integer counter = 0;
    	    BufferedReader br = new BufferedReader(new FileReader(towary_fn));
    	    while ((line = br.readLine()) != null) {
	        	  
	        	  String[] dane = line.split(" ");
	        	  // System.err.println(line);
	        	  if(dane.length != 2){
	        		  System.err.println("Unhandled line: " + line);
	        		  continue;
	        	  }
	        	  int t1 = Integer.parseInt(dane[0]);
	        	  int t2 = Integer.parseInt(dane[1]);
	        	  
	        	  Towar towar = new Towar(t1, t2);
	        	  counter++;
	        	  
	        	  if(counter % 200 == 0){
	        		  System.out.println("created " + counter + " objects");
	        	  }


				  towarTransQueue.transfer(towar);
	          }
	          br.close();
	          System.err.println("TowarReader.run(): done");
     	} catch (InterruptedException ex) {
	    	  System.err.println(ex.getMessage());
	    }
	    catch(IOException ex){
	    	  System.err.println(ex.getMessage());
	    }
    	finally {
    		// this code will be executed in any case
    		try {
				towarTransQueue.transfer(null);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}  
		System.err.println("TowarReader.run() finished");
	}

}
