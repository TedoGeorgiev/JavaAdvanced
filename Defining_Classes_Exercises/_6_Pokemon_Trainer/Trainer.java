package Defining_Classes_Exercises._6_Pokemon_Trainer;

import java.util.List;

public class Trainer {

    private String trainerName;
    private int badges;
    private List<Pokemon> pokemonList;

    public Trainer(String trainerName, List<Pokemon> pokemonList) {
        this.trainerName = trainerName;
        this.pokemonList = pokemonList;
    }


    public void executeCommand(String command) {

        if (isExist(command)) {
            badges += 1;
        } else {

            for (int i = 0; i < pokemonList.size(); i++) {
                pokemonList.get(i).setHealth(pokemonList.get(i).getHealth() - 10);
                if (pokemonList.get(i).getHealth() <= 0) {
                    pokemonList.remove(i);
                    i--;
                }
            }
        }
    }

    private boolean isExist(String command) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getElement().equals(command)) {
                return true;
            }
        }
        return false;
    }

    public int getBadges() {
        return badges;
    }


    //"{TrainerName} {Badges} {NumberOfPokemon}".

    @Override
    public String toString() {
        return String.format("%s %d %d", trainerName, badges, pokemonList.size());
    }
}
