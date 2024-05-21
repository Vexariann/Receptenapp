package com.julian.receptenapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ingredient")
public class IngredientController {
    IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("")
    public Iterable<Ingredient> GetAllIngredients(){
        return ingredientRepository.findAll();
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Ingredient> GetById(@PathVariable Long Id){
        return ingredientRepository.findById(Id).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping("/create-ingredient")
    public ResponseEntity<Ingredient> createRecipe(@RequestBody Ingredient ingredient){
        try{
            ingredientRepository.save(ingredient);
            return ResponseEntity.ok(ingredient);
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
