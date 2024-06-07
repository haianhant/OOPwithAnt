package hust.soict.globalict.test.screen.customer.store;

import hust.soict.globalict.aims.screen.customer.controller.CartController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class TestViewCartScreen extends Application {
	private static Cart cart;
	private static Store store;

	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Cart.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		CartController cartController = new CartController(cart);
		fxmlLoader.setController(cartController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();	
	}
	
	public static void main(String[] args) {
		cart = new Cart();
		store = new Store();
        
		Media book1 = new Book(1, "Effective Java", "Programming", 45.0f);
        ((Book) book1).addAuthor("Joshua Bloch");

        Media book2 = new Book(2, "Clean Code", "Programming", 42.0f);
        ((Book) book2).addAuthor("Robert C. Martin");

        Media book3 = new Book(3, "The Pragmatic Programmer", "Programming", 40.0f);
        ((Book) book3).addAuthor("Andrew Hunt");
        ((Book) book3).addAuthor("David Thomas");
		
		Media cd1 = new CompactDisc(4, "Abbey Road", "Music", "George Martin", "The Beatles", 47, 20.0f);

	    Media cd2 = new CompactDisc(5, "Thriller", "Pop", "Quincy Jones", "Michael Jackson", 42, 25.0f);

	    Media cd3 = new CompactDisc(6, "Dark Side of the Moon", "Rock", "Pink Floyd", "Pink Floyd", 43, 22.0f);

	    Media dvd1 = new DigitalVideoDisc(7, "The Godfather", "Crime", "Francis Ford Coppola", 175, 30.0f);

	    Media dvd2 = new DigitalVideoDisc(8, "The Shawshank Redemption", "Drama", "Frank Darabont", 142, 25.0f);

	    Media dvd3 = new DigitalVideoDisc(9, "Inception", "Science Fiction", "Christopher Nolan", 148, 28.0f);
		
        cart.addMedia(book1);
        cart.addMedia(book2);
        cart.addMedia(book3);
        cart.addMedia(cd1);
        cart.addMedia(cd2);
        cart.addMedia(cd3);
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        cart.viewCart();
        
        launch(args);
	}
	
}
