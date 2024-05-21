package com.julian.receptenapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface recipeRepository extends JpaRepository<recipe, Long> {
}
