/**
 * Author - Hunter Chase
 * Title - Homework 2
 * Date - 10/10/2021
 * Class - CS2263
 * Instructor - Isaac Griffith
 */
/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.isu.cs2263.hw02;

/**
 * This App is used to provide a GUI that looks at students and the courses that they have.
 * @Author Hunter Chase
 * @Version %I%, %G%
 */
public class App{

    /**
     * Singleton instance for main app
     */
    public App() {
            // private constructor
        }
        // Inner class to provide instance of class
        private static class singleApp {
            private static final App INSTANCE = new App();
        }
        public static App instance () {
            return singleApp.INSTANCE;
        }

    /**
     * App main that opens javaFX program
     * @param args
     */
    public static void main(String[] args) {
        FX.classApp(args);
    }
}
