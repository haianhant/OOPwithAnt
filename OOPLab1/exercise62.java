package Java.OOP.OOPLab1;

import java.util.Scanner;
public class exercise62 {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        System.out.println("What is your name");
        String strName = key.nextLine();
        System.out.println("How old are you?");
        int iAge = key.nextInt();
        System.out.println("How tall are you?");
        double dHeight = key.nextDouble();

        // similar to other data types
        // nextByte(), nextShort(), nextLong()
        // nextFloat(), nextBoolean()

        System.out.println("Mrs/Ms. " + strName + ", " + iAge + " years old. " 
        + "Your height is " + dHeight + ".");

        key.close();
    }
}
