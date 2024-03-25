package Java.OOP.Lab01;

import javax.swing.JOptionPane;

public class exercise64 {
    public static void main(String[] args) {
        String month, strYear;
        month = JOptionPane.showInputDialog(null, "Please input a month (January, Jan., Jan, or 1):", "Number of days of a month",
        JOptionPane.INFORMATION_MESSAGE);
        strYear = JOptionPane.showInputDialog(null, "Please input a year ", "Number of days of a month",
        JOptionPane.INFORMATION_MESSAGE);
        double year = Double.parseDouble(strYear);
        switch (month) {
            case "January": case "Jan": case "Jan.": case "1":
            case "March" : case "Mar" : case "Mars": case "3":
            case "May" : case "5":
            case "July" : case "Jul": case "7":
            case "August" : case "Aug" : case "Aug.": case "8":
            case "October" : case "Oct" : case "Oct.": case "10":
            case "December" : case "Dec" : case "Dec.": case "12":
                JOptionPane.showMessageDialog(null, "The "+month+" month has 31 days");
                break;
            case "April" : case "Apr" : case "Apr.": case "4":
            case "June" : case "Jun" : case "6":
            case "September" : case "Sep" : case "Sept.": case "9":
            case "November" : case "Nov" : case "Nov.": case "11":
                JOptionPane.showMessageDialog(null, "The "+month+" month has 30 days");
                break;
            case "February" : case "Feb" : case "Feb.": case "2":
            if(year%4!=0){
                JOptionPane.showMessageDialog(null, "February has 28 days in the year "+year);
            }
            else{
                if((year%100==0)&&(year%400!=0)){
                    JOptionPane.showMessageDialog(null, "February has 28 days in the year "+year);
                }
                else{
                    JOptionPane.showMessageDialog(null, "February has 29 days in the year "+year);
                }
            }
            break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid month!");
                break;
        }
        System.exit(0);
    }
}
