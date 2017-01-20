/**
 * FizzBuzz: Output numbers from 1 to x. If the number is divisible by 3, replace it with Fizz. If the number
 * is divisible by 5, replace it with "Buzz". If it is divisible by 3 and 5 replace it with "FizzBuzz"
 * Created by sumon on 1/20/17.
 */
public class FizzBuzz {

    public void FizzBuzz(int n) {

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }

        }
    }
}
