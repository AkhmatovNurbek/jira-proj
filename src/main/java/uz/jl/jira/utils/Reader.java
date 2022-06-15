package uz.jl.jira.utils;

import java.util.Scanner;

public class Reader {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine() {
        return scanner.nextLine();
    }

    public static String readLine(String placeHolder) {
        return readLine(placeHolder, Color.BLUE);
    }

    public static String readLine(String placeHolder, String color) {
        Writer.print(color + placeHolder + Color.RESET);
        return readLine();
    }

}