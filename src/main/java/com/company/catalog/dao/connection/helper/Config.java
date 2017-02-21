package com.company.catalog.dao.connection.helper;


import java.io.InputStream;
import java.util.Properties;

public class Config {


    private static Properties config = new Properties();

    private static InputStream is = Config.class.getResourceAsStream("/config.properties");

    static {

        try{
            config.load(is);

        } catch (Exception e){
            System.out.println("Error reading from property file");

        }
    }


    public static String jdbcDriver() {
        return config.getProperty("JDBC_DRIVER");
    }

    public static String dbUrl() {
        return config.getProperty("DB_URL");

    }

    public static String user() {
        return config.getProperty("USER");
    }

    public static String pass() {
        return config.getProperty("PASS");
    }
    public static String poolsize() {return config.getProperty("DB_POLL_SIZE");}


}
