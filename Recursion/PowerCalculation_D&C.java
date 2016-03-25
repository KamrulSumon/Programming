package com.java.power.div;

class Power{
	
	static int counter = 0;
	 
	public double power(double x, long n){
		counter ++;		
		
		if(n == 0 ) return 1.0;
		else if( n == 1) return x;
		else
		{
			long n1 = (long) Math.ceil((double)n/2);
			long n2 = (long) Math.floor((double)n/2);
			return power(x, n1) * power(x, n2 );
		}
	}
	
	public int showSteps(){
		return counter;
	}
}

public class PowerCalculation {

	public static void main(String[] args) {

		Power pw = new Power();
		double x = 1.0;
		long n = 1000;
		System.out.println("Power of "+x+" to "+n+" "+pw.power(x, n));
		System.out.println("Steps: "+pw.showSteps());

	}

}
