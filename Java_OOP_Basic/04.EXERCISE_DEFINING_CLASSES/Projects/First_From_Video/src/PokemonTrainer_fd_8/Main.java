package PokemonTrainer_fd_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Trainer, List<Pokemon>> inputMapTrainerPokemons = new LinkedHashMap<>();

        List<Pokemon> pokemons = new ArrayList<>();

        String line;
        while (!"Tournament".equals(line = reader.readLine())) {
            String[] arg = line.split("\\s+");

            String trainerName = arg[0];
            String pokemonName = arg[1];
            String pokemonElement = arg[2];
            String pokemonHealth = arg[3];

            Pokemon pokemon = new Pokemon(pokemonName,pokemonElement,pokemonHealth);

            pokemons.add(pokemon);

            Trainer trainer = new Trainer(trainerName);

            inputMapTrainerPokemons.putIfAbsent(trainer,pokemons);

        }

        String debug = "";



    }
}
