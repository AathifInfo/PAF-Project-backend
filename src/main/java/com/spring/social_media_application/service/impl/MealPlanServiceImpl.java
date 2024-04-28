package com.spring.social_media_application.service.impl;

import com.spring.social_media_application.common.CommonResponse;
import com.spring.social_media_application.dto.MealPlanDTO;
import com.spring.social_media_application.entity.MealPlan;
import com.spring.social_media_application.mapper.MealPlanMapper;
import com.spring.social_media_application.repository.MealPlanRepository;
import com.spring.social_media_application.service.MealPlanService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class MealPlanServiceImpl implements MealPlanService {
    private final MealPlanRepository mealPlanRepository;
    private final MealPlanMapper mealPlanMapper;

    @Override
    public CommonResponse saveMealPlan(MealPlanDTO mealPlanDTO) {
        log.info("MealPlanServiceImpl.saveMealPlan method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<MealPlan> mealPlan = mealPlanRepository.findById(mealPlanDTO.getMealPlanId());
        if(mealPlan.isPresent()){
            MealPlanDTO foundMealPlanDTO = mealPlanMapper.domainToDto(mealPlan.get());
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("MealPlan details already exist!");
            commonResponse.setData(foundMealPlanDTO);
            log.warn("MealPlan details already exist. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        MealPlan mealPlanSavedDetails = mealPlanRepository.save(mealPlanMapper.dtoToDomain(mealPlanDTO, new MealPlan()));
        commonResponse.setStatus(HttpStatus.CREATED);
        commonResponse.setMessage("MealPlan details saved success!");
        commonResponse.setData(mealPlanMapper.domainToDto(mealPlanSavedDetails));
        log.info("MealPlanServiceImpl.saveMealPlan method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteMealPlanById(String mealPlanId) {
        log.info("MealPlanServiceImpl.deleteMealPlanById method accessed");
        CommonResponse commonResponse = new CommonResponse();
        Optional<MealPlan> mealPlan = mealPlanRepository.findById(mealPlanId);
        if(mealPlan.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete mealPlan details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("MealPlan  details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        mealPlanRepository.deleteById(mealPlanId);
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("MealPlan details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("MealPlanServiceImpl.deleteMealPlanById method end");
        return commonResponse;
    }

    @Override
    public CommonResponse deleteMealPlans() {
        log.info("MealPlanServiceImpl.deleteMealPlans method accessed");
        CommonResponse commonResponse = new CommonResponse();
        List<MealPlan> mealPlans = mealPlanRepository.findAll();
        if(mealPlans.isEmpty()) {
            commonResponse.setStatus(HttpStatus.BAD_REQUEST);
            commonResponse.setMessage("Delete all mealPlans details not available!");
            commonResponse.setData(new ArrayList<>());
            log.warn("MealPlan all details not available. message : {}", commonResponse.getMessage());
            return commonResponse;
        }
        mealPlanRepository.deleteAll();
        commonResponse.setStatus(HttpStatus.OK);
        commonResponse.setMessage("MealPlan details is delete success!");
        commonResponse.setData(new ArrayList<>());
        log.info("MealPlanServiceImpl.deleteMealPlans method end");
        return commonResponse;
    }

}
