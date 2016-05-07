package zad1;

import java.io.*;

public class TowarReader implements Runnable {
	
	
	  
	
	

	@Override
	public void run() {
		
		BufferedReader bufferedReader = null;
		
		  try(FileReader reader = new FileReader("C:\\Users\\Dasha\\Towary.txt"))
	      {
	         
			  bufferedReader = new BufferedReader(reader);
	          while(bufferedReader.readLine()!=null){
	        	  Towar towar1 = new Towar(); 
	          }
	             
	          
	          bufferedReader.close();
	      }
	      catch(IOException ex){
	           
	      }   
		  
		
	}

}
