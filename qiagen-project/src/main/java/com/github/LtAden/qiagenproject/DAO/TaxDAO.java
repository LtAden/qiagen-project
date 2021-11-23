package com.github.LtAden.qiagenproject.DAO;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.github.LtAden.qiagenproject.model.TaxSubtractor;

/*
 * This class contains a list, where 5 most recent calculations are stored. Upon creation, list contains 5 nulls. As new calculations are made, recorded calculations are shifted to 
 * the end of the list - first one is replaced by most recent calculation, and last one is forgotten. 
 * 
 * getResults method can be used to obtain 
 */

public class TaxDAO {

	public static List<TaxSubtractor> mainList = new LinkedList<TaxSubtractor>(Arrays.asList(null,null,null,null,null));
	
	
	/*
	 * mainList holds only last 5 calculations made. Older ones are replaced with newer ones, oldest one is removed, and first one is replaced with parsed income. 
	 * */
	public static double addResult(double income) {
		mainList.set(4, mainList.get(3));
		mainList.set(3, mainList.get(2));
		mainList.set(2, mainList.get(1));
		mainList.set(1, mainList.get(0));
		mainList.set(0, new TaxSubtractor(income));
		
		return mainList.get(0).getEAT();
		
	}
	/*
	 * Returns list with 5 last calculations made
	 * */
	public static List<TaxSubtractor> getResults(){
		return mainList;
	}
	
}
