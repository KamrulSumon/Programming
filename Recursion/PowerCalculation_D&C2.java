package com.java.power.fourd;


class Power{
	
	static int counter = 0;
	 
	public double power2(double x, long n){
		counter ++;		
		
		if(n == 0 ) return 1.0;
		 if( n == 1) return x;
		if( n%2 == 0)		
			return power(x*x, n/2);
		else
			return power(x*x, n/2) * x;
	}
	
	public int showSteps(){
		return counter;
	}
	
	public double power(double x, long n){
		counter ++;		
		
		if(n == 0 ) return 1.0;
		 if( n == 1) return x;
		 double temp = power(x, n/2);
		if( n%2 == 0)		
			return temp*temp;
		else
			return temp* temp * x;
	}
}

public class PowerCalculation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Power pw = new Power();
		double x =1;
		long n = 1000;
		System.out.println("Power of "+x+" to "+n+" "+pw.power(x, n));
		System.out.println("Steps: "+pw.showSteps());

	}

}

