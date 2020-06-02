package PokemonTrainer_fd_8;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private static final int INITIAL_NUMBER_OF_BADGE = 0;

    private String name;
    private int numberOfBadges;
    List<Pokemon> pokemons;

    public Trainer(String name){
        this.name = name;
        this.numberOfBadges = INITIAL_NUMBER_OF_BADGE;
        this.pokemons = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public List<Pokemon> getPokemons(){
        return pokemons;
    }



}
