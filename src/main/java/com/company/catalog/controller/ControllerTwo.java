package com.company.catalog.controller;


import com.company.catalog.bean.Request;

public class ControllerTwo {

    private final CommandProvider provider = new CommandProvider();



    public String executeTask(Request request){

        String commandName;
        Command executionCommand;
        commandName = request.getCommand();

        executionCommand = provider.getCommand(commandName);
        String response;
        response = executionCommand.execute(request);
        return response;

    }





}
