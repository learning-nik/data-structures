package com.design.pattern.structural;

// https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
// Can be used in controllers where adaptor can be used to convert response from json to xml
public class AdapterDesign {

	public static void main(String[] args) {

		new AdapterDesign().testDesign();

	}

	private void testDesign() {

		Adaptor adaptor = new Adaptor(new MP3MusicPlayer());
		OldMusicPlayer oldMusicPlayer = new OldMusicPlayer(adaptor);
		oldMusicPlayer.playMusicInMP3Format();
		oldMusicPlayer.playMusic();

	}

	// Old Music Player is there OldMusicPlayer.java which plays songs in old format
	// We want songs to be played in new format(MP3) format.
	// We don't want our old implementation to be modified but needs to be extended.
	// Create new Class implementation for Mp3 format.
	// Create a adapter between MP3 format and OldFormat
	// Adapter sits between MP3MusicPlayer.java and  OldMusicPlayer.java

	abstract class BasicMusicPlayer {

		abstract void playMusic();

	}

	class MP3MusicPlayer extends BasicMusicPlayer {

		@Override
		void playMusic() {
			System.out.println("Play Music in MP3 FORMAT");

		}

	}

	class Adaptor extends BasicMusicPlayer {
		private BasicMusicPlayer musicPlayer;

		public Adaptor(BasicMusicPlayer musicPlayer) {
			this.musicPlayer = musicPlayer;

		}

		@Override
		void playMusic() {
			musicPlayer.playMusic();
		}

	}

	class OldMusicPlayer extends BasicMusicPlayer {

		private Adaptor adaptor;

		public OldMusicPlayer(Adaptor adaptor) {
			this.adaptor = adaptor;
		}

		@Override
		void playMusic() {
			System.out.println("Play Music in OLD FORMAT");
		}

		void playMusicInMP3Format() {
			adaptor.playMusic();
		}

	}
}
