package com.julian.receptenapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ingredient {
    @GeneratedValue
    @Id
    public Long Id;

    public String name;

    public Ingredient() {}

    public Ingredient(String name){
        this.name = name;
    }
}
