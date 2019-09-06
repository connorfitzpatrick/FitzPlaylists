
public class Playlist {
	private Song mySongs[];
	private String playlistName;
	private int count;
	private int pNum;
	
	public Playlist() {
		
		mySongs = new Song[21];
		
		for (count = 0; count < 21; count++) {
			mySongs[count] = null;
		} // for
		
		playlistName = "No Name";
	
		count = 0;
	} // Playlist()
	
	public Playlist(String newPlaylistName, int newPNum) {
		playlistName = newPlaylistName;
		pNum = newPNum;
	} // Playlist()
	
	public void setPlaylistName(String newPlaylistName) {
		playlistName = newPlaylistName;
	} // setPlaylistName()
	
	public void setPNum(int newPNum) {
		pNum = newPNum;
	} // setPNum()
	
	public String getPlaylistName() {
		return playlistName;
	} // getPlaylistName()
	
	public void setCount(int newCount) {
		count = newCount;
	} // setCount()
	
	public int getCount() {
		return count;
	} // getCount()
	
	public Song[] getSongs() {
		return mySongs;
	} // getSongs()
	
	public int getPNum() {
		return pNum;
	} // getPNum()
	
	public boolean isFull() {
		boolean full = false;
				
		if (count == 21) {
			full = true;
		} // if()
		
		return full;
	} // isFull()
	
	public boolean addSong(Song jingle) {
		boolean added = false;
		
		if (count < 21) {
			mySongs[count] = jingle;
			count++;
			added = true;
		} // if
		
		return added;
	} // addSong()

} // Playlist
