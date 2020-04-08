package io.github.aldwindelgado;

/**
 * @author Aldwin Delgado on Apr 08, 2020
 */
public class SingletonClass {

    private static SingletonClass instance = null;

    // avoid people to instantiating the class outside the created method 'getInstance()'
    private SingletonClass() {
    }

    // return the instantiated class
    public static SingletonClass getInstance() {
        /*  make the singleton implementation lazily loaded by instantiating the class
            IF and ONLY IF the 'instance' variable IS NULL
         */
        if (instance == null) {
            instance = new SingletonClass();
        }

        return instance;
    }

}
