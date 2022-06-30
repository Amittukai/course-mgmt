package com.course.management.repos;

import com.course.management.entities.ModuleAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleAssociationRepository extends JpaRepository<ModuleAssociation, Long> {

    @Query("Select ma from ModuleAssociation ma where ma.moduleCode = :moduleCode AND ma.courseCode = :courseCode")
    ModuleAssociation findByCourseCodeAndModuleCode(@Param("moduleCode") String moduleCode,
                                                    @Param("courseCode") String courseCode);
    @Query("Select ma from ModuleAssociation ma where ma.courseCode = :courseCode")
    List<ModuleAssociation> findByCourseCode(@Param("courseCode") String courseCode);
}
