package controller;


import connection.ConnectionPoolException;

public interface Command {

    String execute(String request);


}