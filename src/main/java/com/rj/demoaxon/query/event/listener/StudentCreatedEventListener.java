package com.rj.demoaxon.query.event.listener;

import com.rj.demoaxon.command.event.StudentCreatedEvent;
import com.rj.demoaxon.query.entity.Student;
import com.rj.demoaxon.query.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentCreatedEventListener {

    private StudentRepository studentRepository;

    @Autowired
    public StudentCreatedEventListener(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @EventListener
    public void handle(StudentCreatedEvent event) {
        Student student = new Student(event.getId(), event.getName(), event.getAddress());
        studentRepository.save(student);
    }
}
