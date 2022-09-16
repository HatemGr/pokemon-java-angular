package com.pokemon.backend.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.backend.model.Pokemon;
import com.pokemon.backend.service.PokemonLibraryService;


@RestController
@RequestMapping("/")
public class PokemonController {

  @Autowired
  private PokemonLibraryService pokemonLibraryService;

  @GetMapping("/pokedex")
  public Collection<Pokemon> getPokemons(@RequestParam(required = false) String query) {
    return pokemonLibraryService.getAllPokemons(query);
  }
  
}
