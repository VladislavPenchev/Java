package OnlineRadioDatabase_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfSongs = Integer.parseInt(reader.readLine());

        List<Song> playlist = new ArrayList<>();

        for (int i = 0; i < numberOfSongs; i++) {
            try{
                String[] songArgs = reader.readLine().split(";");
                String artistName = songArgs[0];
                String songName = songArgs[1];
                String songLengthAg = songArgs[2];
                Song song = new Song(artistName, songName);
                SongLength songLength = new SongLength(songLengthAg);
                song.setSongLength(songLength);

                playlist.add(song);
                System.out.println("Song added.");

            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        System.out.println(String.format("Songs added: %d",playlist.size()));

        int allMinutes = playlist.stream()
                .mapToInt(x ->x.getSongLength().getMinutes()).sum();

        int allSeconds = playlist.stream()
                .mapToInt(x ->x.getSongLength().getSeconds()).sum();

        allSeconds += allMinutes * 60;

        int hours = allSeconds / 3600;
        int minutes = (allSeconds % 3600) / 60;
        int seconds = allSeconds % 60;

        System.out.println(String.format("Playlist length: %dh %dm %ds", hours, minutes, seconds));
    }
}
