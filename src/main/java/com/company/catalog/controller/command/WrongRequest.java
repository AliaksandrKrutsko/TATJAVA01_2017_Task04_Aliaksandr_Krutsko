package com.company.catalog.controller.command;

import com.company.catalog.bean.*;
import com.company.catalog.controller.Command;

/**
 * Created by Aliaksandr_Krutsko on 2/21/2017.
 */
public class WrongRequest implements Command {


    @Override
    public String execute(Request request) {

        String response = "your request is wrong";
        return response;
    }


}
