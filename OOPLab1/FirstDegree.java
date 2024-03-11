package Java.OOP.OOPLab1;

import javax.swing.JOptionPane;
public class FirstDegree {
    public static void main(String[] args) {
        String strNum1, strNum2;
        double solution = 0.0;
        strNum1 = JOptionPane.showInputDialog(null, "Please input a: ", "Solve ax + b = 0",
        JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null, "Please input b: ", "Solve ax + b = 0",
        JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);
        if(num1==0){
            if(num2==0){
                JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions");
            }
            else {
                JOptionPane.showMessageDialog(null, "The equation has no solution");
            }
        }
        else {
                solution = -num2/num1;
                JOptionPane.showMessageDialog(null, "The equation has a solution: "+solution+"\n");
        }
        System.exit(0);
    }
}
