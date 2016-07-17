/**
 * Int to Roman conversion
 * @author Kamrul Hasan
 * @source LeetCode #12
 */
package com.sumon.leetcode;

public class IntToRomanConversion {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        
        if(num >= 1000){
            for(int i = 1; i <= num/1000; i++){
                sb.append("M"); 
            }
        }
            num = num % 1000;
            String hnd = convertToHundred(num/100);
            sb.append(hnd);
            num = num % 100;
            String ten = convertToTen(num/10);
            sb.append(ten);
            String unit = convertToUnit(num%10);
            sb.append(unit);
        
        return sb.toString();
    }
    /* convert 100 to 900 */
    private String convertToHundred(int n){
        String str= "";
        switch(n){
            case 3: str += "C";
            case 2: str += "C";
            case 1: str += "C"; break;
            case 4: str += "C";
            case 5: str += "D"; break;
            case 6: str += "DC"; break;
            case 7: str += "DCC"; break;
            case 8: str += "DCCC"; break;
            case 9: str += "CM"; break;
        }
        return str;
    }
    /* convert 10 - 90 */
    private String convertToTen(int n){
       String str= "";
        switch(n){
            case 3: str += "X";
            case 2: str += "X";
            case 1: str += "X"; break;
            case 4: str += "X";
            case 5: str += "L"; break;
            case 6: str += "LX"; break;
            case 7: str += "LXX"; break;
            case 8: str += "LXXX"; break;
            case 9: str += "XC"; break;
        }
        return str;
    }
    /* convert 1 - 9 */
    private String convertToUnit(int n){
       String str= "";
        switch(n){
            case 3: str += "I";
            case 2: str += "I";
            case 1: str += "I"; break;
            case 4: str += "I";
            case 5: str += "V"; break;
            case 6: str += "VI"; break;
            case 7: str += "VII"; break;
            case 8: str += "VIII"; break;
            case 9: str += "IX"; break;
        }
        return str;

    }
    
    /* int to roman  from leetcode solution*/
    public String intToRoman2(int num) {
        String [] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String [] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String [] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String [] M = {"", "M", "MM", "MMM"};
        
        /*Indices to retrieve from the above arrays:
        Thousands = num/1000
        Hundreds = (num % 1000)/100
        Tens = (num % 100)/10
        Units = num % 10
        */
        
        return (M[num/1000] + C[(num % 1000)/100] + X[(num % 100)/10] + I[num % 10]).trim();
    }
}
