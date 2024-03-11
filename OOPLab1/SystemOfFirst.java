package Java.OOP.OOPLab1;

import javax.swing.JOptionPane;

public class SystemOfFirst {
    public static void main(String[] args) {
        String stra11, stra12, stra21, stra22, strb1, strb2;
        double x1 = 0.0;
        double x2 = 0.0;
        stra11 = JOptionPane.showInputDialog(null, "Please input a11: ", "Solve the system a11x1 + a12x2 = b1 \n a21x1 + a22x2 = b2",
        JOptionPane.INFORMATION_MESSAGE);
        double a11 = Double.parseDouble(stra11);
        
        stra12 = JOptionPane.showInputDialog(null, "Please input a12: ", "Solve the system a11x1 + a12x2 = b1 \n a21x1 + a22x2 = b2",
        JOptionPane.INFORMATION_MESSAGE);
        double a12 = Double.parseDouble(stra12);
        
        strb1 = JOptionPane.showInputDialog(null, "Please input b1: ", "Solve the system a11x1 + a12x2 = b1 \n a21x1 + a22x2 = b2",
        JOptionPane.INFORMATION_MESSAGE);
        double b1 = Double.parseDouble(strb1);

        stra21 = JOptionPane.showInputDialog(null, "Please input a21: ", "Solve the system a11x1 + a12x2 = b1 \n a21x1 + a22x2 = b2",
        JOptionPane.INFORMATION_MESSAGE);
        double a21 = Double.parseDouble(stra21);

        stra22 = JOptionPane.showInputDialog(null, "Please input a22: ", "Solve the system a11x1 + a12x2 = b1 \n a21x1 + a22x2 = b2",
        JOptionPane.INFORMATION_MESSAGE);
        double a22 = Double.parseDouble(stra22);

        strb2 = JOptionPane.showInputDialog(null, "Please input b2: ", "Solve the system a11x1 + a12x2 = b1 \n a21x1 + a22x2 = b2",
        JOptionPane.INFORMATION_MESSAGE);
        double b2 = Double.parseDouble(strb2);

        double d = a11*a22 - a21*a12;
        double d1 = b1*a22 - b2*a12;
        double d2 = a11*b2 - a21*b1;

        if(d!=0){
            x1 = d1/d;
            x2 = d2/d;
            JOptionPane.showMessageDialog(null, "The system of equation has unique solution: \n x1 = "+x1+"\n x2 = "+x2+"\n");
        }
        else{
            if(((a11/a21) == (a12/a22)) && ((a11/a21) == (b1/b2))){
                JOptionPane.showMessageDialog(null, "The system of equation has infinitely many solutions!");
            }
            else JOptionPane.showMessageDialog(null, "The system of equation has no solution!");
        }
    }
}
