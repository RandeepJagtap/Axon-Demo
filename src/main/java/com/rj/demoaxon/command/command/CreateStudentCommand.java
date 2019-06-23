package com.rj.demoaxon.command.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CreateStudentCommand {
    @TargetAggregateIdentifier
    private String id;
    private String name;
    private String address;

    private CreateStudentCommand() {
    }

    public CreateStudentCommand(String id, String name, String address) {
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
