/**
 * Given a string, write a function to compress it by shortening every squence of the same character
 * to that character followed by the number of repetitions. If the compressed string is longer than
 * the original, you should return original string
 *
 * e.g.
 *
 * compress("a") = a compress("aaa") = a3 compress("aaabb") = a3b3 compress("aaabccc") = a3b1c3
 */

public class StringCompression {


  public static String compress(String str) {
    if (str.equals("") || str == null) {
      return null;
    }
    
    String result = "";
    int len = str.length();
    int count = 1;

    for (int i = 1; i < len; i++) {
      char prev = str.charAt(i - 1);
      char current = str.charAt(i);
      if (prev != current) {
        result += str.charAt(i - 1) + Integer.toString(count);
        count = 1;
      } else {
        count++;
      }
    }

    result += str.charAt(len - 1) + Integer.toString(count);
    return result.length() > str.length() ? str : result;
  }


  public static void main(String[] args) {
    System.out.println(StringCompression.compress("a"));
    System.out.println(StringCompression.compress("aaa"));
    System.out.println(StringCompression.compress("aaabb"));
    System.out.println(StringCompression.compress("aaabccc"));
  }
}
