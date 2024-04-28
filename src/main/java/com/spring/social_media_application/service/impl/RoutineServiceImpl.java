package com.spring.social_media_application.service.impl;

import com.spring.social_media_application.common.CommonResponse;
import com.spring.social_media_application.entity.Routine;
import com.spring.social_media_application.repository.RoutineRepository;
import com.spring.social_media_application.service.RoutineService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RoutineServiceImpl implements RoutineService {
    private final RoutineRepository routineRepository;
    @Override
    public CommonResponse deleteRoutines() {
        log.info("RoutineServiceImpl.deleteRoutines method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<Routine> routines = routineRepository.findAll();
        if(routines.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete all routines details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("Routine all details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        routineRepository.deleteAll();
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("Exercises details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("RoutineServiceImpl.deleteRoutines method end");
        return commonResponse;
    }
}
