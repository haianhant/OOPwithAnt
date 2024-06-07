package hust.soict.globalict.test.screen.customer.store;

import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

public class TestViewStoreScreen extends Application {
	private static Store store = new Store();

	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();	
	}
	
	public static void main(String[] args) {
		
        Media book1 = new Book(1, "Effective Java", "Programming", 45.0f);
        ((Book) book1).addAuthor("Joshua Bloch");

        Media book2 = new Book(2, "Clean Code", "Programming", 42.0f);
        ((Book) book2).addAuthor("Robert C. Martin");

        Media book3 = new Book(3, "The Pragmatic Programmer", "Programming", 40.0f);
        ((Book) book3).addAuthor("Andrew Hunt");
        ((Book) book3).addAuthor("David Thomas");
		
		Media cd1 = new CompactDisc(4, "Abbey Road", "Music", "George Martin", "The Beatles", 47, 20.0f);
		((CompactDisc) cd1).addTrack(new Track("Come Together", 259));
        ((CompactDisc) cd1).addTrack(new Track("Something", 183));
        ((CompactDisc) cd1).addTrack(new Track("Maxwell's Silver Hammer", 207));
        ((CompactDisc) cd1).addTrack(new Track("Oh! Darling", 207));
        ((CompactDisc) cd1).addTrack(new Track("Octopus's Garden", 175));
		Media cd2 = new CompactDisc(5, "Thriller", "Pop", "Quincy Jones", "Michael Jackson", 42, 25.0f);
		((CompactDisc) cd2).addTrack(new Track("Wanna Be Startin' Somethin'", 362));
        ((CompactDisc) cd2).addTrack(new Track("Baby Be Mine", 0));
        ((CompactDisc) cd2).addTrack(new Track("The Girl Is Mine", 228));
        ((CompactDisc) cd2).addTrack(new Track("Thriller", 357));
        ((CompactDisc) cd2).addTrack(new Track("Beat It", 258));

	    Media cd3 = new CompactDisc(6, "Dark Side of the Moon", "Rock", "Pink Floyd", "Pink Floyd", 43, 22.0f);
	    ((CompactDisc) cd3).addTrack(new Track("Speak to Me", 90));
        ((CompactDisc) cd3).addTrack(new Track("Breathe", 163));
        ((CompactDisc) cd3).addTrack(new Track("On the Run", 216));
        ((CompactDisc) cd3).addTrack(new Track("Time", 407));
        ((CompactDisc) cd3).addTrack(new Track("The Great Gig in the Sky", 276));

	    Media dvd1 = new DigitalVideoDisc(7, "The Godfather", "Crime", "Francis Ford Coppola", 175, 30.0f);

	    Media dvd2 = new DigitalVideoDisc(8, "The Shawshank Redemption", "Drama", "Frank Darabont", 0, 25.0f);

	    Media dvd3 = new DigitalVideoDisc(9, "Inception", "Science Fiction", "Christopher Nolan", 148, 28.0f);
		
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        
        store.viewstore();
        launch(args);
	}
	
}
