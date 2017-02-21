package com.company.catalog.view;

import com.company.catalog.bean.Book;
import com.company.catalog.bean.Movie;
import com.company.catalog.bean.Music;
import com.company.catalog.bean.Request;
import com.company.catalog.controller.ControllerFactory;
import com.company.catalog.controller.ControllerTwo;

import java.util.Scanner;


public class ViewImpl implements View {


    @Override
    public void enterCommand() {
        Request request = new Request();

        Scanner scanner = new Scanner(System.in);
        request.setCommand(scanner.nextLine());
        String command = request.getCommand();

        if (command.equals("show_newsbase")) {
            System.out.println("Enter your row number");
            request.setKey(scanner.nextInt());
        } else if (command.equals("search_news")) {
            System.out.println("What are you searching for?");
            request.setSearch(scanner.nextLine());
        } else if (command.equals("add_news")) {
            System.out.println("Enter category: (movie/music/book)");
            request.setCategory(scanner.nextLine());
            String category = request.getCategory();
            System.out.println("Enter name: ");
            request.setName(scanner.nextLine());
            String name = request.getName();

            switch (category.toUpperCase()) {

                case "MOVIE":
                    request.setMovie(addMovie(name));
                    break;

                case "BOOK":
                    request.setBook(addBook(name));
                    break;

                case "MUSIC":
                    request.setMusic(addMusic(name));

            }

            System.out.println("Enter content: ");
            request.setContent(scanner.nextLine());



        }

        ControllerFactory controllerFactory = ControllerFactory.getInstance();
        ControllerTwo controllerTwo = controllerFactory.getControllerTwo();


        System.out.println(controllerTwo.executeTask(request));
    }

    private Movie addMovie(String name) {
        Movie movie =  new Movie();
        Scanner scanner = new Scanner(System.in);

        movie.setName(name);
        System.out.println("Enter director: ");
        movie.setDirector(scanner.nextLine());
        System.out.println("Enter genre: ");
        movie.setGenre(scanner.nextLine());
        System.out.println("Enter year: ");
        movie.setYear(scanner.nextInt());

        return movie;

    }

    private Book addBook(String name) {

        Book book = new Book();
        Scanner scanner = new Scanner(System.in);

        book.setName(name);
        System.out.println("Enter author of the book: ");
        book.setAuthor(scanner.nextLine());

        System.out.println("Enter year: ");
        book.setYear(scanner.nextInt());

        return book;


    }

    private Music addMusic(String name) {


        Music music = new Music();
        Scanner scanner = new Scanner(System.in);

        music.setName(name);
        System.out.println("Enter name of the band: ");
        music.setBand(scanner.nextLine());

        System.out.println("Enter year: ");
        music.setYear(scanner.nextInt());


        return music;
    }



}




