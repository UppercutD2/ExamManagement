package Utils;

import java.util.Scanner;

public class Scanner_Utils {
    public static Scanner console = new Scanner(System.in);




    public static String requireString(String s)
    {
        System.out.print(s);
        return console.nextLine();
    }




}
