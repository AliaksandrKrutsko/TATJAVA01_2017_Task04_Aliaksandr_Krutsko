package com.company.catalog.service;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final NewsService newsService = new NewsServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public NewsService getNewsService(){
        return newsService;
    }


}
