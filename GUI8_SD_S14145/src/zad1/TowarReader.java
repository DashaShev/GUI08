package zad1;

import java.io.*;

public class TowarReader implements Runnable {
	
	
	  
	
	

	@Override
	public void run() {
		
		BufferedReader bufferedReader = null;
		
		  try(FileReader reader = new FileReader("C:\\Users\\Dasha\\Towary.txt"))
	      {
	         
			  bufferedReader = new BufferedReader(reader);
			  String buff = bufferedReader.toString();
	          while(bufferedReader.readLine()!=null){
	        	  String[] dane = buff.split(" ");
	        	  int t1 = Integer.parseInt(dane[0]);
	        	  int t2 = Integer.parseInt(dane[1]);
	        	  Towar towar = new Towar(t1, t2);
	          }
	             
	          
	          bufferedReader.close();
	      }
	      catch(IOException ex){
	           
	      }   
		  
		
	}

}
