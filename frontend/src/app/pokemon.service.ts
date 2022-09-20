import { Injectable } from '@angular/core';
import { Pokemon } from 'pokemon';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {
  private pokemonUrl = 'http://localhost:8080/pokedex';

  getPokemons(): Observable<Pokemon[]>{
    return this.http.get<Pokemon[]>(this.pokemonUrl);
  }

  constructor(
    private http: HttpClient,
  ) {}
}
