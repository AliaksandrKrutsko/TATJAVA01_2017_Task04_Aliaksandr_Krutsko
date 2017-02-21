package com.company.catalog.controller;


public class ControllerFactory {

    private static final ControllerFactory instance = new ControllerFactory();

    private final Controller controller = new Controller() {};
    private final ControllerTwo controllerTwo = new ControllerTwo() {};

    public static ControllerFactory getInstance() {return instance;}

    public Controller getController() {return controller;}
    public ControllerTwo getControllerTwo() {return controllerTwo;}




}
