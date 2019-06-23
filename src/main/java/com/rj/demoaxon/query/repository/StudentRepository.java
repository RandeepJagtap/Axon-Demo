package com.rj.demoaxon.query.repository;

import com.rj.demoaxon.query.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "student", rel = "student")
public interface StudentRepository extends JpaRepository<Student, String> {
}
