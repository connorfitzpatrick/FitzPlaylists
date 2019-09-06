
public class Song {
	private String name;
	private String artist;
	private String album;
	private int runTime;
	private int number;
	
	public Song() {
		name = " ";
		artist = " ";
		album = " ";
		runTime = 0;
		number = 0;
	} // Song()
	
	public Song(String newName, String newArtist, String newAlbum, int newRunTime, int newNumber) {
		name = newName;
		artist = newArtist;
		album = newAlbum;
		runTime = newRunTime;
		number = newNumber;
	} // Song()
	
	public void setName(String newName) {
		name = newName;
	} // setName()
	
	public void setArtist(String newArtist) {
		artist = newArtist;
	} // setArtist()

	public void setAlbum(String newAlbum) {
		album = newAlbum;
	} // setAlbum()
	
	public void setRunTime(int newRunTime) {
		runTime = newRunTime;
	} // setRunTime()
	
	public void setNumber(int newNumber) {
		number = newNumber;
	} // setNumber()
	
	public String getName() {
		return name;
	} // getName()

	public String getArtist() {
		return artist;
	} // getArtist()
	
	public String getAlbum() {
		return album;
	} // getAlbum()
	
	public int getRunTime() {
		return runTime;
	} // getRunTime()
	
	public int getNumber() {
		return number;
	} // getNumber()
} // Song
