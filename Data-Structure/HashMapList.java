package com.sumon.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * Implementation of HashMapList
 * @author Kamrul Hasan
 *
 * @param <T> data type of key
 * @param <E> data type of value
 * 
 * Ref: Cracking the coding interview
 */

class HashMapList<T, E>{
	private HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();
	
	/*Insert single item into list at key*/
	public void put(T key, E item){
		if(!map.containsKey(key)){
			map.put(key, new ArrayList<E>());
		}
		map.get(key).add(item);
	}
	
	/*Insert list of items at key*/
	public void put(T key, ArrayList<E> items){
		map.put(key, items);
	}
	
	/*Get list of items at key*/
	public ArrayList<E> get(T key){
		return map.get(key);
	}
	
	/*Check HashMapList contains key*/
	public boolean containsKey(T key){
		return map.containsKey(key);
	}
	
	/*Check list at key contains value*/
	public boolean containsKeyValue(T key, E value){
		ArrayList<E> list = map.get(key);
		if(list == null) return false;
		return list.contains(value);
	}
	
	/*Get the list of Keys*/
	public Set<T> keySet(){
		return map.keySet();
	}
	
	@Override
	public String toString(){
		return map.toString();
	}
}

/*Testing of HashMapList functionalities*/
public class HashMapListTest {

	public static void main(String[] args) {
		HashMapList<String, String> mapList = new HashMapList<String, String>();
		ArrayList<String> bdList = new ArrayList<String>(Arrays.asList("Dhak", "Barisal", "CTG", "Khulna","RAJ"));
		ArrayList<String> usList = new ArrayList<String>(Arrays.asList("TN", "CA", "NY", "MA","TX"));
		mapList.put("BD", bdList);
		mapList.put("US", usList);
		
		System.out.println(mapList.keySet());
		for(String item : mapList.get("BD"))
			System.out.print(item+" ");
	}

}
