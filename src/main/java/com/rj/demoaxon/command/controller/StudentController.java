package com.rj.demoaxon.command.controller;

import com.rj.demoaxon.command.command.CreateStudentCommand;
import com.rj.demoaxon.command.command.UpdateAddressCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("/student")
public class StudentController {


    private CommandGateway commandGateway;

    @Autowired
    public StudentController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    /*@RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public StudentRequest getStudent(@PathVariable("id") String id) {
        return null;//personService.findById(id);
    }
*/
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public String createStudent(@RequestBody StudentRequest studentRequest) {
        String id = randomUUID().toString();
        commandGateway.send(new CreateStudentCommand(id, studentRequest.getName(), studentRequest.getAddress()));
        return id;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public void updateAddress(@PathVariable String id, @RequestBody String address) {
        commandGateway.send(new UpdateAddressCommand(id, address));
    }
}
