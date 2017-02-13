package service;


import bean.Book;
import bean.Movie;
import bean.Music;
import bean.News;

public interface NewsService {

    String showNewsBaseRow(int key) throws ServiceException;

    void addNews(News news) throws ServiceException;
    void addMovie(Movie movie) throws ServiceException;
    void addBook(Book book) throws ServiceException;
    void addMusic(Music music) throws ServiceException;

    String searchNewsByName(String name) throws ServiceException;





}

