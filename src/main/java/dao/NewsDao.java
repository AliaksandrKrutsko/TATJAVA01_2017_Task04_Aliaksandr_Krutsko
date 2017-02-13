package dao;


import bean.Book;
import bean.Movie;
import bean.Music;
import bean.News;

import java.io.IOException;

public interface NewsDao {


    News showNewsBaseRow(int key) throws DaoException;

    void addNews(News news) throws DaoException;
    void addMovie(Movie movie) throws DaoException;
    void addBook(Book book) throws DaoException;
    void addMusic(Music music) throws DaoException;

    News searchNewsByName(String name) throws DaoException;


}
