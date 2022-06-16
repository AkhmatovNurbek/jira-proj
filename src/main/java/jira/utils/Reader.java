package jira.utils;


import java.util.Scanner;

public class Reader {
    private static final Scanner scanner = new Scanner(System.in);

    public static String read() {
        return scanner.nextLine();
    }

    public static String read(String placeHolder) {
        return read(placeHolder,Color.BLUE);
    }

    public static String read(String placeHolder, String color) {
        Writer.print(color + placeHolder + Color.RESET);
        return read();
    }

}