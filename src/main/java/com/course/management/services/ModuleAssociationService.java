package com.course.management.services;

import com.course.management.dtos.ModuleAssociationDto;
import com.course.management.entities.ModuleAssociation;
import com.course.management.mapper.IModuleAssociationMapper;
import com.course.management.repos.ModuleAssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ModuleAssociationService {

    @Autowired
    ModuleAssociationRepository moduleAssociationRepository;

    @Autowired
    IModuleAssociationMapper moduleAssociationMapper;

    public ModuleAssociation addModuleAssociation(ModuleAssociationDto moduleAssociationDto){
        ModuleAssociation moduleAssociation = moduleAssociationMapper.convertTo(moduleAssociationDto);
        moduleAssociation.setCode(UUID.randomUUID().toString());
        ModuleAssociation savedModuleAssociation = moduleAssociationRepository.save(moduleAssociation);
        return savedModuleAssociation;
    }

    public List<ModuleAssociationDto> getAllModuleAssociation(){
        List<ModuleAssociation> moduleAssociationList = moduleAssociationRepository.findAll();
        return moduleAssociationMapper.mapToDto(moduleAssociationList);
    }

    public boolean deleteModuleAssociation(ModuleAssociationDto moduleAssociationDto){
        ModuleAssociation moduleAssociation = moduleAssociationRepository
                .findByCourseCodeAndModuleCode(moduleAssociationDto.getModuleCode(),
                        moduleAssociationDto.getCourseCode());
        moduleAssociationRepository.delete(moduleAssociation);
        return true;
    }

}
