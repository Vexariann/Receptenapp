package com.julian.receptenapp;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {
    private final recipeRepository recipeRepository;

    @Override
    public void run(String... args) throws Exception {
        if(recipeRepository.count() == 0){
            recipeRepository.saveAll(List.of(
                    new recipe("pannenkoeken"),
                    new recipe("Pizza"),
                    new recipe("Broodje kaas"),
                    new recipe("Frikandelbroodje"),
                    new recipe("Roti")));
        }
    }
}
