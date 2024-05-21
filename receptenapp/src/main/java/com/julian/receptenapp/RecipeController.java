package com.julian.receptenapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/recipe")
@CrossOrigin(origins = "http://localhost:5173")
public class RecipeController {

    private final RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("")
    public Iterable<Recipe> getRecipes(){
        return recipeRepository.findAll();
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Recipe> GetById(@PathVariable Long id){
        return recipeRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create-recipe")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe){
        try{
            recipeRepository.save(recipe);
            return ResponseEntity.ok(recipe);
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
