package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;



public class Form {
	private String readinFile=null;
	private ArrayList<Observer> _observers;
	private ArrayList<Item> List = new ArrayList<Item>();
	
	public Form(String file) {
		readinFile=file;
		readCSVFile(file);
		_observers = new ArrayList<Observer>();
	}

public ArrayList<Item> readCSVFile(String filename){
	
	try { 
		for(String each: Files.readAllLines(Paths.get(filename))) {
			Item hold = new Item(0,"");
			if(each.contains(",")) {
			int split = each.indexOf(",");
			hold.setCode(Integer.parseInt(each.substring(0, split)));
			hold.setProduct(each.substring(split+1,each.length()));
			List.add(hold);
			}
			else {
				int split = each.indexOf(",");
				hold.setProduct(each.substring(split+1,each.length()));
				hold.setSpacer(true);
    			List.add(hold);
			}
		}
	}catch (IOException ex){
        ex.printStackTrace();
    }
	  return List;
}

public void createList() {
	readCSVFile(readinFile);
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
*/


public ArrayList<Item> getList(){
	return List;
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
}