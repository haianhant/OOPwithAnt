package Java.OOP.Lab01;
import java.util.Scanner;
import java.util.Arrays;
public class exercise66 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int column = scanner.nextInt();
        int[][] matrix1 = new int[row][column];
        int[][] matrix2 = new int[row][column];
        int[][] matrix3 = new int[row][column];
        System.out.println("Enter the element of the matrix 1:");
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
            System.out.print("Element ["+(i+1)+"]"+"["+(j+1)+"]: ");
            matrix1[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter the element of the matrix 2:");
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
            System.out.print("Element ["+(i+1)+"]"+"["+(j+1)+"]: ");
            matrix2[i][j] = scanner.nextInt();
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
            matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("Matrix 1: " + Arrays.deepToString(matrix1));
        System.out.println("Matrix 2: " + Arrays.deepToString(matrix2));
        System.out.println("Sum of two matrix: " + Arrays.deepToString(matrix3));
        scanner.close();
    }
}
