package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media implements Playable {
		private List<String> authors = new ArrayList<String>();

		public void addAuthor(String authorName) {
			if (!this.authors.contains(authorName)) {
				this.authors.add(authorName);
			}
			
		}
		
		public void removeAuthor(String authorName) {
			if (this.authors.contains(authorName)) {
				this.authors.remove(authorName);
			}
		}

		public Book(String title, String category, float cost) {
	        super();
	        this.title = title;
	        this.category = category;
	        this.cost = cost;
	    }
		
	    @Override
	    public String toString() {
	    	return ". Book - " + this.getTitle() + " - " +
		    this.getCategory() +  " : " + this.getCost() + "$";
	    }

		@Override
		public void play() {
			System.out.println("The method is invalid in this type of media");
		}
}

