package Java.OOP;
import javax.swing.*;
public class HelloNameDialog {
    public static void main(String[] args) {
        String results;
        results = JOptionPane.showInputDialog("Please enter your name: ");
        JOptionPane.showMessageDialog(null,"Hello " + results +"!");
        System.exit(0);
    }
}
