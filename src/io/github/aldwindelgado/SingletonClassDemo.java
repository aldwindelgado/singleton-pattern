package io.github.aldwindelgado;

/**
 * This is a sample demonstration of how to apply the singleton pattern
 *
 * @author Aldwin Delgado on Apr 08, 2020
 */
public class SingletonClassDemo {

    public static void main(String[] args) {
        SingletonClass singletonClass = SingletonClass.getInstance();

        // should produce a hashcode of the SingletonClass
        System.out.println(singletonClass);

        SingletonClass anotherSingletonClass = SingletonClass.getInstance();

        // should produce the same hashcode @ line 13; :)
        System.out.println(anotherSingletonClass);
    }
}
