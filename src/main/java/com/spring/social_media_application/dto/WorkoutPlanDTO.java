package com.spring.social_media_application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutPlanDTO {
    private List<String> routines;
    private List<String> exercises;
    private List<String> sets;
    private List<String> repetitions;
}
