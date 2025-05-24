//Two strings are anagrams if their sorted characters are equal.

import java.util.Scanner;
import java.util.Arrays;

public class a3{
 public static boolean isAnagram(String s1, String s2) {
 s1 = s1.replaceAll("\\s", "").toLowerCase();
 s2 = s2.replaceAll("\\s", "").toLowerCase();
 if (s1.length() != s2.length()) return false;
 char[] arr1 = s1.toCharArray();
 char[] arr2 = s2.toCharArray();
 Arrays.sort(arr1);
 Arrays.sort(arr2);
 return Arrays.equals(arr1, arr2);
 }

 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
 System.out.print("Enter first string: ");
 String str1 = input.nextLine();
 System.out.print("Enter second string: ");
 String str2 = input.nextLine();
 if (isAnagram(str1, str2)) {
 System.out.println("They are anagrams.");
 } else {
 System.out.println("They are not anagrams.");
 }
 }
}