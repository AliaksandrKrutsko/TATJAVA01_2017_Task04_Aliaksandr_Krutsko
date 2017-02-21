package com.company.catalog.controller.command;

import com.company.catalog.bean.Request;
import com.company.catalog.controller.Command;
import com.company.catalog.service.NewsService;
import com.company.catalog.service.ServiceException;
import com.company.catalog.service.ServiceFactory;

import java.util.logging.Level;
import java.util.logging.Logger;


public class SearchNewsByName implements Command {

    private static Logger log = Logger.getLogger(SearchNewsByName.class.getName());

    @Override
    public String execute(Request request) {




        String name = request.getSearch();

        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {

            response = newsService.searchNewsByName(name);



        } catch (ServiceException e) {

            response = "something went wrong";
            log.log(Level.WARNING, e.getLocalizedMessage());
        }

        return response;

    }
}
