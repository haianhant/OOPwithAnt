package Java.OOP.OOPLab1;

import java.util.Arrays;
import java.util.Scanner;

public class exercise65 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Element "+(i+1)+": ");
            array[i] = scanner.nextInt();
        }
        System.out.println("The original array: " + Arrays.toString(array));
        
        Arrays.sort(array);
       
        int sum = 0;
        for (int num : array) {
            sum += num;
        }

        double average = (double) sum / n;

        System.out.println("Array after sorting: " + Arrays.toString(array));
        System.out.println("Sum of the elements: " + sum);
        System.out.println("Average of the elements: " + average);

        scanner.close();

    }
}

