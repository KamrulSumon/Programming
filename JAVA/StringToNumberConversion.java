package com.sumon.java;

/**
 * String to Number convertion in Java
 * @author sumon
 *
 */

public class StringToNumberConversion {

	public void stringToNumber(){
		//String to integer
		String numberAsString = "1234";
		int number = Integer.parseInt(numberAsString);  //syntax: public static int parseInt(String s) throws NumberFormatException
		
		//Integer.valueOf() static method will return an Integer object holding the value of the specified String.
		number = Integer.valueOf(numberAsString);
		
		numberAsString = "11111111";
		int number1 = Integer.valueOf(numberAsString, 2); //output: 255
		int number2 = Integer.parseInt(numberAsString, 2); //outut: 255
		
		numberAsString = "377";
		number1 = Integer.valueOf(numberAsString, 8); //output: 255
		number2 = Integer.parseInt(numberAsString, 8); //output: 255
		
		/* ---------------------------------------------String to Long ------------------------------------------------------/
		Convert using Long.parseLong()
        Convert using Long.valueOf()
        Convert using new Long(String).longValue()
        Convert using DecimalFormat
        Convert with special radix (not base 10 system)
        
        /* ---------------------------------------------Sting to Float --------------------------------------- */
		//Convert using Float.parseFloat()
		//Convert using Float.valueOf()
		//Convert using new Float(String).floatValue()
		//Convert using DecimalFormat

		/* -------------------------------------- String to Double --------------------------------------------------- */
		// Convert using Double.parseDouble()
		// Convert using Double.valueOf()
		// Convert using new Double(String).doubleValue()
		// Convert using DecimalFormat
	}
}
