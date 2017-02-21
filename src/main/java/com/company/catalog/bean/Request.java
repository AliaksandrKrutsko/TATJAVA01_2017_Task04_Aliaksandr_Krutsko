package com.company.catalog.bean;


import java.io.Serializable;

public class Request implements Serializable {

    private String command;
    private int key;
    private String search;
    private String category;



    public Request() {

    }

    public String getCommand() {return command;}
    public String getSearch() {return search;}
    public int getKey() {return key;}
    public String getCategory() {return category;}


    public void setCommand(String command) {this.command = command;}
    public void setKey(int key) {this.key=key;}
    public void setSearch(String  search) {this.search = search;}
    public void setCategory(String category) {this.category = category;}




}
