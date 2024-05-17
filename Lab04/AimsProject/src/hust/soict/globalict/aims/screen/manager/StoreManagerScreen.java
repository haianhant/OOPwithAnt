package hust.soict.globalict.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.media.*;

public class StoreManagerScreen extends JFrame {
    private Store store;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStoreItem = new JMenuItem("View store");
        viewStoreItem.addActionListener(e -> new StoreManagerScreen(store));
        menu.add(viewStoreItem);

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> new AddBookToStoreScreen(store));
        smUpdateStore.add(addBookItem);

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> new AddCompactDiscToStoreScreen(store));
        smUpdateStore.add(addCDItem);

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store));
        smUpdateStore.add(addDVDItem);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.MAGENTA);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        int itemCount = Math.min(mediaInStore.size(), 9);
        for (int i = 0; i < itemCount; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        for (int i = itemCount; i < 9; i++) {
            center.add(new JPanel());
        }

        return center;
    }

    public class MediaStore extends JPanel {
        private Media media;

        public MediaStore(Media media) {
            this.media = media;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
            title.setAlignmentX(CENTER_ALIGNMENT);

            JLabel cost = new JLabel("" + media.getCost() + " $");
            cost.setAlignmentX(CENTER_ALIGNMENT);

            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));

            if (media instanceof Book) {
                JButton playButton = new JButton("Play");
                playButton.addActionListener(e -> showCannotPlayDialog());
                container.add(playButton);
            }
            else if (media instanceof Playable) {
                JButton playButton = new JButton("Play");
                playButton.addActionListener(e -> playMedia((Playable) media));
                container.add(playButton);
            } 

            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);

            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }

    private void playMedia(Playable media) {
        JDialog playDialog = new JDialog(this, "Playing Media", true);
        playDialog.setLayout(new BorderLayout());

        String title = media instanceof Media ? ((Media) media).getTitle() : "Unknown";
        int length = 0;
        if (media instanceof DigitalVideoDisc) {
            length = ((DigitalVideoDisc) media).getLength();
        } else if (media instanceof CompactDisc) {
            length = ((CompactDisc) media).getLength();
        }

        playDialog.add(new JLabel("Playing: " + title + " (Length: " + length + " minutes)"), BorderLayout.CENTER);

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> playDialog.dispose());
        playDialog.add(stopButton, BorderLayout.SOUTH);

        playDialog.setSize(300, 100);
        playDialog.setLocationRelativeTo(null);
        playDialog.setVisible(true);
    }

    private void showCannotPlayDialog() {
        JOptionPane.showMessageDialog(this, "Books cannot be played!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Store store = new Store();
        //Example
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f));
        store.addMedia(new Book("Harry Potter", "Fantasy", 29.5f));
        
        new StoreManagerScreen(store);
    }
}
