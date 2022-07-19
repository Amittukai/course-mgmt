package com.course.management.services;

import com.course.management.dtos.ModuleAssociationDto;
import com.course.management.entities.Course;
import com.course.management.entities.Module;
import com.course.management.entities.ModuleAssociation;
import com.course.management.exception.CourseException;
import com.course.management.mapper.IModuleAssociationMapper;
import com.course.management.repos.CourseRepository;
import com.course.management.repos.ModuleAssociationRepository;
import com.course.management.repos.ModuleRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ModuleAssociationService {

    @Autowired
    ModuleAssociationRepository moduleAssociationRepository;
    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    IModuleAssociationMapper moduleAssociationMapper;

    ModuleAssociation moduleAssociation;

    public ModuleAssociation addModuleAssociation(@NotNull ModuleAssociationDto moduleAssociationDto){
        ModuleAssociation savedModuleAssociation=null;
        boolean courseValid=false;
        boolean moduleValid=false;
        Course courseIsEmpty = courseRepository.existsByCourseCode(moduleAssociationDto.getCourseCode());
        Module moduleIsEmpty = moduleRepository.existsByModuleCode(moduleAssociationDto.getModuleCode());
        if(courseIsEmpty != null) {courseValid=true;}
        if(moduleIsEmpty != null) {moduleValid=true;}
        if(courseValid && moduleValid){
                ModuleAssociation moduleAssociation = moduleAssociationMapper.convertTo(moduleAssociationDto);
                moduleAssociation.setCode(UUID.randomUUID().toString());
                savedModuleAssociation = moduleAssociationRepository.save(moduleAssociation);
        }
        else{
            System.out.println("Given CourseCode or ModuleCode doesn't exist");
            //throw new CourseException("Given CourseCode or ModuleCode doesn't exist");
        }
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
