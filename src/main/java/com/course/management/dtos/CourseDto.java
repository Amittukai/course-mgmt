package com.course.management.dtos;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseDto {
    @NotNull
    private String name;
    private String code;
    private String shortName;
    private List<String> aliases;
    private List<String> moduleCode;
    private String outcomes;
    private String objectives;
    private double numberOfSession;
    private double totalHours;
}
