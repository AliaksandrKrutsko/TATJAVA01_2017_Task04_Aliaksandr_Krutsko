package com.company.catalog.dao;


import com.company.catalog.bean.Book;
import com.company.catalog.bean.Movie;
import com.company.catalog.bean.Music;
import com.company.catalog.bean.News;

public interface NewsDao {


    News showNewsBaseRow(int key) throws DaoException;

    void addNews(News news) throws DaoException;
    void addMovie(Movie movie) throws DaoException;
    void addBook(Book book) throws DaoException;
    void addMusic(Music music) throws DaoException;

    News searchNewsByName(String name) throws DaoException;


}
