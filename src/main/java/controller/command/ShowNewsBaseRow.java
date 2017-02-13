package controller.command;


import bean.News;
import controller.Command;
import service.ServiceException;
import service.NewsService;
import service.ServiceFactory;

import java.util.Scanner;

public class ShowNewsBaseRow implements Command {

    public String execute(String request) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("enter row number");
        int key = scanner.nextInt();
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {


            System.out.println(newsService.showNewsBaseRow(key));
            response = "that was your row";

        } catch (ServiceException e) {

            response = "something went wrong";
        }
        System.out.println(response);

        return response;


    }


}
