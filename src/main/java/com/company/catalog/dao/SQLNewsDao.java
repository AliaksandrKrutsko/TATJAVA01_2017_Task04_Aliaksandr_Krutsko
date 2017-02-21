package com.company.catalog.dao;

import com.company.catalog.bean.Book;
import com.company.catalog.bean.Movie;
import com.company.catalog.bean.Music;
import com.company.catalog.bean.News;
import com.company.catalog.dao.connection.ConnectionPool;
import com.company.catalog.dao.connection.ConnectionPoolException;

import java.sql.*;

public class SQLNewsDao implements NewsDao {




    public News showNewsBaseRow (int key) throws DaoException {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;


        String sql = "SELECT * FROM news WHERE news_id = ?;";
        News news = new News();
        try {


            if (con == null) {
                con = ConnectionPool.getInstance().takeConnection();

            }

            ps = con.prepareStatement(sql);

            ps.setInt(1, key);

            rs = ps.executeQuery();
            rs.next();

            news.setName(rs.getString("name"));
            news.setCategory(rs.getString("category"));
            news.setContent(rs.getString("content"));

            return news;


        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        } catch (NullPointerException e) {
            throw new DaoException("There's no such row");
        } catch (ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        } finally {

                ConnectionPool.getInstance().closeConnection(con, ps, rs);

        }
    }



    public void addNews(News news) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;


        try {
            if (con == null) {
                con = ConnectionPool.getInstance().takeConnection();
            }
            String sql = "INSERT INTO news (name, category, content) VALUES(?, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, news.getName());
            ps.setString(2, news.getCategory());
            ps.setString(3, news.getContent());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        catch (ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }
        finally {

                ConnectionPool.getInstance().closeConnection(con, ps);

        }

    }


    public void addMovie(Movie movie) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;


        try {
            if (con == null) {
                con = ConnectionPool.getInstance().takeConnection();
            }
            String sql = "INSERT INTO movie (name, director, genre, year) VALUES(?, ?, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, movie.getName());
            ps.setString(2, movie.getDirector());
            ps.setString(3, movie.getGenre());
            ps.setInt(4, movie.getYear());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        catch (ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        } finally {

                ConnectionPool.getInstance().closeConnection(con, ps);

        }

    }


    public void addBook(Book book) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;

        try {
            if (con == null) {
                con = ConnectionPool.getInstance().takeConnection();
            }
            String sql = "INSERT INTO book (name, author, year) VALUES(?, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getYear());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        catch (ConnectionPoolException e) {
            throw new DaoException(e.getMessage());
        }finally {

                ConnectionPool.getInstance().closeConnection(con, ps);

        }

    }

    public void addMusic(Music music) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;

        try {
            if (con == null) {
                con = ConnectionPool.getInstance().takeConnection();
            }
            String sql = "INSERT INTO music (name, band, year) VALUES(?, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, music.getName());
            ps.setString(2, music.getBand());
            ps.setInt(3, music.getYear());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        } catch (ConnectionPoolException e) {
            throw new DaoException(e.getMessage());}
            finally {

                    ConnectionPool.getInstance().closeConnection(con, ps);

            }

    }

    @Override
    public News searchNewsByName(String name) throws DaoException {

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;


        News news = new News();
        try {
            if (con == null) {
                con = ConnectionPool.getInstance().takeConnection();
            }
            String sql = "SELECT name, category, content FROM news WHERE name LIKE '%" + name + "%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                news.setName(rs.getString("name"));
                news.setCategory(rs.getString("category"));
                news.setContent(rs.getString("content"));

            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        catch (ConnectionPoolException e) {
            throw new DaoException(e.getMessage());}
        finally {

                ConnectionPool.getInstance().closeConnection(con, ps, rs);
                return news;
        }

    }

}




