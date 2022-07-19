package com.course.management.repos;

import com.course.management.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCode(String code);

    @Query("Select c from Course c where c.code =:codes")
    Course existsByCourseCode(@Param("codes") String code);

}
