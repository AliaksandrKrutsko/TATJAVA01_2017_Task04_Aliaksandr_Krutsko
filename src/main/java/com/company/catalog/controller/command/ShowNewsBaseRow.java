package com.company.catalog.controller.command;


import com.company.catalog.bean.Request;
import com.company.catalog.controller.Command;
import com.company.catalog.service.NewsService;
import com.company.catalog.service.ServiceException;
import com.company.catalog.service.ServiceFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ShowNewsBaseRow implements Command {

    private static Logger log = Logger.getLogger(ShowNewsBaseRow.class.getName());
    public String execute(Request request) {




        int key = request.getKey();
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {

           response = newsService.showNewsBaseRow(key);

        } catch (ServiceException e) {

            response = "something went wrong";
            log.log(Level.WARNING, e.getLocalizedMessage());
        }



        return response;


    }


}
