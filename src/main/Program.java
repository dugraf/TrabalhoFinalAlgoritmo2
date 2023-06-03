package main;
import estoque.Estoque;
import input.Input;
import ui.Menu;

public class Program
{
    public static void main(String[] args)
    {
        Estoque estoque = new Estoque();
        Menu menu = new Menu();
        menu.menuInicial();
    }
}