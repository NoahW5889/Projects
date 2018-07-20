package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

public class OrderSheet {

	private LinkedHashMap<String,String> list;
	
	public OrderSheet(String file) {
		readCSVFile(file);
	}

	public LinkedHashMap<String,String> readCSVFile(String filename){
		list = new LinkedHashMap<String,String>();
		
    	try { 
    		for(String each: Files.readAllLines(Paths.get(filename))) {
    			if(each.contains(",")) {
    			int split = each.indexOf(",");
    			String code=each.substring(0, split);
    			String product=each.substring(split+1,each.length());
    			list.put(code, product);
    			}
    			else {
    				list.put(each, each);
    			}
    		}
    	}catch (IOException ex){
            ex.printStackTrace();
        }
    	  return list;
    }
	
	public LinkedHashMap<String,String> getList(){
		return list;
	}
	
	public int getLength() {
		return list.size();
	}
	
}
