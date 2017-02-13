package controller.command;
import bean.Book;
import bean.Movie;
import bean.Music;
import bean.News;


import controller.Command;
import service.NewsService;
import service.ServiceException;
import service.ServiceFactory;


import java.util.Scanner;


public class AddNews implements Command {



    private String name = null;
    private String response;


    private String addMovie() {

        Movie movie =  new Movie();
        Scanner scanner = new Scanner(System.in);

        movie.setName(name);
        System.out.println("Enter director: ");
        movie.setDirector(scanner.nextLine());
        System.out.println("Enter genre: ");
        movie.setGenre(scanner.nextLine());
        System.out.println("Enter year: ");
        movie.setYear(scanner.nextInt());

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {

            newsService.addMovie(movie);
            response = "movie was added";

        }
        catch (ServiceException e) {
            response = "movie wasn't added";
        }
        return response;


    }

    private String addBook() {

        Book book = new Book();
        Scanner scanner = new Scanner(System.in);

        book.setName(name);
        System.out.println("Enter author of the book: ");
        book.setAuthor(scanner.nextLine());

        System.out.println("Enter year: ");
        book.setYear(scanner.nextInt());

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {

            newsService.addBook(book);
            response = "book was added";

        }
        catch (ServiceException e) {
            response = "book wasn't added";
        }

        return response;
    }

    private String addMusic() {

        Music music = new Music();
        Scanner scanner = new Scanner(System.in);

        music.setName(name);
        System.out.println("Enter name of the band: ");
        music.setBand(scanner.nextLine());

        System.out.println("Enter year: ");
        music.setYear(scanner.nextInt());

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {

            newsService.addMusic(music);
            response = "music disc was added";

        }
        catch (ServiceException e) {
            response = "music disc wasn't added";
        }

        return response;
    }



    public String execute(String request) {

        News news = new News();


        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to add? (Enter: movie/book/music) ");
        String category = scanner.nextLine();
        category = category.toUpperCase();

        switch (category) {
            case "MOVIE":
            System.out.println("Enter name of movie: ");
            name = scanner.nextLine();
                break;
            case "BOOK":
                System.out.println("Enter name of the book: ");
                name = scanner.nextLine();
                break;
            case "MUSIC":
                System.out.println("Enter name of the album: ");
                name = scanner.nextLine();
                break;
        }


        news.setName(name);
        news.setCategory(category);
        System.out.println("Enter content: ");
        news.setContent(scanner.nextLine());

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        switch (category) {

            case "MOVIE":
                try {

                    addMovie();
                    newsService.addNews(news);
                    response = "your news was added";

                } catch (ServiceException e) {

                    response = "something went wrong";
                }
                break;

            case "BOOK":

                try {

                    addBook();
                    newsService.addNews(news);
                    response = "your news was added";

                } catch (ServiceException e) {

                    response = "something went wrong";
                }

                break;

            case "MUSIC":

                try {

                    addMusic();
                    newsService.addNews(news);
                    response = "your news was added";

                } catch (ServiceException e) {

                    response = "something went wrong";
                }
                break;

        }


        return response;

    }


}