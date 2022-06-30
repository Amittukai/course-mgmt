package com.course.management.services;

import com.course.management.dtos.CourseDto;
import com.course.management.dtos.ModuleDto;
import com.course.management.entities.Course;
import com.course.management.entities.Module;
import com.course.management.entities.ModuleAssociation;
import com.course.management.exception.CourseException;
import com.course.management.mapper.ICourseMapper;
import com.course.management.mapper.IModuleMapper;
import com.course.management.repos.CourseRepository;
import com.course.management.repos.ModuleAssociationRepository;
import com.course.management.repos.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    ModuleAssociationRepository moduleAssociationRepository;

    @Autowired
    ICourseMapper courseMapper;

    @Autowired
    IModuleMapper moduleMapper;

    public List<CourseDto> getAllCourse(){
        List<Course> courses = courseRepository.findAll();
        List<CourseDto> courseDtoList = new ArrayList<>();
        courses.forEach(c -> courseDtoList.add(getCourseDtoWithValues(c)));
        return courseDtoList;
    }

    public CourseDto getCourseDtoWithValues(Course course){
        CourseDto courseDto = courseMapper.convertToDto(course);
        List<ModuleAssociation> moduleAssociationList = moduleAssociationRepository.findByCourseCode(course.getCode());
        List<String> moduleCodes = moduleAssociationList.stream()
                .map(ModuleAssociation::getModuleCode).collect(Collectors.toList());
        List<Module> modules = moduleRepository.findByModulesCode(moduleCodes);
        courseDto.setNumberOfSession(modules.stream().mapToDouble(Module::getNumberOfSession).sum());
        courseDto.setTotalHours(modules.stream().mapToDouble(Module::getTotalHours).sum());
        return courseDto;
    }

    public List<ModuleDto> getAllModuleByCourse(String courseCode){
        List<ModuleAssociation> moduleAssociationList = moduleAssociationRepository.findByCourseCode(courseCode);
        List<String> moduleCodes = moduleAssociationList.stream()
                .map(ModuleAssociation::getModuleCode).collect(Collectors.toList());
        List<Module> modules = moduleRepository.findByModulesCode(moduleCodes);
        return moduleMapper.mapToDto(modules);
    }

    public CourseDto addCourse(CourseDto courseDto){
        Course course = courseMapper.convertTo(courseDto);
        courseDto.getModuleCode().forEach(x -> {
            Module module = moduleRepository.findByCode(x);
            if(module == null)
                throw new CourseException("Module not found with code : " + x);
        });
        course.setCode(UUID.randomUUID().toString());
        Course savedCourse = courseRepository.save(course);
        List<ModuleAssociation> moduleAssociationList = new ArrayList<>();
        courseDto.getModuleCode().forEach(moduleCode -> {
            moduleAssociationList.add(new ModuleAssociation(UUID.randomUUID().toString(), moduleCode, savedCourse.getCode()));
        });
        moduleAssociationRepository.saveAll(moduleAssociationList);
        return courseMapper.convertToDto(savedCourse);
    }

    public boolean deleteCourse(String courseCode){
        Course course = courseRepository.findByCode(courseCode);
        courseRepository.delete(course);
        List<ModuleAssociation> moduleAssociationList = moduleAssociationRepository.findByCourseCode(courseCode);
        moduleAssociationRepository.deleteAll(moduleAssociationList);
        return true;
    }
}
