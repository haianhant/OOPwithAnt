package Java.OOP.Lab01;

import javax.swing.JOptionPane;
import java.lang.Math;
public class Caculate2Numbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null, "Please input the 1st number: ", "Input the 1st number",
        JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the 2nd number: ", "Input the 2nd number",
        JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);
        
        double sum = num1 + num2;
        double dif = Math.abs(num1 - num2);
        double pro = num1*num2;
        double quo = num1/num2;


        JOptionPane.showMessageDialog(null, " Sum: "+ sum +"\n Difference: " +dif+"\n Production: "+ pro +"\n Quotient: "+quo,"Information of 2 numbers", JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);
    }
}
