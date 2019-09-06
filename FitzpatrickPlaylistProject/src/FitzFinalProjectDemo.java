import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class FitzFinalProjectDemo {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		KeyedList list = new KeyedList();
		
		keyboard.useDelimiter(System.getProperty("line.separator"));

		int numLines = 0;
		String fileName = " ";
		int j = 0;
		int k = 0;
		int x = 3;
		
		int deleteP = 0;
		boolean deletedP = false;
		
		boolean added = false;
		int key = -1;
		int index = 0;
		int playlistNum = 0;
		String pName = " ";
		int addToPlaylist = 0;
		int songCount = 0;
		
		String songName = " ";
		String songArtist = " ";
		String songAlbum = " ";
		String songTime;
		int songRunTime = 0;
		int songNum = 0;
		boolean songAdded = false;
	
		int playlistChoice = 0;
		int deleteSong = 0;
		
		int shufflePlaylist = 0;
		boolean shuffled = false;
		
		boolean quit = false;
		int quitButton = 0;
	
	//	System.out.println("Please enter a filename: ");
	//	fileName = keyboard.next();
		
		File myFile = new File("playlistmaker.txt");
		
		try {
			Scanner input = new Scanner(myFile);
			
			Playlist fileplay = new Playlist();
			
			pName = input.nextLine();
			fileplay.setPlaylistName(pName);
			fileplay.setPNum(1);
			
			while (j < 21) {
				songName = input.nextLine();
				songArtist = input.nextLine();
				songAlbum = input.nextLine();
				songTime = input.nextLine();
				songRunTime = Integer.parseInt(songTime);
				
				Song fileSong = new Song();
				
				fileSong.setName(songName);
				fileSong.setArtist(songArtist);
				fileSong.setAlbum(songAlbum);
				fileSong.setRunTime(songRunTime);
				fileSong.setNumber(j + 1);
				
				fileplay.addSong(fileSong);
				j++;
			} // while()
				
			Playlist workout = new Playlist();
			pName = input.nextLine();
			workout.setPlaylistName(pName);
			workout.setPNum(2);
						
			while (k < 3) {
				songName = input.nextLine();
				songArtist = input.nextLine();
				songAlbum = input.nextLine();
				songTime = input.nextLine();
				songRunTime = Integer.parseInt(songTime);
				
				Song fileSong = new Song();
				
				fileSong.setName(songName);
				fileSong.setArtist(songArtist);
				fileSong.setAlbum(songAlbum);
				fileSong.setRunTime(songRunTime);
				fileSong.setNumber(k + 1);
				
				workout.addSong(fileSong);
				k++;
			} // while()
			
				list.add(fileplay);
				list.add(workout);
				
				fileplay.setCount(j);
				workout.setCount(k);
				list.setSize(2);
		} // try
		catch (Exception f) {
			System.out.println("Something went wrong");
			System.out.println(j);
			System.out.println(k);
		} // catch
		
		System.out.println("Welcome to Connor's Music App!");
		
		while (key != 0) { 
			System.out.println("");
			System.out.println("Here are the things you can do");
			System.out.println("");
			System.out.println("1. Create a Playlist");
			System.out.println("2. Delete Playlist");
			System.out.println("3. Add Song to Playlist");
			System.out.println("4. Delete Song from Playlist");
			System.out.println("5. View Playlist");
			System.out.println("6. Shuffle Playlist");
			System.out.println("7. Get Info");
			System.out.println("8. Quit");
			System.out.println("");
		
			System.out.println("Type the number that corresponds to your desired action");
			key = keyboard.nextInt();
		
			switch (key) {
			case 1: 
				System.out.println("What would you like to name your playlist?");
				pName = keyboard.next();
				
				Playlist play = new Playlist();
				
				play.setPlaylistName(pName);
				play.setPNum(x);
				play.setCount(0);
				x++;
			
				added = list.add(play);
				if (added == false) {
					System.out.println("Maximum number of playlists exceeded");
				} // if()
				else {
					System.out.println("Playlist Created!");
				} // else()
				
				break;
				
			case 2: 
				for(int i = 0; i < list.getSize(); i++) {
					System.out.println((i + 1) + ". " + list.getPlaylists()[i].getPlaylistName());
				} // for()
				System.out.println();
				System.out.println("Which playlist would you like to delete. Press '0' to return to menu");
				deleteP = keyboard.nextInt();
				
				if ((deleteP != 0) && (deleteP <= list.getSize())) {
					deletedP = deletePlaylist(list, deleteP);
					list.setSize(list.getSize() - 1);
					System.out.println();
					System.out.println("Playlist Deleted!");
				} // if()
				else if (deleteP == 0) {
					System.out.println();
				} // else if()
				else {
					System.out.println();
					System.out.println("Invalid playlist number");
				} // else()
				break;
				
			case 3:
				System.out.println("You have created the following playlists");
				
				for(int i = 0; i < list.getSize(); i++) {
					System.out.println((i + 1) + ". " + list.getPlaylists()[i].getPlaylistName());
				} // for()
				
				System.out.println("Which playlist number would you like to add a song to? Enter '0' to return to menu");
				addToPlaylist = keyboard.nextInt();
				
				if ((addToPlaylist != 0) && (addToPlaylist <= list.getSize())) {
					index = addToPlaylist - 1;
				
						if (list.getPlaylists()[index].isFull() == true) {
							System.out.println("Error: Maximum number of songs on this playlist exceeded");
						} // if()
						else {
							System.out.println("What is the name of the song that you are trying to add?");
							songName = keyboard.next();
							System.out.println("Who is the artist of that song?");
							songArtist = keyboard.next();
							System.out.println("What album does it appear on?");
							songAlbum = keyboard.next();
							System.out.println("How many seconds long is the song?");
							songRunTime = keyboard.nextInt();
							songNum = (list.getPlaylists()[index].getCount() + 1);
				
							Song hymn = new Song(songName, songArtist, songAlbum, songRunTime, songNum);
							songAdded = list.getPlaylists()[index].addSong(hymn);
						
							System.out.println("Song Added Successfully!");
						} // else()
				} // if()
				else if (addToPlaylist == 0) {
					System.out.println("");
				} // else if()
				else {
					System.out.println();
					System.out.println("Invalid Playlist Number");
				} // else()
				
				break;
			case 4: 
				System.out.println("You have created the following playlists");
				
				for(int i = 0; i < list.getSize(); i++) {
					System.out.println((i + 1) + ". " + list.getPlaylists()[i].getPlaylistName());
				} // for()
				
				System.out.println("Which playlist number would you like to delete a song from? Enter a '0' to return to menu");
				playlistChoice = keyboard.nextInt();
				
				if ((playlistChoice != 0) && (playlistChoice <= list.getSize())) {
					
				
					int num = playlistChoice - 1;
				
					for (int i = 0; i < list.getPlaylists()[num].getCount(); i++) {
						System.out.println();
						System.out.println("Song Number: " + list.getPlaylists()[num].getSongs()[i].getNumber());
						System.out.println("Song Name: " + list.getPlaylists()[num].getSongs()[i].getName());
						System.out.println("Artist: " + list.getPlaylists()[num].getSongs()[i].getArtist());
						System.out.println("Album: " + list.getPlaylists()[num].getSongs()[i].getAlbum());
						System.out.println("Runtime: " + list.getPlaylists()[num].getSongs()[i].getRunTime());
					} // for()
					
					System.out.println();
					System.out.println("Which song number would you like to delete? Enter '0' to return to menu");
					deleteSong = keyboard.nextInt();
					
					System.out.println("");
					System.out.println("Song Deleted!");
					
					if ((deleteSong != 0) && (deleteSong <= list.getPlaylists()[num].getCount())) {
						deleteSong = deleteSong - 1;
			//			songExists = lisit.getPlaylists()[index].songExists(deleteSong);
					
						boolean deleted = false;
						deleted = deleteSong(list, playlistChoice, deleteSong);
						list.getPlaylists()[playlistChoice -1].setCount(list.getPlaylists()[playlistChoice -1].getCount() -1);
					} // if()
					else if (deleteSong == 0) {
						System.out.println("");
					} // else if()
					else {
						System.out.println("");
						System.out.println("Invalid song number");
					} // else()
				} // if()
				else if (playlistChoice == 0) {
					System.out.println("");
				} // else if()
				else {
					System.out.println("");
					System.out.println("Invalid playlist number");
				} // else()
				
				break;
			case 5:
				System.out.println("You have created the following playlists");
				for(int i = 0; i < list.getSize(); i++) {
					System.out.println((i + 1) + ". " + list.getPlaylists()[i].getPlaylistName());
				} // for()
				System.out.println();
				System.out.println("Enter the number that corresponds to the playlist you want to see the contents of. Enter '0' to return to menu");
				playlistChoice = keyboard.nextInt();
				
				if ((playlistChoice != 0) && (playlistChoice <= list.getSize())) {
					System.out.println();
					System.out.println("Playlist: " + list.getPlaylists()[playlistChoice - 1].getPlaylistName());
				
					for (int i = 0; i < list.getPlaylists()[playlistChoice - 1].getCount(); i++) {
						System.out.println();
						System.out.println("Song Number: " + list.getPlaylists()[playlistChoice - 1].getSongs()[i].getNumber());
						System.out.println("Song Name: " + list.getPlaylists()[playlistChoice - 1].getSongs()[i].getName());
						System.out.println("Artist: " + list.getPlaylists()[playlistChoice - 1].getSongs()[i].getArtist());
						System.out.println("Album: " + list.getPlaylists()[playlistChoice - 1].getSongs()[i].getAlbum());
						System.out.println("Runtime: " + list.getPlaylists()[playlistChoice - 1].getSongs()[i].getRunTime());
					} // for()
				} // if()
				else if ((playlistChoice == 0)) {
					System.out.println("");
				}
				else {
					System.out.println("");
					System.out.println("Invalid playlist number");
				} // else()
				break;
			case 6:
				// Shuffle Playlist
				for (int b = 0; b < list.getSize(); b++) {
					System.out.println((b + 1) + ". " + list.getPlaylists()[b].getPlaylistName());
				} // for
				System.out.println();
				System.out.println("Which playlist number would you like to shuffle? Enter a '0' to return to menu");
				shufflePlaylist = keyboard.nextInt();
				
				if ((shufflePlaylist != 0) && shufflePlaylist <= list.getSize()) {
					shuffled = shuffler(list, shufflePlaylist);
				} // if()
				else if (shufflePlaylist == 0) {
					System.out.println();
				} // else if()
				else {
					System.out.println();
					System.out.println("Invalid Playlist Number");
				} // else()
				
				break;
				
			case 7:
				// Info
				int longsIndex = 0;
				int longpIndex = 0;
				
				int shortsIndex = 0;
				int shortpIndex = 1000;
				
				int largestPlaylist = 0;
				int smallestPlaylist = 1000;
				
				int currMaxSong = 0;
				int currMinSong = 1000;
				int currMaxPlaylist = 0;
				int currMinPlaylist = 1000;
				
				for (int i = 0; i < list.getSize(); i++) {
					for (int e = 0; e < list.getPlaylists()[i].getCount(); e++) {
						if (list.getPlaylists()[i].getCount() > currMaxPlaylist) {
							currMaxPlaylist = list.getPlaylists()[i].getCount();
							largestPlaylist = i;
						} // if()
						
						if (list.getPlaylists()[i].getCount() < currMinPlaylist) {
							currMinPlaylist = list.getPlaylists()[i].getCount();
							smallestPlaylist = i;
						} // if()
						
						if (list.getPlaylists()[i].getSongs()[e].getRunTime() > currMaxSong) {
							currMaxSong = list.getPlaylists()[i].getSongs()[e].getRunTime();
							longsIndex = e;
							longpIndex = i;
						} // if()
						
						if (list.getPlaylists()[i].getSongs()[e].getRunTime() < currMinSong) {
							currMinSong = list.getPlaylists()[i].getSongs()[e].getRunTime();
							shortsIndex = e;
							shortpIndex = i;
						} // if()
					} // for()
				} // for()
				
				System.out.println("Longest Song: " + list.getPlaylists()[longpIndex].getSongs()[longsIndex].getName());
				System.out.println("Length: " + list.getPlaylists()[longpIndex].getSongs()[longsIndex].getRunTime() + " Seconds");
				System.out.println();
				System.out.println("Shortest Song: " + list.getPlaylists()[shortpIndex].getSongs()[shortsIndex].getName());
				System.out.println("Length: " + list.getPlaylists()[shortpIndex].getSongs()[shortsIndex].getRunTime() + " Seconds");
				System.out.println();
				System.out.println("Largest Playlist: " + list.getPlaylists()[largestPlaylist].getPlaylistName());
				System.out.println("Number of Songs: " + list.getPlaylists()[largestPlaylist].getCount());
				System.out.println();
				System.out.println("Smallest Playlist: " + list.getPlaylists()[smallestPlaylist].getPlaylistName());
				System.out.println("Number of Songs: " + list.getPlaylists()[smallestPlaylist].getCount());
				
				break;
				
			case 8:
				System.out.println("Are you sure you would like to quit?");
				System.out.println();
				System.out.println("Enter '0' if you are sure you want to quit");
				System.out.println("Enter any other integer to stay on program");
				
				quitButton = keyboard.nextInt();
				
				if (quitButton == 0) {
					key = 0;
				} // if
				
				break;
			} // switch
		} // while()
	} // main()
	
	public static boolean deleteSong(KeyedList list, int playlist, int index) {
		boolean deleted = false;
		int  i = 0;
		int j = 0;
			
			list.getPlaylists()[playlist -1].getSongs()[index].setNumber(0);
			list.getPlaylists()[playlist -1].getSongs()[index].setName(" ");
			list.getPlaylists()[playlist -1].getSongs()[index].setArtist(" ");
			list.getPlaylists()[playlist -1].getSongs()[index].setAlbum(" ");
			list.getPlaylists()[playlist -1].getSongs()[index].setRunTime(0);
		
		int limit = list.getPlaylists()[playlist -1].getCount();
		
		
			list.getPlaylists()[playlist -1].getSongs()[index] = null;
			for (j = index; j < limit -1; j++) {
				if (index != limit - 1) {
					list.getPlaylists()[playlist -1].getSongs()[j] = list.getPlaylists()[playlist -1].getSongs()[j + 1];
					list.getPlaylists()[playlist -1].getSongs()[j].setNumber(list.getPlaylists()[playlist -1].getSongs()[j].getNumber()-1);
				} // if()
				else {
					list.getPlaylists()[playlist -1].getSongs()[j] = null;
				} // else()
			} // for()
		
		return deleted;
	} // deleteSong
	
	public static boolean deletePlaylist(KeyedList list, int playlist) {
		boolean deleted = false;
		int i = 0;
		int j = 0;
		
		int limit = list.getSize();
		
		
			list.getPlaylists()[playlist -1] = null;
			
			for (j = playlist - 1; j < limit -1; j++) {
				if ((playlist - 1) != limit - 1) {
					list.getPlaylists()[j] = list.getPlaylists()[playlist];
					list.getPlaylists()[j].setPNum(list.getPlaylists()[playlist].getPNum()-1);
				} // if()
				else {
					list.getPlaylists()[playlist -1] = null;
				} // else()
			} // for()
		
		deleted = true;
			
		return deleted;
	} // deleteSong
	
	public static boolean shuffler(KeyedList list, int shuffle) {
		Random rnd = ThreadLocalRandom.current();
		int length = list.getPlaylists()[shuffle -1].getCount();

		for (int i = 0; i < length - 1; i++) {
			int index = rnd.nextInt(length);
			
			Song temp = list.getPlaylists()[shuffle - 1].getSongs()[index];
			list.getPlaylists()[shuffle - 1].getSongs()[index] = list.getPlaylists()[shuffle - 1].getSongs()[i];
			list.getPlaylists()[shuffle - 1].getSongs()[i] = temp;
		} // for()
			
		for (int j = 0; j < length; j++) {
			list.getPlaylists()[shuffle - 1].getSongs()[j].setNumber(j + 1);
		} // for()
		
		return true;
	} // shuffler()
} // FitzFinalProjectDemo
