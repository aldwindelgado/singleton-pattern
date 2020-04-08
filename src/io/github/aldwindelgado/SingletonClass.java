package io.github.aldwindelgado;

/**
 * @author Aldwin Delgado on Apr 08, 2020
 */
public class SingletonClass {

    /*  volatile = new to Java; marks this class to remain a singleton all throughout the duration
        this app is running
     */
    private static volatile SingletonClass instance = null;

    // avoid people to instantiating the class outside the created method 'getInstance()'
    private SingletonClass() {
        // avoid this class to be implemented using Reflections
        if (instance != null) {
            throw new RuntimeException("Use 'getInstance()' method to instantiate");
        }
    }

    // return the instantiated class
    public static SingletonClass getInstance() {
        /*  make the singleton implementation lazily loaded by instantiating the class
            IF and ONLY IF the 'instance' variable IS NULL and not instantiated anywhere else
         */
        if (instance == null) {
            /* marks this class thread-safe and will not instantiate another SingletonClass
               once it created one even if two threads are racing to instantiate this class
            */
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }

        return instance;
    }

}
