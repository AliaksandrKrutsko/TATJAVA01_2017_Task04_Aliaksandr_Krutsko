package dao;

import bean.Book;
import bean.Movie;
import bean.Music;
import bean.News;
import connection.ConnectionPool;
import connection.ConnectionPoolException;
import helper.Config;

import java.io.IOException;
import java.sql.*;

public class SQLNewsDao implements NewsDao {


    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public News showNewsBaseRow (int key) throws DaoException {


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

            if (con != null || rs != null || ps != null) {
                ConnectionPool.getInstance().closeConnection(con, ps, rs);
            }
        }
    }



    public void addNews(News news) throws DaoException {


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

            if (con != null || rs != null || ps != null) {
                ConnectionPool.getInstance().closeConnection(con, ps, rs);
            }
        }

    }


    public void addMovie(Movie movie) throws DaoException {


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

            if (con != null || rs != null || ps != null) {
                ConnectionPool.getInstance().closeConnection(con, ps, rs);
            }
        }

    }


    public void addBook(Book book) throws DaoException {

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

            if (con != null || rs != null || ps != null) {
                ConnectionPool.getInstance().closeConnection(con, ps, rs);
            }
        }

    }

    public void addMusic(Music music) throws DaoException {

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

                if (con != null || rs != null || ps != null) {
                    ConnectionPool.getInstance().closeConnection(con, ps, rs);
                }
            }

    }

    @Override
    public News searchNewsByName(String name) throws DaoException {


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
            if (con != null || rs != null || ps != null) {
                ConnectionPool.getInstance().closeConnection(con, ps, rs);
            }
            return news;
        }

    }

}




