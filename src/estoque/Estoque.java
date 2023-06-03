package estoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque
{
    private ArrayList<Produto> estoque;
    
    public void inserirNovoProduto(Produto produto)
    {
        estoque.add(produto);
    }

    public void inserirQuantidadeEstoque() {
    }

    public void retirarQuantidadeEstoque() {
    }

    public void listarProdutos()
    {
        for (int i = 0; i < estoque.size(); i++)
            System.out.println(i);
    }

    public void listarProdutosAbaixo() {
    }

    
}
