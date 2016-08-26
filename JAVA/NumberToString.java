package com.sumon.java;

/**
 * Number to String in Java
 * @author Kamrul Hasan
 *
 */

public class NumberToString {
	
	public void numberToString(){
		/*------------------------------------------------ integer to String-----------------------------------------------*/
		//Convert using Integer.toString(int)
		//Convert using String.valueOf(int)
		//Convert using new Integer(int).toString()
		//Convert using String.format()
		//Convert using DecimalFormat
		//Convert using StringBuffer or StringBuilder
		//Quick Solution
		//Convert with special radix (not base 10 system)
		
		int number = -782;
		String numberAsString = Integer.toString(number); //output: "-782"
		
		number = -782;
		Integer intInstance = new Integer(number);      
		numberAsString = intInstance.toString(); //output: "-782"
		numberAsString = new Integer(number).toString(); //shorthand
		number = -782;
		numberAsString = String.format ("%d", number); //format
		//StringBuffer
		number = -782;
		StringBuffer sb = new StringBuffer();
		sb.append(number);
		numberAsString = sb.toString();
		new StringBuffer().append(-782).toString(); //shorthand
		//StringBuilder
		number = -782;
		StringBuilder sbl = new StringBuilder();
		sb.append(number);
		numberAsString = sbl.toString();
		new StringBuilder().append(-782).toString(); //shorthand
		
		//Quick Solution
		number = -782;
		numberAsString = "" + number;
		
		number = 123;
		numberAsString = String.format ("%05d", number); //output:  00123
		numberAsString = String.format ("%010d", number); //output: 0000000123
		
		/*---------------------------------------------- Long to String --------------------------------*/
		//Convert using Long.toString(long)
		//Convert using String.valueOf(long)
		//Convert using new Long(long).toString()
		//Convert using String.format()
		//Convert using DecimalFormat
		//Convert using StringBuffer or StringBuilder
		//Quick Solution
		//Convert with special radix (not base 10 system)
		
		/*---------------------------------------------- Float to String ----------------------------------*/ 
		//Convert using Float.toString(float)
		//Convert using String.valueOf(float)
		//Convert using new Float(float).toString()
		//Convert using String.format()
		//Convert using DecimalFormat
		//Convert using StringBuffer or StringBuilder
		//Quick Solution
		
		/*--------------------------------------------- Double to String -----------------------------------*/
		//Convert using Double.toString(double)
		//Convert using String.valueOf(double)
		//Convert using new Double(double).toString()
		//Convert using String.format()
		//Convert using DecimalFormat
		//Convert using StringBuffer or StringBuilder
		//Quick Solution
	}
}
