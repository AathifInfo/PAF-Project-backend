package com.spring.social_media_application.controller;

import com.spring.social_media_application.common.CommonResponse;
import com.spring.social_media_application.service.RecipeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/meal/recipe")
@Slf4j
@AllArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    /**
     * Delete recipes
     *
     * @return success or fail response of delete recipes
     */
    @DeleteMapping("")
    public ResponseEntity<CommonResponse> deleteRecipes() {
        CommonResponse commonResponse = recipeService.deleteRecipes();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
