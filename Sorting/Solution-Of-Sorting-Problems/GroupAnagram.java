package com.sumon.sorting.groupanagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * Implementation of grouping anagram string
 * 
 * @author Kamrul Hasan 
 * Source: Cracking the coding interview 10.2
 */
class GroupAnagramImpl {

	public void groupAnagram(String[] array) {
		HashMapList<String, String> mapList = new HashMapList<String, String>();

		for (String str : array) {
			String sortedStr = sortCharacters(str);
			mapList.put(sortedStr, str);
		}

		int index = 0;
		for (String key : mapList.keySet()) {
			ArrayList<String> list = mapList.get(key);
			for (String s : list) {
				array[index] = s;
				index++;
			}
		}
	}

	/* Sort the characters of a string */
	public String sortCharacters(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
}

/* HashMapList data structure */
class HashMapList<T, E> {
	private HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();

	/* Insert single item into list at key */
	public void put(T key, E item) {
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<E>());
		}
		map.get(key).add(item);
	}

	/* Insert list of items at key */
	public void put(T key, ArrayList<E> items) {
		map.put(key, items);
	}

	/* Get list of items at key */
	public ArrayList<E> get(T key) {
		return map.get(key);
	}

	/* Check HashMapList contains key */
	public boolean containsKey(T key) {
		return map.containsKey(key);
	}

	/* Check list at key contains value */
	public boolean containsKeyValue(T key, E value) {
		ArrayList<E> list = map.get(key);
		if (list == null)
			return false;
		return list.contains(value);
	}

	/* Get the list of Keys */
	public Set<T> keySet() {
		return map.keySet();
	}

	@Override
	public String toString() {
		return map.toString();
	}
}

/* Testing of GroupAnagram */
public class GroupAnagram {

	public static void main(String[] args) {
		GroupAnagramImpl ga = new GroupAnagramImpl();
		String[] array = { "acre", "race", "care", "dhaka", "kahad", "hadka" };
		ga.groupAnagram(array);

		for (String str : array) {
			System.out.println(str + " ");
		}
	}
}
