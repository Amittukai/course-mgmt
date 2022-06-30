package com.course.management.dtos;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModuleAssociationDto {
    private String code;
    @NotNull
    private String moduleCode;
    @NotNull
    private String courseCode;
}
