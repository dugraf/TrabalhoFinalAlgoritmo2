package estoque;

import java.util.ArrayList;

public class Estoque
{
    private ArrayList<Produto> estoque = new ArrayList<Produto>();
    
    public void inserirNovoProduto(Produto produto)
    {
        estoque.add(produto);
        atualizaCodigoProduto(produto);
    }

    public void atualizaCodigoProduto(Produto produto)
    {
        if(estoque.size() > 1)
            produto.setCodigo(estoque.size() + 1);
        produto.setCodigo(estoque.size());
    }

    public void inserirQuantidadeEstoque(Produto produto, int quantidade)
    {
        produto.setQnt(produto.getQnt() + quantidade);
    }

    public void retirarQuantidadeEstoque(Produto produto, int quantidade) {
        if(quantidade <= produto.getQnt())
            produto.setQnt(produto.getQnt() - quantidade);
    }

    public Produto selecionarProduto(int input)
    {
        return estoque.get(input - 1);
    }

    public void listarProdutos()
    {
        for (int i = 0; i < estoque.size(); i++)
            System.out.println(estoque.get(i));
        System.out.println("\n");
    }

    public void produtosAbaixo()
    {
        ArrayList<Produto> produtosAbaixo = new ArrayList<Produto>();

        for (int i = 0; i < estoque.size(); i++)
        {
            int quantidadeAtual = estoque.get(i).getQnt();
            int quantidadeMinima = estoque.get(i).getQntMinima();
            if(estaAbaixo(quantidadeAtual, quantidadeMinima))
                produtosAbaixo.add(estoque.get(i));
        }
        listarProdutosAbaixo(produtosAbaixo);
    }

    public void listarProdutosAbaixo(ArrayList<Produto> produtosAbaixo)
    {
        for (int i = 0; i < produtosAbaixo.size(); i++)
            System.out.println(produtosAbaixo.get(i));
        System.out.println("\n");
    }

    public boolean estaAbaixo(int quantidadeAtual, int quantidadeMinima)
    {
        if(quantidadeAtual <= quantidadeMinima)
            return true;
        return false;
    }

    public boolean temProdutos() {
        return estoque.size() != 0;
    }

    public boolean temCodigo(int codigo) {
        return codigo <= 1 && codigo >= estoque.size();
    }

    public Object get(int i) {
        return null;
    }
}
