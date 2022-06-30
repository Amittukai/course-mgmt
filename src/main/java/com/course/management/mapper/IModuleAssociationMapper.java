package com.course.management.mapper;

import com.course.management.dtos.ModuleAssociationDto;
import com.course.management.entities.ModuleAssociation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IModuleAssociationMapper {

    ModuleAssociation convertTo(ModuleAssociationDto moduleAssociationDto);

    ModuleAssociationDto convertToDto(ModuleAssociation moduleAssociation);

    List<ModuleAssociation> map(List<ModuleAssociationDto> moduleAssociationDtos);

    List<ModuleAssociationDto> mapToDto(List<ModuleAssociation> moduleAssociationList);

}
