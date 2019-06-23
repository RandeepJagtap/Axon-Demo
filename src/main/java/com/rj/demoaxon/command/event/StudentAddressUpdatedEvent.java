package com.rj.demoaxon.command.event;

import org.axonframework.serialization.Revision;

@Revision("1")
public class StudentAddressUpdatedEvent {
    private String id;
    private String address;

    private StudentAddressUpdatedEvent() {
    }

    public StudentAddressUpdatedEvent(String rollNo, String address) {
        this.id = rollNo;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
}
