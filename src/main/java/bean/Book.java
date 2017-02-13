package bean;


import java.io.Serializable;

public class Book implements Serializable {

    private String name;
    private String author;
    private int year;

    public Book() {

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + author.hashCode();
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
        Book other = (Book) obj;
        if (name != other.name)
            return false;
        if (author != other.author)
            return false;
        if (year != other.year)
            return false;
        return true;
    }

    public String getName() {return name;}

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor (String author) {

        this.author = author;

    }



    public void setYear(int year) {

        this.year = year;

    }

    public String toString() {
        return "author: " + this.author + ", " + "name: " + this.name + ", " + "year: "
                + this.year;
    }







}
