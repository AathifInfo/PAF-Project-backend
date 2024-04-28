package com.spring.social_media_application.service;

import com.spring.social_media_application.common.CommonResponse;

public interface RecipeService {
    /**
     * Delete recipes
     *
     * @return success or fail response of delete recipes
     */
    CommonResponse deleteRecipes();
}
