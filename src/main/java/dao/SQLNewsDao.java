package dao;

import bean.Book;
import bean.Movie;
import bean.Music;
import bean.News;
import helper.Config;

import java.io.IOException;
import java.sql.*;

public class SQLNewsDao implements NewsDao {


    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    private static final String JDBC_DRIVER = Config.jdbcDriver();
    private static final String DB_URL = Config.dbUrl();
    private static final String USER = Config.user();
    private static final String PASS = Config.pass();




    public void connect() throws DaoException {

        try {

            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("connection established...");
        } catch (ClassNotFoundException e) {
            throw new DaoException("Class Not Found");
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
//        } finally {
//            try {
//                if (con != null) {con.close();}
//                if (rs !=null) {rs.close();}
//            }
//            catch (SQLException e) {
//                throw new DaoException(e.getMessage());
//            }
        }


    }


    public News showNewsBaseRow (int key) throws DaoException {


        String sql = "SELECT * FROM news WHERE news_id = ?;";
        News news = new News();
        try {

            if (con == null) {
                connect();
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
        }
        catch (NullPointerException e) {
            throw new DaoException("There's no such row");
        }


    }



    public void addNews(News news) throws DaoException {


        try {
            if (con == null) {
            connect();}
            String sql = "INSERT INTO news (name, category, content) VALUES(?, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, news.getName());
            ps.setString(2, news.getCategory());
            ps.setString(3, news.getContent());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }


    public void addMovie(Movie movie) throws DaoException {


        try {
            if (con == null) {
                connect();
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

    }


    public void addBook(Book book) throws DaoException {

        try {
            if (con == null) {
                connect();
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

    }

    public void addMusic(Music music) throws DaoException {

        try {
            if (con == null) {
                connect();
            }
            String sql = "INSERT INTO music (name, band, year) VALUES(?, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, music.getName());
            ps.setString(2, music.getBand());
            ps.setInt(3, music.getYear());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public News searchNewsByName(String name) throws DaoException {


        News news = new News();
        try {
            if (con == null) {
                connect();
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
        finally {
            return news;
        }

    }

}




