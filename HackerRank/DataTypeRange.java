package com.sumon.datatype;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

class Solution{
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {
            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                if(x>=-32768 && x<=32767) out.println("* short");
                if(x>=-2147483648 && x <=2147483647) out.println("* int");
                if(x>=-9223372036854775808L && x<=9223372036854775807L) out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }
        }
    }
}
 















/*
import java.util.Scanner;
import static java.lang.System.out;

class DataType{
	
	
	public void checkForByet(long n){		
		if(n>=-128 && n<=127) out.println("* byte");
	}
	
	public void checkForShort(long n){		
		if(n>=-65536 && n<= 32768) out.println("* short");
	}
	
	public void checkForInt(long n){		
		if(n>=-Math.pow(2, 32) && n <= Math.pow(2, 31)) out.println("* int");
	}
	
	public void checkForLong(long n){		
		if(n>=-Math.pow(2, 64) && n<= Math.pow(2, 63)) out.println("* long");
	}
	
	public void findDataType(long n){
		
		try{
			out.println(n+" can be fitted in:");
			checkForByet(n);
			checkForShort(n);
			checkForInt(n);
			checkForLong(n);
		}catch(Exception e){
			out.println(n+" can't be fitted anywhere.");
		}
	}
}


public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        int testCase;
        long number;
        DataType dt = new DataType();
        testCase = sc.nextInt();
        
        for(int i = 0; i < testCase; i++){
        	number = sc.nextLong();
        	dt.findDataType(number);
        }
        

	}

}


*/


