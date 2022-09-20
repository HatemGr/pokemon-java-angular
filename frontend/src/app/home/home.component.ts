import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'pokemon';
import { PokemonService } from '../pokemon.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  pokemons: Pokemon[] = [];

  constructor(private pokemonService: PokemonService) {}

  ngOnInit(): void {
    this.getPokemons()
    console.log(this.pokemons);
    
    
  }

  getPokemons(): void {
    this.pokemonService
      .getPokemons()
      .subscribe((pokemons) => (this.pokemons = pokemons));
  }
}
