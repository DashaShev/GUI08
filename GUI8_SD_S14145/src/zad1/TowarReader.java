package zad1;

import java.io.*;

public class TowarReader implements Runnable {
	
	
	  
	
	

	@Override
	public void run() {
		
		bufferedReader = new BufferedReader(reader);
			  String buff = bufferedReader.toString();
	          while(bufferedReader.readLine()!=null){
	        	  
	        	  String[] dane = buff.split(" ");
	        	  System.out.format("dana[0]='%s'  dana[1]='%s'\n", dane[0], dane[1]);
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
