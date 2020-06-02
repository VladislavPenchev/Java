package OnlineRadioDatabase_05;

import OnlineRadioDatabase_05.exceptions.InvalidSongLengthException;
import OnlineRadioDatabase_05.exceptions.InvalidSongMinutesException;
import OnlineRadioDatabase_05.exceptions.InvalidSongSecondsException;

public class SongLength {
    private int minutes;
    private int seconds;

    public SongLength(String length) {
        this.parseSongLength(length);
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    private void setMinutes(int minutes) {
        if(minutes < 0 || minutes > 14){
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        this.minutes = minutes;
    }

    private void setSeconds(int seconds) {
        if(minutes < 0 || minutes > 59){
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.seconds = seconds;
    }

    private void parseSongLength(String length) {
        String[] lengthTokens = length.split(":");
        String minutes = lengthTokens[0];
        String seconds = lengthTokens[1];

        if(lengthTokens.length != 2 || !minutes.matches("\\d+") || !seconds.matches("\\d+")) {
            throw new InvalidSongLengthException("Invalid song length.");
        }

        int totalLength = this.getTotalSongLength(Integer.parseInt(minutes), Integer.parseInt(seconds));

        int minLength = 0;
        int maxLength = (14 * 60) + 59;

        if(totalLength < minLength|| totalLength > maxLength) {
            throw new InvalidSongLengthException("Invalid song length.");
        }

        this.setMinutes(Integer.parseInt(minutes));
        this.setSeconds(Integer.parseInt(seconds));
    }

    private int getTotalSongLength(int minutes, int seconds) {
        return (minutes * 60) + seconds;
    }
}
