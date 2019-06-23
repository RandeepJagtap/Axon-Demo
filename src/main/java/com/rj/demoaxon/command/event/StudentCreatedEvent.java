package com.rj.demoaxon.command.event;

import org.axonframework.serialization.Revision;

@Revision("1")
public class StudentCreatedEvent {
    private String id;
    private String name;
    private String address;

    private StudentCreatedEvent() {
    }

    public StudentCreatedEvent(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
