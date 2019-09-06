import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class KeyedList {
	// instance variables
			private Playlist myPlaylists[];
			private int mySize;
			
			public KeyedList() {
				myPlaylists = new Playlist[6];
				
				for (mySize = 0; mySize < 6; mySize++) {
					myPlaylists[mySize] = null;
				} // for
				mySize = 0;
			} // KeyedList()
			
			public void setSize(int newSize) {
				mySize = newSize;
			} // setSize()
			
			public int getSize() {
				return mySize;
			} // getSize()
			
			public Playlist[] getPlaylists() {
				return myPlaylists;
			} // getPlaylists()
			
			public int getIndex(String playlistName) {
				int i = 0;
				int index = -1;
			
				for (i = 0; i < mySize; i++) {
					if (myPlaylists[i].getPlaylistName().equals(playlistName)) {
						index = i;
					} // if()
				} // for()
				
				return index;
			} // getIndex()
					
			public boolean add(Playlist newPlaylist) {
				boolean added = false;
				
				if (mySize < 7) {
					myPlaylists[mySize] = newPlaylist;
					added = true;
					mySize++;
				} // if()
				
				return added;
			} // add()	
} // KeyedList
