package service;

import bean.Book;
import bean.Movie;
import bean.Music;
import bean.News;
import dao.DaoException;
import dao.DaoFactory;
import dao.NewsDao;

import java.io.IOException;


public class NewsServiceImpl implements NewsService {

    @Override
    public String showNewsBaseRow(int key) throws ServiceException {


        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        NewsDao newsDao = daoObjectFactory.getNewsDao();
        try {

            return newsDao.showNewsBaseRow(key).toString();

        } catch (DaoException e) {
           throw new ServiceException(e.getMessage());
        }


    }

    public void addNews(News news) throws ServiceException {


        try {
            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            NewsDao newsDao = daoObjectFactory.getNewsDao();
            newsDao.addNews(news);
        }
        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }


    }

    public void addMovie(Movie movie) throws ServiceException {
        try {
            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            NewsDao newsDao = daoObjectFactory.getNewsDao();
            newsDao.addMovie(movie);
        }
        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }
    }

    public void addBook(Book book) throws ServiceException {
        try {
            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            NewsDao newsDao = daoObjectFactory.getNewsDao();
            newsDao.addBook(book);
        }
        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }
    }

    public void addMusic(Music music) throws ServiceException {
        try {
            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            NewsDao newsDao = daoObjectFactory.getNewsDao();
            newsDao.addMusic(music);
        }
        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public String searchNewsByName(String name) throws ServiceException {


            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            NewsDao newsDao = daoObjectFactory.getNewsDao();
        try {
            return newsDao.searchNewsByName(name).toString();
        }

        catch (DaoException e){
            throw new ServiceException(e.getMessage());
        }

    }


}