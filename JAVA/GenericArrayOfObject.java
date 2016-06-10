package com.sumon.java;

import java.lang.reflect.Array;

/**
 * Implemenation of Generic Array of Object 
 * @author Kamrul Hasan
 *
 * @param <T> data type
 */
class GenericArrayOfObjectCreation<T>{
	T[] values1;  //Objects will be created by (T[]new Object[size])
	Object[] values2; // Objects will be created by new Object[size]
	T[] values3;  //Objects will be created by (T[] Array.newInstace(type, size))
	
	public GenericArrayOfObjectCreation(Class<T> type, int size){
		values1 = (T[]) new Object[size];
		values2 = new Object[size];
		values3 = (T[]) Array.newInstance(type, size);
	}
	
	void put1(T data, int index){ values1[index] = data; }
	void put2(T data, int index){ values2[index] = data; }
	void put3(T data, int index){ values3[index] = data; }
	
	T get1(int index){ return values1[index]; }
	T get2(int index){ return (T)values2[index]; }
	T get3(int index){ return values3[index]; }
	
	void show(int index){
		System.out.println(get1(index));
	}
}



public class GenericArrayOfObject {

	public static void main(String[] args) {
		GenericArrayOfObjectCreation<Integer> ga = new GenericArrayOfObjectCreation<Integer>(Integer.class, 10);
		
		ga.put1(555, 1);
		ga.put2(555, 1);
		ga.put3(555, 1);
		
		GenericArrayOfObjectCreation k = ga;
		k.put1("data1", 1);
		k.put2("data2", 1);
	//	k.put3("data3", 1);     this would throw ArrayStoreException
		k.show(1);
	}

}
