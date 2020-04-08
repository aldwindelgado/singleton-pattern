package io.github.aldwindelgado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Aldwin Delgado on Apr 08, 2020
 */
public class SingletonPattern {

    /*  volatile = new to Java; marks this class to remain a singleton all throughout the duration
        this app is running
     */
    private static volatile SingletonPattern instance = null;
    private static volatile Connection connection = null;

    // avoid people to instantiating the class outside the created method 'getInstance()'
    private SingletonPattern() {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        // avoid this class to be implemented using Reflections
        if (connection != null) {
            throw new RuntimeException("Use 'getConnection()' method to instantiate");
        }

        // avoid this class to be implemented using Reflections
        if (instance != null) {
            throw new RuntimeException("Use 'getInstance()' method to instantiate");
        }
    }

    // return the instantiated class
    public static SingletonPattern getInstance() {
        /*  make the singleton implementation lazily loaded by instantiating the class
            IF and ONLY IF the 'instance' variable IS NULL and not instantiated anywhere else
         */
        if (instance == null) {
            /* marks this class thread-safe and will not instantiate another SingletonClass
               once it created one even if two threads are racing to instantiate this class
            */
            synchronized (SingletonPattern.class) {
                if (instance == null) {
                    instance = new SingletonPattern();
                }
            }
        }

        return instance;
    }

    // return the instantiated class
    public Connection getConnection() {
        /*  make the singleton implementation lazily loaded by instantiating the class
            IF and ONLY IF the 'instance' variable IS NULL and not instantiated anywhere else
         */
        if (connection == null) {
            /* marks this class thread-safe and will not instantiate another SingletonClass
               once it created one even if two threads are racing to instantiate this class
            */
            synchronized (SingletonPattern.class) {
                if (connection == null) {
                    try {
                        String dbUrl = "jdbc:derby:memory:testjava/testdb;create=true";

                        connection = DriverManager.getConnection(dbUrl);
                    } catch (SQLException sqlEx) {
                        sqlEx.printStackTrace();
                    }
                }
            }
        }

        return connection;
    }
}
