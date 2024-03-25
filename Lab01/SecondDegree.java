package Java.OOP.Lab01;

import javax.swing.JOptionPane;
import java.lang.Math;
public class SecondDegree {
    public static void main(String[] args) {
        String strNum1, strNum2, strNum3;
        double solution = 0.0;
        double delta = 0.0;
        double root1 = 0.0;
        double root2 = 0.0;
        strNum1 = JOptionPane.showInputDialog(null, "Please input a: ", "Solve second-degree equation",
        JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null, "Please input b: ", "Solve second-degree equation",
        JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(strNum2);
        strNum3 = JOptionPane.showInputDialog(null, "Please input c: ", "Solve second-degree equation",
        JOptionPane.INFORMATION_MESSAGE);
        double c = Double.parseDouble(strNum3);

        if(a==0){
            if(b==0){
                if(c==0){
                    JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The equation has no solution");
                }
            }
            else{
                solution = -c/b;
                JOptionPane.showMessageDialog(null, "The equation has a solution: "+solution+"\n");
            }
        }
        else{
            delta = b*b - 4*a*c;
            if(delta > 0){
                root1 = (-b-Math.sqrt(delta))/(2*a);
                root2 = (-b+Math.sqrt(delta))/(2*a);
                JOptionPane.showMessageDialog(null, "The equation has two distinct solutions: \n x1 = "+root1+"\n x2 = "+root2+"\n");
            }
            else if(delta == 0){
                root1 = -b/(2*a);
                root2 = root1;
                JOptionPane.showMessageDialog(null, "The equation has one real root: \n "+root1+"\n");
            }
            else{
                JOptionPane.showMessageDialog(null, "The equation has no solution");
            }
        }
        System.exit(0);
    }
}
