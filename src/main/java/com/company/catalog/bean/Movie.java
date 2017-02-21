package com.company.catalog.bean;


import java.io.Serializable;

public class Movie implements Serializable{

    private String name;
    private String director;
    private String genre;
    private int year;

    public Movie() {

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + director.hashCode();
        result = prime * result + genre.hashCode();
        result = prime * result + year;
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
        Movie other = (Movie) obj;
        if (name != other.name)
            return false;
        if (director != other.director)
            return false;
        if (genre != other.genre)
            return false;
        if (year != other.year)
            return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {

        this.name = name;

    }

    public void setDirector (String director) {

        this.director = director;

    }

    public void setGenre (String genre) {

        this.genre = genre;

    }

    public void setYear(int year) {

        this.year = year;

    }

    public String toString() {
        return "name:" + this.name + "director: " + this.director + ", "
                + "genre: " + this.genre + ", " + "year: "
                + this.year;
    }






}
