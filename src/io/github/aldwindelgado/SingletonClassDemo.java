package io.github.aldwindelgado;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This is a sample demonstration of how to apply the singleton pattern
 *
 * @author Aldwin Delgado on Apr 08, 2020
 */
public class SingletonClassDemo {

    public static void main(String[] args) {
        SingletonClass singletonClass = SingletonClass.getInstance();

        long timeBefore = 0;
        long timeAfter = 0;

        System.out.println(singletonClass);

        timeBefore = System.currentTimeMillis();
        Connection connection = singletonClass.getConnection();
        timeAfter = System.currentTimeMillis();

        System.out.println("Before instantiating the 'connection' variable");
        System.out.println("Startup time of 'connection': " + (timeAfter - timeBefore) + "ms");

        Statement statement;
        try {
            statement = connection.createStatement();
            int count = statement
                .executeUpdate(
                    "CREATE TABLE address (id INT, street VARCHAR(50), city VARCHAR(50))");
            System.out.println("Table created!");
            statement.close();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        timeBefore = System.currentTimeMillis();
        connection = singletonClass.getConnection();
        timeAfter = System.currentTimeMillis();

        System.out.println("After instantiating the 'connection' variable");
        System.out.println("Startup time of 'connection': " + (timeAfter - timeBefore) + "ms");

        // this simple experiment shows us that singleton pattern provides enhanced system performance if used correctly :)
    }
}
