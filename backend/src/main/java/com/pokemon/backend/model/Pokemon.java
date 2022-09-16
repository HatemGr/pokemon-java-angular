package com.pokemon.backend.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Pokemon {

  @Getter @Setter
  public int id;

  @Getter @Setter
  public String name;

  @Getter @Setter
  public Integer height;

  @Getter @Setter
  public Integer  weight;


}