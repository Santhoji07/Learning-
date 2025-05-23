// Java Program to Rotate an Array Left or Right

import java.util.Scanner;
public class a1{
 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
 // Fixed array for simplicity
 int[] arr = {1, 2, 3, 4, 5, 6, 7};
 System.out.print("Enter number of positions to rotate: ");
 int positions = input.nextInt();
 System.out.print("Enter direction (Left/Right): ");
 String direction = input.next();
 positions = positions % arr.length; // To handle rotations > array length
 if (direction.equalsIgnoreCase("Left")) {
 leftRotate(arr, positions);
 } else if (direction.equalsIgnoreCase("Right")) {

 rightRotate(arr, positions);
 } else {
 System.out.println("Invalid direction entered.");
 return;
 }
 System.out.print("Rotated Array: [");
 for (int i = 0; i < arr.length; i++) {
 System.out.print(arr[i]);
 if (i < arr.length - 1) System.out.print(", ");
 }
 System.out.println("]");
 }
 public static void leftRotate(int[] arr, int d) {
 int n = arr.length;
 reverse(arr, 0, d - 1);
 reverse(arr, d, n - 1);
 reverse(arr, 0, n - 1);
 }
 public static void rightRotate(int[] arr, int d) {
 int n = arr.length;
 reverse(arr, 0, n - 1);
 reverse(arr, 0, d - 1);
 reverse(arr, d, n - 1);
 }
 public static void reverse(int[] arr, int start, int end) {
 while (start < end) {
 int temp = arr[start];

 arr[start] = arr[end];
 arr[end] = temp;
 start++;
 end--;
 }
 }
}