package com.pokemon.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class GetPokemonLibraryControllerTest {

  @Autowired
  private MockMvc mockMvc;
  
  @Test
  public void getAllPokemonsTest() throws Exception {
    mockMvc.perform(get("/pokedex")
    .contentType(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk());
  }

  @Test
  public void getQueriedPokemonsTest() throws Exception {
    mockMvc.perform(get("/pokedex?query=pidg")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().json(
            "[{\"id\":16,\"name\":\"pidgey\",\"height\":3,\"weight\":18},{\"id\":17,\"name\":\"pidgeotto\",\"height\":11,\"weight\":300},{\"id\":18,\"name\":\"pidgeot\",\"height\":15,\"weight\":395}]"));
  }
}
