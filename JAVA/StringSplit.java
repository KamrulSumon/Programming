package com.sumon.java;

/**
 * Java String Split function
 * @author Kamrul Hasan
 *
 */

public class StringSplit {
	
	public String[] stringSplit(String str){
		//No Limit
		String sampleString = "Cat,Dog,Elephant";
		String[] animals = sampleString.split(",");
		
		//Limit
		String[] shapes = "Circle,Square,Rectangle,Hexagon".split(",", 2); //output: {"Circle", "Square,Rectangle,Hexagon"};
		shapes = "Circle,Square,Rectangle,Hexagon".split(",", 3); //output: {"Circle", "Square", "Rectangle,Hexagon"};
		
		//Regular Expression
		String digitsRegrex = "\\d+";
		String[] items = "abc123def456ghi789".split("\\d+"); //output: {"abc", "def", "ghi"};
		digitsRegrex = "[a-zA-Z]+";
		items = "123abc456def789".split("[a-zA-Z]+"); //output: {"123", "456", "789"};
		
		//Pitfalls
		//We can't use "." and "|"
		items = "A.B.C".split("\\."); //output: {"A", "B", "C"};
		items = "A|B|C".split("\\|"); //output: {"A", "B", "C"};
		
		//Empty String
		items = ",A,B,C".split(","); //output: { "", "A", "B", "C" };
		items = ",A,B,,,C".split(","); //output:  "", "A", "B", "", "", "C" };
		items = "A,B,C,,,,,,,,,,".split(","); // output: { "A", "B", "C" };
		items = "A,B,C,,,".split(",", -1); //output: { "A", "B", "C", "", "", "" }; 
		return shapes;
	} 
}

