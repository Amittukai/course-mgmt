package com.course.management.services;

import com.course.management.dtos.ModuleDto;
import com.course.management.entities.Module;
import com.course.management.mapper.IModuleMapper;
import com.course.management.repos.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    IModuleMapper moduleMapper;

    public List<ModuleDto> getAllModule(){
        List<Module> modules = moduleRepository.findAll();
        return moduleMapper.mapToDto(modules);
    }

    public ModuleDto addModule(ModuleDto moduleDto){
        Module module = moduleMapper.convertTo(moduleDto);
        module.setCode(UUID.randomUUID().toString());
        return moduleMapper.convertToDto(moduleRepository.save(module));
    }

    public boolean deleteModule(String moduleCode){
        Module module = moduleRepository.findByCode(moduleCode);
        moduleRepository.delete(module);
        return true;
    }
}
