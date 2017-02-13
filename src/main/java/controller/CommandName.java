package controller;


public class CommandName {

    public CommandName() {

    }

    public static CommandName ADD_NEWS;
    public static CommandName SHOW_NEWSBASE;
    public static CommandName WRONG_REQUEST;


    public static CommandName valueOf(String s) {
        return new CommandName();
    }
}
