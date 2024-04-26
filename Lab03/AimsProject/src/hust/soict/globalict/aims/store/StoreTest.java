package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class StoreTest {
	public static void main(String[] args) {
	//Create a new Cart
        Store anOrder =  new Store();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas",87,24.95f);
        anOrder.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDVD(dvd3);
        anOrder.viewstore();
        //remove dvd3
        anOrder.removeDVD(dvd3);
        System.out.println("The store after removing dvd3");
        anOrder.viewstore();
	}
}
