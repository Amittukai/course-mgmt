package com.course.management.mapper;

import com.course.management.dtos.ModuleDto;
import com.course.management.entities.Module;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IModuleMapper {

    Module convertTo(ModuleDto moduleDto);

    ModuleDto convertToDto(Module module);

    List<Module> map(List<ModuleDto> moduleDtoList);

    List<ModuleDto> mapToDto(List<Module> moduleList);
}
