package com.course.management.repos;

import com.course.management.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {
    Module findByCode(String code);

    @Query("SELECT m FROM Module m WHERE m.code IN (:codes)")
    List<Module> findByModulesCode(@Param("codes") List<String> codes);
}
