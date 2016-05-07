package towary;

import java.io.*;

public class towary {

    public static void main(String[] args) {
    	
    	for(int i = 0; i <10000; i++){
        
        try(FileWriter writer = new FileWriter("C:\\Users\\Dasha\\Towary.txt", true))
        {
           
        	int i1 = i;
        	String str = " ";
        	int i2 = (int)Math.random()*100;
            writer.write(i1 + str + i2);
      
            writer.append('\n'); 
            writer.append('E');
             
            writer.flush(); }
      
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
        
       }
            
    } 

}

