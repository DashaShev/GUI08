package zad1;

import java.io.*;

public class TowarReader implements Runnable {
	
	
	  
	
	

	@Override
	public void run() {
		
		String currentUsersHomeDir = System.getProperty("user.home");
    	String towary_fn = currentUsersHomeDir + File.separator + "Towary.txt";
		
    	try (BufferedReader br = new BufferedReader(new FileReader(towary_fn))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
	        	  
	        	  String[] dane = line.split(" ");
	        	  
	        	  if(dane.length != 2){
	        		  System.out.println(line);
	        	  }
	        	  int t1 = Integer.parseInt(dane[0]);
	        	  int t2 = Integer.parseInt(dane[1]);
	        	  
	        	  Towar towar = new Towar(t1, t2);
	          }
	             
	          
	          br.close();
	      }
	      catch(IOException ex){
	    	  System.out.println(ex.getMessage());
	      }   
		  
		
	}

}
