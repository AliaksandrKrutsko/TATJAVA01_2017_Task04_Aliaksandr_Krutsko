package com.company.catalog.controller.command;


import com.company.catalog.bean.*;
import com.company.catalog.controller.Command;
import com.company.catalog.service.NewsService;
import com.company.catalog.service.ServiceException;
import com.company.catalog.service.ServiceFactory;
import java.util.logging.Logger;

import java.util.Scanner;
import java.util.logging.Level;

public class AddNews implements Command{

    private static Logger log = Logger.getLogger(AddNews.class.getName());

    private String name = null;
    private String response;


    public String execute(Request request) {


        News news = new News();

        String category = request.getCategory();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();
        Scanner scanner = new Scanner(System.in);

        switch (category.toUpperCase()) {
            case "MOVIE":

                try {
                    newsService.addMovie(request.getMovie());
                } catch (ServiceException e) {
                    log.log(Level.WARNING, e.getLocalizedMessage() );
                }
                break;

            case "BOOK":

                try {
                    newsService.addBook(request.getBook());
                } catch (ServiceException e) {
                    log.log(Level.WARNING, e.getLocalizedMessage() );
                }
                break;

            case "MUSIC":
                try {
                    newsService.addMusic(request.getMusic());
                } catch (ServiceException e) {
                    log.log(Level.WARNING, e.getLocalizedMessage() );
                }

        }


        news.setName(request.getName());
        news.setCategory(category);
        news.setContent(request.getContent());



        try {

            newsService.addNews(news);
            response = "your news was added";

        } catch (ServiceException e) {

            response = "something went wrong";
            log.log(Level.WARNING, e.getLocalizedMessage());
        }

        return response;

    }


}