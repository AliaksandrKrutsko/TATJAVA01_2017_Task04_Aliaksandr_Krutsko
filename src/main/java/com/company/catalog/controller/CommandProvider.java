package com.company.catalog.controller;


import com.company.catalog.controller.command.AddNews;
import com.company.catalog.controller.command.SearchNewsByName;
import com.company.catalog.controller.command.ShowNewsBaseRow;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private final Map<CommandName, Command> repository = new HashMap<>();


    public enum CommandName {
        SHOW_NEWSBASE, ADD_NEWS, SEARCH_NEWS, WRONG_REQUEST
    }


    CommandProvider(){
        repository.put(CommandName.SHOW_NEWSBASE, new ShowNewsBaseRow());
        repository.put(CommandName.ADD_NEWS, new AddNews());
        repository.put(CommandName.SEARCH_NEWS, new SearchNewsByName());
    }

    Command getCommand(String name){
        CommandName commandName =null;
        Command command = null;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        }catch(IllegalArgumentException | NullPointerException e){

            command = repository.get(CommandName.WRONG_REQUEST);

        }
        return command;
    }




}
