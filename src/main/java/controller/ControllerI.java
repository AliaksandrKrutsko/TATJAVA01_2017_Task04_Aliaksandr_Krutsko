package controller;



import dao.DaoException;

import java.io.IOException;

public class ControllerI {

    private final CommandProvider provider = new CommandProvider();

    private final char paramDelimeter = ' ';

    public String executeTask(String request) throws IOException, DaoException {

        String commandName;
        Command executionCommand;
        commandName = request.toUpperCase();
                //substring(0, request.indexOf(paramDelimeter));//somehow it doesn't work
        executionCommand = provider.getCommand(commandName);
        String response;
        response = executionCommand.execute(request);
        return response;

    }



}
