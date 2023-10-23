package com.example.logic.basic.reverse;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter a your string value :");
        String str = sc.next();
        String rev = "";

//      1 : using : String concatenation operators , and chartAt(index) and str.length()
/*
1 : find the length of a string : str.length()
2 : iterate a character for the end
3 : extract a character and add [concat] the character into another variable
4 : used to string methode 1 : length() for length and 2 : charAt[] for extraction
 */

        int length = str.length();
        for (int i = length-1; i >=0; i--){
            rev = rev + str.charAt(i);
        }
        System.out.println("revers string is : "+rev);

//   2 : using character array : toCharArray() , arr.length , String concatenation operators
/*
1 : ste.toCharArray() : convert string into multiple part
2 : find the length of an array : arr.length;
3 : from character array we need to read the value from end : required index
4 : extract a character from character array and add [concat] the character into another variable
 */

        char a[] = str.toCharArray();
        int length1 = a.length;
        for (int i =length1-1 ; i>=0; i--){
            rev = rev + a[i];
        }
        System.out.println("revers string is : "+rev);

//      3 : using StringBuffer class : reverse()
        StringBuffer stringBuffer = new StringBuffer(str);
        StringBuffer reverse = stringBuffer.reverse();
        System.out.println("revers string is : "+reverse);

//     4 : using StringBuilder class : reverse()
        StringBuilder stringBuilder = new StringBuilder(str);
        StringBuilder reverse1 = stringBuilder.reverse();
        System.out.println("revers string is : "+reverse1);


}


}
