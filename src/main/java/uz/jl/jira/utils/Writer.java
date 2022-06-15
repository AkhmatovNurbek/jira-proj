package uz.jl.jira.utils;

import java.io.PrintStream;

/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/15:56 (Tuesday)
 * untitled/IntelliJ IDEA
 */
public class Writer {
    private static final PrintStream out = null;


    public static void print(Object data) {
        print(data, Color.BLUE);
    }

    public static void print(Object data, String color) {
        System.out.print(color + data + Color.RESET);
    }

    public static void println(Object data) {
        println(data, Color.BLUE);
    }

    public static void println(Object data, String color) {
        System.out.println(color + data + Color.RESET);
    }


}
