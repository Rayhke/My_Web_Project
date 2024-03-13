package com.DB_Test;

public class MySQL_Connection_Info {
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/project";
    private final String JDBC_USER = "root";
    private final String JDBC_PASSWORD = "1234";

    public String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }
    public String getJDBC_URL() {
        return JDBC_URL;
    }
    public String getJDBC_USER() {
        return JDBC_USER;
    }
    public String getJDBC_PASSWORD() {
        return JDBC_PASSWORD;
    }
}