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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + category.hashCode();
        result = prime * result + command.hashCode();
        result = prime * result + search.hashCode();
        result = prime * result + key;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Request other = (Request) obj;
        if (category != other.category)
            return false;
        if (command != other.command)
            return false;
        if (search != other.search)
            return false;
        if (key != other.key)
            return false;
        return true;
    }



}
