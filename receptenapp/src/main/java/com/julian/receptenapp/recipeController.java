package com.julian.receptenapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/recipe")
public class recipeController {

    @GetMapping("")
    public String getRecipe(){
        return "Hello recipes!";
    }

}
