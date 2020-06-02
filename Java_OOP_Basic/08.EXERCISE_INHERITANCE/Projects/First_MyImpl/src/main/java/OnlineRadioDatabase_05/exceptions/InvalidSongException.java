package OnlineRadioDatabase_05.exceptions;

public class InvalidSongException extends IllegalArgumentException{

    public InvalidSongException(String message){
        super(message);
    }
}
