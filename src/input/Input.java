package input;

import java.util.Scanner;

public class Input
{
    private Scanner sc = new Scanner(System.in);

    public String inputString()
    {
        return sc.next();
    }

    public int inputInt()
    {
        return sc.nextInt();
    }

    public double inputDouble()
    {
        return sc.nextDouble();
    }
}