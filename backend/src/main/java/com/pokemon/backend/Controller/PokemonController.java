package com.pokemon.backend.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.backend.Controller.exceptions.NotFoundException;
import com.pokemon.backend.model.Pokemon;
import com.pokemon.backend.service.PokemonLibraryService;

@RestController
@RequestMapping("/")
public class PokemonController {

  @Autowired
  private PokemonLibraryService pokemonLibraryService;

  @GetMapping("/pokedex")
  public ResponseEntity<Collection<Pokemon>> getPokemons(@RequestParam(required = false) String query) {
    Collection<Pokemon> queriedPokemon = pokemonLibraryService.getAllPokemons(query);
    if (queriedPokemon.size() == 0) throw new NotFoundException();
    return new ResponseEntity<>(queriedPokemon, HttpStatus.OK);
  }

  @GetMapping("/pokedex/{id}")
  public ResponseEntity<Pokemon> getOnePokemon(@PathVariable("id") int pokemonId) {
    Pokemon searchedPokemon = pokemonLibraryService.getOnePokemon(pokemonId);
    if (searchedPokemon == null) {
      throw new NotFoundException();
    }
    return new ResponseEntity<>(searchedPokemon, HttpStatus.OK);
  }

}
