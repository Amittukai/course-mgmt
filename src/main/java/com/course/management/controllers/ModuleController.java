package com.course.management.controllers;

import com.course.management.controllers.base.BaseController;
import com.course.management.dtos.ModuleDto;
import com.course.management.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/module")
public class ModuleController extends BaseController {

    @Autowired
    ModuleService moduleService;

    @GetMapping()
    public ResponseEntity getAllModule(){
        return sendSuccessApiResponse(moduleService.getAllModule());
    }

    @PostMapping()
    public ResponseEntity addModule(@RequestBody ModuleDto moduleDto){
        return sendSuccessApiResponse(moduleService.addModule(moduleDto));
    }

    @DeleteMapping
    public ResponseEntity deleteModule(@RequestParam String code){
        return sendSuccessApiResponse(moduleService.deleteModule(code));
    }
}
