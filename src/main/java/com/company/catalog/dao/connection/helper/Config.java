package com.company.catalog.dao.connection.helper;


import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config {

    private static Logger log = Logger.getLogger(Config.class.getName());
    private static Properties config = new Properties();

    private static InputStream is = Config.class.getResourceAsStream("/config.properties");

    static {

        try{
            config.load(is);

        } catch (Exception e){
            log.log(Level.SEVERE, "properties file not found");
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
