package com.pokemon.backend.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pokemon.backend.model.Pokemon;

@Service
public class PokemonLibraryService {
  private final static Map<Integer, Pokemon> POKEMONS = new HashMap<>();

  private final static List<Pokemon> pokemonsList = List.of(
  new Pokemon( 1, "bulbasaur", 7, 69 ),
  new Pokemon( 2, "ivysaur", 10, 130 ),
  new Pokemon( 3, "venusaur", 20, 1000 ),
  new Pokemon( 4, "charmander", 6, 85 ),
  new Pokemon( 5, "charmeleon", 11, 190 ),
  new Pokemon( 6, "charizard", 17, 905 ),
  new Pokemon( 7, "squirtle", 5, 90 ),
  new Pokemon( 8, "wartortle", 10, 225 ),
  new Pokemon( 9, "blastoise", 16, 855 ),
  new Pokemon( 10, "caterpie", 3, 29 ),
  new Pokemon( 11, "metapod", 7, 99 ),
  new Pokemon( 12, "butterfree", 11, 320 ),
  new Pokemon( 13, "weedle", 3, 32 ),
  new Pokemon( 14, "kakuna", 6, 100 ),
  new Pokemon( 15, "beedrill", 10, 295 ),
  new Pokemon( 16, "pidgey", 3, 18 ),
  new Pokemon( 17, "pidgeotto", 11, 300 ),
  new Pokemon( 18, "pidgeot", 15, 395 ),
  new Pokemon( 19, "rattata", 3, 35 ),
  new Pokemon( 20, "raticate", 7, 185 ),
  new Pokemon( 21, "spearow", 3, 20 ),
  new Pokemon( 22, "fearow", 12, 380 ),
  new Pokemon( 23, "ekans", 20, 69 ),
  new Pokemon( 24, "arbok", 35, 650 ),
  new Pokemon( 25, "pikachu", 4, 60 ),
  new Pokemon( 26, "raichu", 8, 300 ),
  new Pokemon( 27, "sandshrew", 6, 120 ),
  new Pokemon( 28, "sandslash", 10, 295 ),
  new Pokemon( 29, "nidoran-f", 4, 70 ),
  new Pokemon( 30, "nidorina", 8, 200 ),
  new Pokemon( 31, "nidoqueen", 13, 600 ),
  new Pokemon( 32, "nidoran-m", 5, 90 ),
  new Pokemon( 33, "nidorino", 9, 195 ),
  new Pokemon( 34, "nidoking", 14, 620 ),
  new Pokemon( 35, "clefairy", 6, 75 ),
  new Pokemon( 36, "clefable", 13, 400 ),
  new Pokemon( 37, "vulpix", 6, 99 ),
  new Pokemon( 38, "ninetales", 11, 199 ),
  new Pokemon( 39, "jigglypuff", 5, 55 ),
  new Pokemon( 40, "wigglytuff", 10, 120 ),
  new Pokemon( 41, "zubat", 8, 75 ),
  new Pokemon( 42, "golbat", 16, 550 ),
  new Pokemon( 43, "oddish", 5, 54 ),
  new Pokemon( 44, "gloom", 8, 86 ),
  new Pokemon( 45, "vileplume", 12, 186 ),
  new Pokemon( 46, "paras", 3, 54 ),
  new Pokemon( 47, "parasect", 10, 295 ),
  new Pokemon( 48, "venonat", 10, 300 ),
  new Pokemon( 49, "venomoth", 15, 125 ),
  new Pokemon( 50, "diglett", 2, 8 ),
  new Pokemon( 51, "dugtrio", 7, 333 ),
  new Pokemon( 52, "meowth", 4, 42 ),
  new Pokemon( 53, "persian", 10, 320 ),
  new Pokemon( 54, "psyduck", 8, 196 ),
  new Pokemon( 55, "golduck", 17, 766 ),
  new Pokemon( 56, "mankey", 5, 280 ),
  new Pokemon( 57, "primeape", 10, 320 ),
  new Pokemon( 58, "growlithe", 7, 190 ),
  new Pokemon( 59, "arcanine", 19, 1550 ),
  new Pokemon( 60, "poliwag", 6, 124 ),
  new Pokemon( 61, "poliwhirl", 10, 200 ),
  new Pokemon( 62, "poliwrath", 13, 540 ),
  new Pokemon( 63, "abra", 9, 195 ),
  new Pokemon( 64, "kadabra", 13, 565 ),
  new Pokemon( 65, "alakazam", 15, 480 ),
  new Pokemon( 66, "machop", 8, 195 ),
  new Pokemon( 67, "machoke", 15, 705 ),
  new Pokemon( 68, "machamp", 16, 1300 ),
  new Pokemon( 69, "bellsprout", 7, 40 ),
  new Pokemon( 70, "weepinbell", 10, 64 ),
  new Pokemon( 71, "victreebel", 17, 155 ),
  new Pokemon( 72, "tentacool", 9, 455 ),
  new Pokemon( 73, "tentacruel", 16, 550 ),
  new Pokemon( 74, "geodude", 4, 200 ),
  new Pokemon( 75, "graveler", 10, 1050 ),
  new Pokemon( 76, "golem", 14, 3000 ),
  new Pokemon( 77, "ponyta", 10, 300 ),
  new Pokemon( 78, "rapidash", 17, 950 ),
  new Pokemon( 79, "slowpoke", 12, 360 ),
  new Pokemon( 80, "slowbro", 16, 785 ),
  new Pokemon( 81, "magnemite", 3, 60 ),
  new Pokemon( 82, "magneton", 10, 600 ),
  new Pokemon( 83, "farfetchd", 8, 150 ),
  new Pokemon( 84, "doduo", 14, 392 ),
  new Pokemon( 85, "dodrio", 18, 852 ),
  new Pokemon( 86, "seel", 11, 900 ),
  new Pokemon( 87, "dewgong", 17, 1200 ),
  new Pokemon( 88, "grimer", 9, 300 ),
  new Pokemon( 89, "muk", 12, 300 ),
  new Pokemon( 90, "shellder", 3, 40 ),
  new Pokemon( 91, "cloyster", 15, 1325 ),
  new Pokemon( 92, "gastly", 13, 1 ),
  new Pokemon( 93, "haunter", 16, 1 ),
  new Pokemon( 94, "gengar", 15, 405 ),
  new Pokemon( 95, "onix", 88, 2100 ),
  new Pokemon( 96, "drowzee", 10, 324 ),
  new Pokemon( 97, "hypno", 16, 756 ),
  new Pokemon( 98, "krabby", 4, 65 ),
  new Pokemon( 99, "kingler", 13, 600 ),
  new Pokemon( 100, "voltorb", 5, 104 ),
  new Pokemon( 101, "electrode", 12, 666 ),
  new Pokemon( 102, "exeggcute", 4, 25 ),
  new Pokemon( 103, "exeggutor", 20, 1200 ),
  new Pokemon( 104, "cubone", 4, 65 ),
  new Pokemon( 105, "marowak", 10, 450 ),
  new Pokemon( 106, "hitmonlee", 15, 498 ),
  new Pokemon( 107, "hitmonchan", 14, 502 ),
  new Pokemon( 108, "lickitung", 12, 655 ),
  new Pokemon( 109, "koffing", 6, 10 ),
  new Pokemon( 110, "weezing", 12, 95 ),
  new Pokemon( 111, "rhyhorn", 10, 1150 ),
  new Pokemon( 112, "rhydon", 19, 1200 ),
  new Pokemon( 113, "chansey", 11, 346 ),
  new Pokemon( 114, "tangela", 10, 350 ),
  new Pokemon( 115, "kangaskhan", 22, 800 ),
  new Pokemon( 116, "horsea", 4, 80 ),
  new Pokemon( 117, "seadra", 12, 250 ),
  new Pokemon( 118, "goldeen", 6, 150 ),
  new Pokemon( 119, "seaking", 13, 390 ),
  new Pokemon( 120, "staryu", 8, 345 ),
  new Pokemon( 121, "starmie", 11, 800 ),
  new Pokemon( 122, "mr-mime", 13, 545 ),
  new Pokemon( 123, "scyther", 15, 560 ),
  new Pokemon( 124, "jynx", 14, 406 ),
  new Pokemon( 125, "electabuzz", 11, 300 ),
  new Pokemon( 126, "magmar", 13, 445 ),
  new Pokemon( 127, "pinsir", 15, 550 ),
  new Pokemon( 128, "tauros", 14, 884 ),
  new Pokemon( 129, "magikarp", 9, 100 ),
  new Pokemon( 130, "gyarados", 65, 2350 ),
  new Pokemon( 131, "lapras", 25, 2200 ),
  new Pokemon( 132, "ditto", 3, 40 ),
  new Pokemon( 133, "eevee", 3, 65 ),
  new Pokemon( 134, "vaporeon", 10, 290 ),
  new Pokemon( 135, "jolteon", 8, 245 ),
  new Pokemon( 136, "flareon", 9, 250 ),
  new Pokemon( 137, "porygon", 8, 365 ),
  new Pokemon( 138, "omanyte", 4, 75 ),
  new Pokemon( 139, "omastar", 10, 350 ),
  new Pokemon( 140, "kabuto", 5, 115 ),
  new Pokemon( 141, "kabutops", 13, 405 ),
  new Pokemon( 142, "aerodactyl", 18, 590 ),
  new Pokemon( 143, "snorlax", 21, 4600 ),
  new Pokemon( 144, "articuno", 17, 554 ),
  new Pokemon( 145, "zapdos", 16, 526 ),
  new Pokemon( 146, "moltres", 20, 600 ),
  new Pokemon( 147, "dratini", 18, 33 ),
  new Pokemon( 148, "dragonair", 40, 165 ),
  new Pokemon( 149, "dragonite", 22, 2100 ),
  new Pokemon( 150, "mewtwo", 20, 1220 ),
  new Pokemon( 151, "mew", 4, 40 )
  );

  
  static{
    pokemonsList.forEach(pokemon -> POKEMONS.put(pokemon.id,pokemon));
  }

  public Collection<Pokemon> getAllPokemons(String query){
    return POKEMONS.values().stream()
    .sorted(Comparator.comparing(Pokemon::getId))
    .filter(pokemon -> query == null || pokemon.getName().contains(query))
    .collect(Collectors.toList());
  }

  public Pokemon getOnePokemon(int id) {
    return POKEMONS.get(id);
  }
  
}
