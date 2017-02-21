package com.company.catalog.controller;


import com.company.catalog.bean.Request;

public interface Command {

    String execute(Request request);


}