package com.company.catalog.view;

import com.company.catalog.bean.Request;
import com.company.catalog.controller.ControllerFactory;
import com.company.catalog.controller.ControllerTwo;

import java.util.Scanner;


public class ViewImpl implements View {


    @Override
    public void enterCommand() {
        Request request = new Request();

        Scanner scanner = new Scanner(System.in);
        request.setCommand(scanner.nextLine());
        String command = request.getCommand();

        if (command.equals("show_newsbase")) {
            System.out.println("Enter your row number");
            request.setKey(scanner.nextInt());
        } else if (command.equals("search_news")) {
            System.out.println("What are you searching for?");
            request.setSearch(scanner.nextLine());
        }
        ControllerFactory controllerFactory = ControllerFactory.getInstance();
        ControllerTwo controllerTwo = controllerFactory.getControllerTwo();


        System.out.println(controllerTwo.executeTask(request));
    }



}



