package hust.soict.globalict.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame{
	private JButton[] btnNumbers = new JButton[10];
	private JButton btnDelete, btnReset;
	private JTextField tfDisplay;
	private Font customFont;
	
	public NumberGrid() {
		customFont = new Font("Times New Roman", Font.PLAIN, 14);
		
		tfDisplay = new JTextField();
		tfDisplay.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tfDisplay.setFont(customFont);
		
		JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(tfDisplay, BorderLayout.NORTH);
		cp.add(panelButtons, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Number Grid");
		setSize(200, 200);
		setVisible(true);
	}
	
	void addButtons(JPanel panelButtons) {
		ButtonListener btnListener = new ButtonListener();
		for(int i = 1; i<=9; i++) {
			btnNumbers[i] = new JButton(""+i);
			btnNumbers[i].setFont(customFont);
			panelButtons.add(btnNumbers[i]);
			btnNumbers[i].addActionListener(btnListener);
		}
		
		btnDelete =  new JButton("DEL");
		btnDelete.setFont(customFont);
		panelButtons.add(btnDelete);
		btnDelete.addActionListener(btnListener);
		
		btnNumbers[0] = new JButton("0");
		btnNumbers[0].setFont(customFont);
		panelButtons.add(btnNumbers[0]);
		btnNumbers[0].addActionListener(btnListener);
		
		btnReset = new JButton("C");
		btnReset.setFont(customFont);
		panelButtons.add(btnReset);
		btnReset.addActionListener(btnListener);
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if(button.charAt(0) >= '0' && button.charAt(0) <= '9') {
				tfDisplay.setText(tfDisplay.getText() + button);
			}
			else if (button.equals("DEL")) {
				//handels the "DEL" case: delete the last digits
				String text = tfDisplay.getText();
                if (text.length() > 0) {
                    text = text.substring(0, text.length() - 1);
                    tfDisplay.setText(text);
                }
			}
			else {
				//handles the "C" case: clears all digits
				tfDisplay.setText("");
			}
		}
	}
	 public static void main(String[] args) {
	        new NumberGrid();
	 }
}
