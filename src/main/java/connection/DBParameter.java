package connection;


import helper.Config;

public class DBParameter {

    private DBParameter(){}

    public static final String JDBC_DRIVER = Config.jdbcDriver();
    public static final String DB_URL = Config.dbUrl();
    public static final String USER = Config.user();
    public static final String PASS = Config.pass();
    public static final String DB_POLL_SIZE = Config.poolsize();




}
