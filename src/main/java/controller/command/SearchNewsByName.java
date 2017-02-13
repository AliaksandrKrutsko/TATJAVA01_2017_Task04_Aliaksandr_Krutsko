package controller.command;

import bean.News;
import controller.Command;
import dao.DaoException;
import service.NewsService;
import service.ServiceException;
import service.ServiceFactory;

import java.io.IOException;
import java.util.Scanner;


public class SearchNewsByName implements Command {


    @Override
    public String execute(String request) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("What are you searching for?");

        String name = scanner.nextLine();

        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {

            System.out.println(newsService.searchNewsByName(name));
            response = "you found your news";


        } catch (ServiceException e) {

            response = "something went wrong";
        }

        return response;

    }
}
