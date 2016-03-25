import java.util.Scanner;
import static java.lang.System.out;

public class EOF {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int counter = 0;
		String str;
		
		while( sc.hasNext()){
		   counter++;
		   str = sc.nextLine();
		   out.format("%d %s", counter, str);
		}
	}
}
