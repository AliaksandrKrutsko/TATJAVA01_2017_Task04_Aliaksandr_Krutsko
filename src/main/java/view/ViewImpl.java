package view;

import controller.ControllerFactory;
import controller.Controller;

import java.util.Scanner;

public class ViewImpl implements View {


    @Override
    public void enterCommand() {

        Scanner scanner = new Scanner(System.in);
        String request = scanner.nextLine();


        ControllerFactory controllerFactory = ControllerFactory.getInstance();
        Controller controller = controllerFactory.getController();

        controller.executeTask(request);

    }
}
