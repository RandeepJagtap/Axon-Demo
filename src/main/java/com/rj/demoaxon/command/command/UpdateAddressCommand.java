package com.rj.demoaxon.command.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class UpdateAddressCommand {
    @TargetAggregateIdentifier
    private String id;
    private String address;

    private UpdateAddressCommand() {
    }

    public UpdateAddressCommand(String id, String address) {
        this.id = id;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
}
