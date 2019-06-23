package com.rj.demoaxon.query.event.listener;

import com.rj.demoaxon.command.event.StudentAddressUpdatedEvent;
import com.rj.demoaxon.query.entity.Student;
import com.rj.demoaxon.query.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentAddressUpdatedEventListener {

    private StudentRepository studentRepository;

    @Autowired
    public StudentAddressUpdatedEventListener(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @EventListener
    public void handle(StudentAddressUpdatedEvent event) {
        Student student = studentRepository.getOne(event.getId());
        student.setAddress(event.getAddress());
        studentRepository.save(student);
    }
}
