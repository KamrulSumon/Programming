package com.java.power;

class Power{
	
	static int counter = 0;
	 
	public double power(double x, long n){
		counter ++;
		if(n == 0 ) return 1.0;
		else
			return x * power(x, n -1 );
	}
	
	public int showSteps(){
		return counter;
	}
}

public class PowerCalculation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Power pw = new Power();
		double x = 1.0;
		long n = 1000;
		System.out.println("Power of "+x+" to "+n+" "+pw.power(x, n));
		System.out.println("Steps: "+pw.showSteps());

	}

}
