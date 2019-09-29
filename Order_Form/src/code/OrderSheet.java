package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class OrderSheet {

	private ArrayList<Observer> _observers;	
	ArrayList<String> codeList = new ArrayList<String>();
	ArrayList<String> productList = new ArrayList<String>();
	
	public OrderSheet(String file) {
		readCSVFile(file);
	}

	public ArrayList<String> readCSVFile(String filename){
		
    	try { 
    		for(String each: Files.readAllLines(Paths.get(filename))) {
    			if(each.contains(",")) {
    			int split = each.indexOf(",");
    			String code=each.substring(0, split);
    			String product=each.substring(split+1,each.length());
    			codeList.add(code);
    			productList.add(product);
    			}
    			else {
    				codeList.add(each);
        			productList.add(each);
    			}
    		}
    	}catch (IOException ex){
            ex.printStackTrace();
        }
    	  return productList;
    }
	
	public void notifyObservers() {
		for (Observer obs : _observers) {
			obs.update();
		}
	}
	
	public ArrayList<String> getCodes(){
		return codeList;
	}
	
	public ArrayList<String> getProducts(){
		return productList;
	}

	public void clearSearch() {
		GUI.GUI.search.setText("");
	}
	
	public void search() {
		String s = GUI.GUI.search.getText();
	}
	
	
}