package com.course.management.controllers;

import com.course.management.controllers.base.BaseController;
import com.course.management.dtos.ModuleAssociationDto;
import com.course.management.services.ModuleAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/module/association")
public class ModuleAssociationController extends BaseController {

    @Autowired
    ModuleAssociationService moduleAssociationService;

    @GetMapping()
    public ResponseEntity getModuleAssociation(){
        return sendSuccessApiResponse(moduleAssociationService.getAllModuleAssociation());
    }

    @PostMapping()
    public ResponseEntity addModuleAssociation(@RequestBody ModuleAssociationDto moduleAssociationDto){
        return sendSuccessApiResponse(moduleAssociationService.addModuleAssociation(moduleAssociationDto));
    }

    @DeleteMapping
    public ResponseEntity deleteModuleAssociation(@RequestParam ModuleAssociationDto moduleAssociationDto){
        return sendSuccessApiResponse(moduleAssociationService.deleteModuleAssociation(moduleAssociationDto));
    }
}
