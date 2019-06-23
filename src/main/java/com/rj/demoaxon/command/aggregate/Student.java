package com.rj.demoaxon.command.aggregate;

import com.rj.demoaxon.command.command.CreateStudentCommand;
import com.rj.demoaxon.command.command.UpdateAddressCommand;
import com.rj.demoaxon.command.event.StudentAddressUpdatedEvent;
import com.rj.demoaxon.command.event.StudentCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Student {
    @AggregateIdentifier
    private String id;
    private String name;
    private String address;

    private Student() {
    }

    @EventSourcingHandler
    public void on(StudentCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.address = event.getAddress();
    }

    @EventSourcingHandler
    public void on(StudentAddressUpdatedEvent event) {
        this.id = event.getId();
        this.address = event.getAddress();
    }

    @CommandHandler
    public Student(CreateStudentCommand command) {
        apply(new StudentCreatedEvent(command.getId(), command.getName(), command.getAddress()));
    }

    @CommandHandler
    public void updateAddress(UpdateAddressCommand command) {
        apply(new StudentAddressUpdatedEvent(command.getId(), command.getAddress()));
    }
}
