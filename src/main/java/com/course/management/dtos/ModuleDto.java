package com.course.management.dtos;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ModuleDto {

    @NotNull
    private String name;
    private String code;
    private String shortName;
    private List<String> aliases;
    private String outcomes;
    private String objectives;
    @NotNull
    private double numberOfSession;
    @NotNull
    private double totalHours;
}
