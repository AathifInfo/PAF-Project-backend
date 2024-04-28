package com.spring.social_media_application.service;

import com.spring.social_media_application.common.CommonResponse;

public interface RoutineService {
    /**
     * Delete exercises
     *
     * @return success or fail response of delete exercises
     */
    CommonResponse deleteRoutines();
}
