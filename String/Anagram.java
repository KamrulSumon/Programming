import java.io.*;
import java.util.*;

public class Anagram {

   static boolean isAnagram(String A, String B) {
      
       int i, lenA, lenB;
       
       A = A.toLowerCase();
       B = B.toLowerCase();
       
       lenA = A.length();
       lenB = B.length();
       
       int a [] = new int[26];
       int b [] = new int[26];
       
       for(i = 0; i < lenA; i++ ){
           a[ A.charAt(i) -'a']++;
       }
        
       for(i = 0; i < lenB; i++ ){
           b[ B.charAt(i) - 'a']++;
       }
       
       
       for(i = 0; i < 26; i++){
           if(a[i] != b[i]) return false;
       }
     return true;
   }
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        boolean ret=isAnagram(A,B);
        if(ret)System.out.println("Anagrams");
        else System.out.println("Not Anagrams");
        
    }
}
