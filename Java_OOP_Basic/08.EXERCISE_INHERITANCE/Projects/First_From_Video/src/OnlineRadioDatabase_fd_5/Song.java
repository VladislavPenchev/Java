package OnlineRadioDatabase_fd_5;

import OnlineRadioDatabase_fd_5.Constants.ExceptionConstants;
import OnlineRadioDatabase_fd_5.Exceptions.InvalidArtistNameException;

public class Song {
    private String artistName;
    private String songName;
    private SongLength songLength;

    public Song(String artistName, String songName) {
        this.setArtistName(artistName);
        this.setSongName(songName);
    }

    private void setArtistName(String artistName) {
        if(artistName.length() < 3 || artistName.length() > 20)
            throw new InvalidArtistNameException(ExceptionConstants.INVALID_SONG_ARTIST_NAME_EXCEPTION_MESSAGE);
        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if(songName.length() < 3 || songName.length() > 20)
            throw new InvalidArtistNameException(ExceptionConstants.INVALID_SONG_NAME_EXCEPTION_MESSAGE);
        this.songName = songName;
    }

    public SongLength getSongLength() {
        return this.songLength;
    }

    public void setSongLength(SongLength songLength) {
        this.songLength = songLength;
    }
}
