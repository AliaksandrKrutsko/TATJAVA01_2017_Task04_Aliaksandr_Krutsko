package controller;


import controller.command.AddNews;
import controller.command.SearchNewsByName;
import controller.command.ShowNewsBaseRow;


public class Controller {

    public void executeTask(String request){

        String command;
        command = request.toUpperCase();

        switch(command){

            case "ADD NEWS":
                AddNews addNews = new AddNews();
                addNews.execute(command);

                break;


            case "SHOW NEWSBASE":

                    ShowNewsBaseRow row = new ShowNewsBaseRow();
                    row.execute(command);

                break;

            case "SEARCH":

                SearchNewsByName search = new SearchNewsByName();
                search.execute(command);

                break;


            default:
                System.out.println("Cannot execute this command");

        }

    }




}
