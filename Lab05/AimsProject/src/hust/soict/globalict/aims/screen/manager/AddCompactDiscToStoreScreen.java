package hust.soict.globalict.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.media.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);

        JPanel director = super.createSubPanel("Director");
        JPanel length = super.createSubPanel("Length");
        JPanel artist = super.createSubPanel("Artist");

        super.centerPanel.add(director);
        super.centerPanel.add(length);
        super.centerPanel.add(artist);

        btnAdd.addActionListener(new btnAddListener());
        super.setTitle("Add Compact Disc");
        super.setVisible(true);  
    }

    private class btnAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = null, category = null, director = null, artist = null;
            int id = 0;
            float cost = 0;
            int length = 0;

            try {
                for (JTextField tf : tfs) {
                    switch (tf.getName()) {
                        case "ID":
                        	id = Integer.parseInt(tf.getText());
                            break;
                        case "Title":
                            title = tf.getText();
                            break;
                        case "Category":
                            category = tf.getText();
                            break;
                        case "Director":
                            director = tf.getText();
                            break;
                        case "Artist":
                            artist = tf.getText();
                            break;
                        case "Length":
                            length = Integer.parseInt(tf.getText());
                            break;
                        case "Cost":
                            cost = Float.parseFloat(tf.getText());
                            break;
                    }
                }

                CompactDisc cd = new CompactDisc(id, title, category, director, artist, length, cost);
                store.addMedia(cd);

                JOptionPane.showMessageDialog(null, "Compact Disc added successfully!");
                new StoreManagerScreen(store);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid number format for length or cost", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error adding Compact Disc: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
