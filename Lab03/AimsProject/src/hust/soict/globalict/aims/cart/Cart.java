package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
    public void addMedia(Media media) {
    	this.itemsOrdered.add(media);
    }
    
    public Media findMediaByTitle(String title) {
    	for (Media m:itemsOrdered) {
    		if (m.getTitle().compareTo(title) == 0) {
    			return m;
    		} 
    	}
    	return null;
    }
    
    public void removeMedia(String title) {
    	if (findMediaByTitle(title) != null ) {
    		itemsOrdered.remove(findMediaByTitle(title));
    		System.out.println("Delete Item From Cart Successfully");
    	}
    }
    
    public void filterByTitle(String title) {
    	for (Media m: itemsOrdered) {
    		if (m.getTitle().contains(title)) {
    			System.out.println(m.toString());
    		}
    	}
    }
    
    public void sortByTitle() {
    	Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST );
    }
    
    public void sortByCost() {
    	Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE );
    }
    
    public void clearList() {
    	this.itemsOrdered.clear();
    }


    public float totalCost(){
        float sum = 0;
        for(Media media: itemsOrdered){
            sum += media.getCost(); 
        }
        return sum;
    }
    
    public int getLength(){
        return this.itemsOrdered.size();
    }
    
    public void viewCart() {
    	for (Media item:itemsOrdered ) {
    		System.out.println(item.toString());
    	}
    }
   
}