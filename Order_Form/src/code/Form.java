package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;



public class Form {
	private String readinFile=null;
	private ArrayList<Observer> _observers;
	private ArrayList<String> productList = new ArrayList<String>();
	private ArrayList<String> codeList = new ArrayList<String>();
	
	public Form(String file) {
		readinFile=file;
		readCSVFile(file);
		_observers = new ArrayList<Observer>();
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


/*
public void search() {
	String searchBox = GUI.GUI.search.getText();
	ArrayList<String> Searchcode = OrderSheet.getCodes();
	ArrayList<String> Searchproduct = new ArrayList<String>();
	
	for(int i=0;i<productList.size();i++) {
		if(productList.get(i).toLowerCase().contains(searchBox.toLowerCase())||(productList.get(i).toUpperCase()==productList.get(i))) {
			searchList.productList.add(productList.get(i));
		}
	}
	GUI.GUI.this.settup(productList);
	notifyObservers();
}

public void clearSearch() {
	GUI.GUI.search.setText("");
}
*/

public ArrayList<String> getProducts(){
	return productList;
}

public ArrayList<String> getCodes(){
	return codeList;
}

public void addObserver(Observer obs) {
	_observers.add(obs);
	notifyObservers();
}

public void notifyObservers() {
	for (Observer obs : _observers) {
		obs.update();
	}
}

public void clearSearch() {
	GUI.GUI.search.setText("");
}

public void search() {
	String s = GUI.GUI.search.getText();
}

}