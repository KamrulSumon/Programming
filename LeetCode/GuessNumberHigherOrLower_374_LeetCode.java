public class GuessNumber{

    public static void main(String[] args){
	GuessHigherOrLower gn = new GuessHigherOrLower();
	gn.guessNumber(20);
    }
}

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   int guess(int num); */

class GuessHigherOrLower{
    
  public int guessNumber(int upper){
      int mid;
      int lower = 1;

      while(lower < upper){
	  mid = lower + (upper - lower)/2;
	  switch(guess(mid)){
	      case 0:
		  return mid;
	      case 1:
		  mid = mid + 1;break; 
	      case -1:
		  mid = mid - 1;
	  }
      }
      return lower;
  }
}
