package ui;

import estoque.Estoque;
import estoque.Produto;
import input.Input;

public class Menu
{
    Input input = new Input();
    Estoque estoque = new Estoque();

    public void menuInicial()
    {
        while(true)
        {
            System.out.println("****************\nESTOQUE DUS GURI\n****************");

            System.out.println("\n\n1. INSERIR PRODUTO\n2. ADICIONAR QUANTIDADES DE PRODUTOS NO ESTOQUE\n3. RETIRAR QUANTIDADE DE PRODUTOS NO ESTOQUE\n4. LISTAR TODOS OS PRODUTOS\n5. LISTAR PRODUTOS QUE ESTAO ABAIXO DO ESTOQUE\n6. SAIR");
    
            escolhas();
        }
    }

    public void escolhas()
    {
        switch (input.inputInt(""))
        {
            case 1:
                adicionaNovoProduto();
                break;
            case 2:
                Produto produtoQntAdicionada = manipulacaoDeQuantidades();
                adicionarQuantidade(produtoQntAdicionada);
                break;
            case 3:
                Produto produtoQntRemovida = manipulacaoDeQuantidades();
                retirarQuantidade(produtoQntRemovida);
                break;
            case 4:
                estoque.listarProdutos();
                break;
            case 5:
                //mostraProdutosAbaixo();
                estoque.produtosAbaixo();;
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Digite um número válido! ");
                break;
        }
    }


    public void adicionaNovoProduto()
    {
        String nome = input.inputString("Inserir nome do Produto");
        int qnt = input.inputInt("Inserir quantidade do Produto");
        int qntMinima = input.inputInt("Inserir quantidade minima do Produto");
        double preco = input.inputDouble("Preco do Produto");

        Produto produto = new Produto(nome, qnt, qntMinima, preco);
        estoque.inserirNovoProduto(produto);
        menuInicial();
    }

    public Produto manipulacaoDeQuantidades()
    {
        System.out.println("Qual produto voce gostaria de selecionar? (SELECIONE PELO CODIGO)");
        estoque.listarProdutos();

        return estoque.selecionarProduto(input.inputInt(""));
    }

    public void adicionarQuantidade(Produto produtoSelecionado)
    {
        int quantidade = input.inputInt("Quantidade do produto " +produtoSelecionado.getNome()+ " a ser adionada: ");
        estoque.inserirQuantidadeEstoque(produtoSelecionado, quantidade);
        System.out.println("ADICIONADO(A) " +quantidade+ " UN PARA " +produtoSelecionado.getNome().toUpperCase() +"\nTOTAL: " +produtoSelecionado.getQnt());
    }

    public void retirarQuantidade(Produto produtoSelecionado)
    {
        int quantidade = input.inputInt("Quantidade do produto " +produtoSelecionado.getNome()+ " a ser removida: ");
        estoque.retirarQuantidadeEstoque(produtoSelecionado, quantidade);
        System.out.println("RETIRADO(A) " +quantidade+ " UN PARA " +produtoSelecionado.getNome().toUpperCase() +"\nTOTAL: " +produtoSelecionado.getQnt());
    }

    private void mostraProdutosAbaixo()
    {
        //TODO
    }
}