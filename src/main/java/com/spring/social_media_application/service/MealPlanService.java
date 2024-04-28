package com.spring.social_media_application.service;

import com.spring.social_media_application.common.CommonResponse;
import com.spring.social_media_application.dto.MealPlanDTO;

public interface MealPlanService {
    /**
     * Delete meal plan
     *
     * @return success or fail response of delete meal plan
     */
    CommonResponse deleteMealPlans();

    /**
     * Delete meal plan
     *
     * @param mealPlanId - required data for delete meal plan
     * @return success or fail response of delete meal plan
     */
    CommonResponse deleteMealPlanById(String mealPlanId);

    /**
     * save meal plan
     *
     * @param mealPlanDTO - required data for meal plan save
     * @return success or fail response of meal plan save
     */
    CommonResponse saveMealPlan(MealPlanDTO mealPlanDTO);

}
