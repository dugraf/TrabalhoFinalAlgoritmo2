package input;

import java.util.Scanner;

public class Input
{
    private static Scanner sc = new Scanner(System.in);

    public static String inputString(String texto)
    {
        System.out.println(texto);
        return sc.next();
    }

    public static int inputInt(String texto)
    {
        System.out.println(texto);
        return sc.nextInt();
    }

    public static double inputDouble(String texto)
    {
        System.out.println(texto);
        return sc.nextDouble();
    }
}