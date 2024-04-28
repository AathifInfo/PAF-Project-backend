package com.spring.social_media_application.service.impl;

import com.spring.social_media_application.common.CommonResponse;
import com.spring.social_media_application.entity.Recipe;
import com.spring.social_media_application.mapper.RecipeMapper;
import com.spring.social_media_application.repository.RecipeRepository;
import com.spring.social_media_application.service.RecipeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
    @Override
    public CommonResponse deleteRecipes() {
        log.info("RecipeServiceImpl.deleteRecipes method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<Recipe> recipes = recipeRepository.findAll();
        if(recipes.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete all recipes details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Recipe all details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        recipeRepository.deleteAll();
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Recipe details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("RecipeServiceImpl.deleteRecipes method end");
        return commonResponse;
    }
}
