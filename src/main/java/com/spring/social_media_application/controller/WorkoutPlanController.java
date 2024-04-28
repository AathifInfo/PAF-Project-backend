package com.spring.social_media_application.controller;

import com.spring.social_media_application.common.CommonResponse;
import com.spring.social_media_application.dto.WorkoutPlanDTO;
import com.spring.social_media_application.service.WorkoutPlanService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workout/plan")
@Slf4j
@AllArgsConstructor
public class WorkoutPlanController {
    private final WorkoutPlanService workoutPlanService;

    /**
     * save workout plan
     *
     * @param workoutPlanDTO - required data for workout plan save
     * @return success or fail response of workout plan save
     */
    @PostMapping("")
    public ResponseEntity<CommonResponse> saveWorkoutPlan(@Valid @RequestBody WorkoutPlanDTO workoutPlanDTO) {
        CommonResponse commonResponse = workoutPlanService.saveWorkoutPlan(workoutPlanDTO);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    /**
     * Delete workout plan
     *
     * @param workoutPlanId - required data for delete workout plan
     * @return success or fail response of delete workout plan
     */
    @DeleteMapping("/{workoutPlanId}")
    public ResponseEntity<CommonResponse> deleteWorkoutPlanById(@PathVariable("workoutPlanId") @NotNull String workoutPlanId) {
        CommonResponse commonResponse = workoutPlanService.deleteWorkoutPlanById(workoutPlanId);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }


    /**
     * Delete workout plans
     *
     * @return success or fail response of delete workout plans
     */
    @DeleteMapping("")
    public ResponseEntity<CommonResponse> deleteWorkoutPlans() {
        CommonResponse commonResponse = workoutPlanService.deleteWorkoutPlans();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
