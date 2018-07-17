package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class OrderSheet {

	public OrderSheet(String file) {
		readCSVFile(file);
	}

	public ArrayList<String> readCSVFile(String filename){
		ArrayList<String> ProductList = new ArrayList<String>();
    	try { 
    		for(String each: Files.readAllLines(Paths.get(filename))) {
    			ProductList.add(each);
    			
    		}
    	}catch (IOException ex){
            ex.printStackTrace();
        }
    	System.out.println(ProductList);
    	  return ProductList;
    }
	
	
	
}
