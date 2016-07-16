/**
* Reverse the digit of a Number
* @Kamrul hasan
* @LeetCode 07
*/

public class ReverseDigitNumber {
    public int reverse(int x) {
        int sign = 1;
        if(x < 0){
            sign = -1;
            x = -1 * x;
        }
        
        long r = 0;  // reverse number might be bigger so long is enough
        
        while(x > 0){
            r = r *10 + x % 10;
            x /= 10;
        }
       // handle overflow      
       if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
        	return 0;
    	}
        return (int)(sign * r);
    }
}
