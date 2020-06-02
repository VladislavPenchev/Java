package OnlineRadioDatabase_05;

import OnlineRadioDatabase_05.exceptions.InvalidArtistNameException;
import OnlineRadioDatabase_05.exceptions.InvalidSongNameException;

public class Song {
    private String artistName;
    private String songName;
    private SongLength songLength;

    public Song(String artistName, String songName) {
        this.setArtistName(artistName);
        this.setSongName(songName);
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        if(artistName.length() < 3 || artistName.length() > 20){
            throw  new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        if(songName.length() < 3 || songName.length() > 30) {
            throw  new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    public SongLength getSongLength() {
        return songLength;
    }

    public void setSongLength(SongLength songLength) {
        this.songLength = songLength;
    }
}
