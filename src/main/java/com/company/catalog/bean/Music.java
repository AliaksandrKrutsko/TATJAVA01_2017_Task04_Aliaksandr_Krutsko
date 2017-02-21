package com.company.catalog.bean;

import java.io.Serializable;

public class Music implements Serializable {

    private String band;
    private String name;
    private int year;


    public Music() {

    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + band.hashCode();
        result = prime * result + name.hashCode();
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
        Music other = (Music) obj;
        if (band != other.band)
            return false;
        if (name != other.name)
            return false;
        if (year != other.year)
            return false;
        return true;
    }


    public String getBand() {
        return band;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public void setBand (String band) {

        this.band = band;

    }

    public void setName (String name) {

        this.name = name;

    }

    public void setYear(int year) {

        this.year = year;

    }

    public String toString() {
        return "band: " + this.band + ", "
                + "album: " + this.name + ", " + "year: "
                + this.year;
    }


}
