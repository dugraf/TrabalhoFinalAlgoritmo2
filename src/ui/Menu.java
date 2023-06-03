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
        System.out.println("****************\nESTOQUE DUS GURI\n****************");

        System.out.println("\n\n1. INSERIR PRODUTO\n2. ADICIONAR QUANTIDADES DE PRODUTOS NO ESTOQUE\n3. RETIRAR QUANTIDADE DE PRODUTOS NO ESTOQUE\n4. LISTAR TODOS OS PRODUTOS\n5. LISTAR PRODUTOS QUE ESTAO ABAIXO DO ESTOQUE\n6. SAIR");

        escolhas();
    }

    public void escolhas()
    {
        while(true)
        {
            switch (input.inputInt())
            {
                case 1:
                    coletarInformacoesProduto();
                    break;
                case 2:
                    estoque.inserirQuantidadeEstoque();
                    break;
                case 3:
                    estoque.retirarQuantidadeEstoque();
                    break;
                case 4:
                    estoque.listarProdutos();
                    break;
                case 5:
                    estoque.listarProdutosAbaixo();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public void coletarInformacoesProduto()
    {
        System.out.println("Inserir nome do Produto");
        String nome = input.inputString();
        System.out.println("Inserir quantidade do Produto");
        int qnt = input.inputInt();
        System.out.println("Inserir quantidade minima do Produto");
        int qntMinima = input.inputInt();
        System.out.println("Preco do Produto");
        double preco = input.inputDouble();

        Produto produto = new Produto(nome, qnt, qntMinima, preco)
        estoque.inserirNovoProduto(produto);
        menuInicial();
    }
}