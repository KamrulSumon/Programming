import static java.lang.System.out;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String num1, num2, result;
        BigInteger big1, big2, sum, multi;
        
        num1 = in.next();
        num2 = in.next();
        
        big1 = new BigInteger(num1);
        big2 = new BigInteger(num2);
        sum = big1.add(big2);
        
        multi = big1.multiply(big2);
        
        out.println(sum+"\n"+multi);
        
	}
}
