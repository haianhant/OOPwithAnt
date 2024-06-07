package hust.soict.globalict.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.media.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store);

        JPanel authors = super.createSubPanel("Authors");

        super.centerPanel.add(authors);

        btnAdd.addActionListener(new btnAddListener());
        super.setTitle("Add Book");
        super.setVisible(true);  
    }

    private class btnAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = null, category = null, authorsText = null;
            int id = 0;
            float cost = 0;

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
                        case "Cost":
                            cost = Float.parseFloat(tf.getText());
                            break;
                        case "Authors":
                            authorsText = tf.getText();
                            break;
                    }
                }

                Book book = new Book(id, title, category, cost);
                if (authorsText != null) {
                    String[] authorsArray = authorsText.split(",");
                    for (String author : authorsArray) {
                        book.addAuthor(author.trim());
                    }
                }
                store.addMedia(book);

                JOptionPane.showMessageDialog(null, "Book added successfully!");
                new StoreManagerScreen(store);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid number format for cost", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error adding book: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}


