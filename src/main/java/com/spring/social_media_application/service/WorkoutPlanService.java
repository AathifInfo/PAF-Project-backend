package com.spring.social_media_application.service;

import com.spring.social_media_application.common.CommonResponse;
import com.spring.social_media_application.dto.WorkoutPlanDTO;

public interface WorkoutPlanService {
    /**
     * save workout plan
     *
     * @param workoutPlanDTO - required data for workout plan save
     * @return success or fail response of workout plan save
     */
    CommonResponse saveWorkoutPlan(WorkoutPlanDTO workoutPlanDTO);

    /**
     * Delete workout plans
     *
     * @return success or fail response of delete workout plans
     */
    CommonResponse deleteWorkoutPlans();
}
