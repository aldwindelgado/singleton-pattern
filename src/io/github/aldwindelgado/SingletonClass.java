package io.github.aldwindelgado;

/**
 * @author Aldwin Delgado on Apr 08, 2020
 */
public class SingletonClass {

    // instantiate the class one-time only
    private static SingletonClass instance = new SingletonClass();

    // avoid people to instantiating the class outside the created method 'getInstance()'
    private SingletonClass() {
    }

    // return the instantiated class
    public static SingletonClass getInstance() {
        return instance;
    }

}
