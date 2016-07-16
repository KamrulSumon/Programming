/**
* Reverse the digit of integer
* @Kamrul Hasan
* @LeetCode _07
*/ 

class ReverseInteger {
    public int reverse(int x) {
        int sign = 1;
        if(x < 0){
            sign = -1;
            x = -1 * x;
        }
        
        long r = 0;
        
        while(x > 0){
            r = r *10 + x % 10;
            x /= 10;
        }
           
        
        //check if overflow
       if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
        return 0;
    }
        return (int)(sign * r);
    }
}
