package com.company.catalog.service;


import com.company.catalog.bean.Book;
import com.company.catalog.bean.Movie;
import com.company.catalog.bean.Music;
import com.company.catalog.bean.News;

public interface NewsService {

    String showNewsBaseRow(int key) throws ServiceException;

    void addNews(News news) throws ServiceException;
    void addMovie(Movie movie) throws ServiceException;
    void addBook(Book book) throws ServiceException;
    void addMusic(Music music) throws ServiceException;

    String searchNewsByName(String name) throws ServiceException;





}

