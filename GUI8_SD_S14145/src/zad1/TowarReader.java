package zad1;

import java.io.*;
import java.util.concurrent.LinkedTransferQueue;

public class TowarReader implements Runnable {
	
	private LinkedTransferQueue<Towar> towarTransQueue;
	
	  public TowarReader(LinkedTransferQueue z){
		  this.towarTransQueue = z;
	  }
	

	@Override
	public void run() {
		
		String currentUsersHomeDir = System.getProperty("user.home");
    	String towary_fn = currentUsersHomeDir + File.separator + "Towary.txt";
		
    	try (BufferedReader br = new BufferedReader(new FileReader(towary_fn))) {
    	    String line;
    	    Integer counter = 0;
    	    while ((line = br.readLine()) != null) {
	        	  
	        	  String[] dane = line.split(" ");
	        	  
	        	  if(dane.length != 2){
	        		  System.out.println(line);
	        	  }
	        	  int t1 = Integer.parseInt(dane[0]);
	        	  int t2 = Integer.parseInt(dane[1]);
	        	  
	        	  Towar towar = new Towar(t1, t2);
	        	  counter++;
	        	  
	        	  if(counter % 200 == 0){
	        		  System.out.println("created " + counter + " objects");
	        	  }
	        	  
	        	  try {
					towarTransQueue.transfer(towar);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
	        	  
	          }
	             
	          
	          br.close();
	      }
	      catch(IOException ex){
	    	  System.out.println(ex.getMessage());
	      }   
		  
		
	}

}

