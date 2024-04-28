package com.spring.social_media_application.controller;

import com.spring.social_media_application.common.CommonResponse;
import com.spring.social_media_application.service.RoutineService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workout/routine")
@Slf4j
@AllArgsConstructor
public class RoutineController {
    private final RoutineService routineService;
    /**
     * Delete exercises
     *
     * @return success or fail response of delete exercises
     */
    @DeleteMapping("")
    public ResponseEntity<CommonResponse> deleteRoutines() {
        CommonResponse commonResponse = routineService.deleteRoutines();
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
