package hack;

import java.util.Random;

import estoque.Estoque;
import estoque.Produto;
import input.Input;
import ui.Menu;

public class Hack //TODO
{
    Random random = new Random();
    Menu menu = new Menu();
    
    public void criaProduto(Input input, Estoque estoque)
    {
        int numeroAleatorio = random.nextInt(5) + 1;
        int numeroAleatorio1 = random.nextInt(100);
        if(numeroAleatorio == 1)
        {
            Produto p = new Produto("calcinha", numeroAleatorio1, 1, 24);
            estoque.inserirNovoProduto(p);
            menu.menuInicial();
        }
        else if(numeroAleatorio == 2)
        {
            Produto p = new Produto("moletom", numeroAleatorio1, 23, 65);
            estoque.inserirNovoProduto(p);
            menu.menuInicial();
        }
        else if(numeroAleatorio == 3)
        {
            Produto p = new Produto("camisa", numeroAleatorio1, 3, 45);
            estoque.inserirNovoProduto(p);
            menu.menuInicial();
        }
        else if(numeroAleatorio == 4)
        {
            Produto p = new Produto("camiseta", numeroAleatorio1, 4, 30);
            estoque.inserirNovoProduto(p);
            menu.menuInicial();
        }
        else
        {
            Produto p = new Produto("tenis", numeroAleatorio1, 2, 50);
            estoque.inserirNovoProduto(p);
            menu.menuInicial();
        }
    }
}
