package main;
import estoque.Estoque;
import ui.Menu;

public class Program
{
    public static void main(String[] args)
    {
        System.out.println("\n\nOBSERVACAO: Para total funcionamento do programa, verifique a presenca do diretorio 'C:\\temp' em usa maquina.");
        Estoque estoque = new Estoque();
        Menu menu = new Menu();
        menu.menuInicial();
    }
}