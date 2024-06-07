package hust.soict.globalict.aims.media;
import hust.soict.globalict.aims.exception.PlayerException;
public class Track implements Playable {
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	public Track(String title, int length) {
	    this.title = title;
	    this.length = length;
	}
	public Track() {
	}

	@Override
	public String play() throws PlayerException {
		if (length <= 0) {
            throw new PlayerException("ERROR: Track length is non-positive");
        }
		String result = "";
		StringBuffer stringBuffer = new StringBuffer();
		// TODO Auto-generated method stub
		stringBuffer.append("Playing DVD: ");
		stringBuffer.append(this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		return result;
	}
	
	public boolean equals(Track track) {
		return (this.title == track.title) && (this.length == track.length );
	}
}
