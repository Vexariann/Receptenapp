package com.julian.receptenapp;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {
    private final RecipeRepository recipeRepository;

    @Override
    public void run(String... args) throws Exception {
        if(recipeRepository.count() == 0){
            recipeRepository.saveAll(List.of(
                    new Recipe("pannenkoeken"),
                    new Recipe("Pizza"),
                    new Recipe("Broodje kaas"),
                    new Recipe("Frikandelbroodje"),
                    new Recipe("Roti")));
        }
    }
}
