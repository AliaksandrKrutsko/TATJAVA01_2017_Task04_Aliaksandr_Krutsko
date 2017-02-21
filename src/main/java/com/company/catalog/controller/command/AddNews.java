package controller.command;
import bean.News;

import controller.Command;
import service.NewsService;
import service.ServiceException;
import service.ServiceFactory;


import java.io.IOException;
import java.util.Scanner;


public class AddNews implements Command {

    public String execute(String request) {


        News news = new News();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        news.setName(scanner.nextLine());
        System.out.println("Enter category: ");
        news.setCategory(scanner.nextLine());
        System.out.println("Enter content");
        news.setContent(scanner.nextLine());


        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {

            newsService.addNews(news);
            response = "your news was added";

        } catch (ServiceException e) {

            response = "something went wrong";
        }

        return response;
    }

}