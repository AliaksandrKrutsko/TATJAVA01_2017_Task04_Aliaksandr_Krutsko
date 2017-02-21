package com.company.catalog.controller;


import com.company.catalog.bean.*;

public interface Command {

    String execute(Request request);



}