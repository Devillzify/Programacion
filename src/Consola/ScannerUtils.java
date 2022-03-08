package Consola;

import java.util.Scanner;

public class ScannerUtils
{
    private static Scanner sc = new Scanner(System.in);


    public static int getIntShowingText(String text)
    {
        System.out.println(text);
        int result = sc.nextInt();
        sc.nextLine();
        return result;
    }
    public static String getStringShowingText(String text)
    {
        System.out.println(text);
        return sc.nextLine();
    }
}

