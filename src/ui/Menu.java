package ui;

import java.util.Random;

import estoque.Estoque;
import estoque.Produto;
import hack.Hack;
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
        switch (input.inputInt())
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
            case 7: //ANCHOR
                criaProdutoHack();
                //Hack hack = new Hack();
                //hack.criaProduto(input, estoque);
            default:
                break;
        }
    }


    public void adicionaNovoProduto()
    {
        System.out.println("Inserir nome do Produto");
        String nome = input.inputString();
        System.out.println("Inserir quantidade do Produto");
        int qnt = input.inputInt();
        System.out.println("Inserir quantidade minima do Produto");
        int qntMinima = input.inputInt();
        System.out.println("Preco do Produto");
        double preco = input.inputDouble();

        Produto produto = new Produto(nome, qnt, qntMinima, preco);
        estoque.inserirNovoProduto(produto);
        menuInicial();
    }

    public Produto manipulacaoDeQuantidades()
    {
        System.out.println("Qual produto voce gostaria de selecionar? (SELECIONE PELO CODIGO)");
        estoque.listarProdutos();
        //ADIONAR NO INPUT UM RECEBIMENTO DE PARAMETRO, ESSE PARAMETRO IRA DECIDIR ATE QUE NUMERO PODEMOS INSERIR NO INPUT, CASO UM NUMERO ERRADO, EXCEPTION
        return estoque.selecionarProduto(input.inputInt());
    }

    public void adicionarQuantidade(Produto produtoSelecionado)
    {
        System.out.println("Quantidade do produto " +produtoSelecionado.getNome()+ " a ser adionada: ");
        int quantidade = input.inputInt();
        estoque.inserirQuantidadeEstoque(produtoSelecionado, quantidade);
        System.out.println("ADICIONADO(A) " +quantidade+ " UN PARA " +produtoSelecionado.getNome().toUpperCase() +"\nTOTAL: " +produtoSelecionado.getQnt());
    }

    public void retirarQuantidade(Produto produtoSelecionado)
    {
        System.out.println("Quantidade do produto " +produtoSelecionado.getNome()+ " a ser removida: ");
        int quantidade = input.inputInt();
        estoque.retirarQuantidadeEstoque(produtoSelecionado, quantidade);
        System.out.println("RETIRADO(A) " +quantidade+ " UN PARA " +produtoSelecionado.getNome().toUpperCase() +"\nTOTAL: " +produtoSelecionado.getQnt());
    }

    private void mostraProdutosAbaixo()
    {
        //TODO
    }

    public void criaProdutoHack()
    {
        Random random = new Random();

        for (int i = 0; i < 30; i++)
        {
            int numeroAleatorio = random.nextInt(5) + 1;
            int numeroAleatorio1 = random.nextInt(100);
            if(numeroAleatorio == 1)
            {
                Produto p = new Produto("calcinha", numeroAleatorio1, 1, 24);
                estoque.inserirNovoProduto(p);
            }
            else if(numeroAleatorio == 2)
            {
                Produto p = new Produto("moletom", numeroAleatorio1, 23, 65);
                estoque.inserirNovoProduto(p);
            }
            else if(numeroAleatorio == 3)
            {
                Produto p = new Produto("camisa", numeroAleatorio1, 3, 45);
                estoque.inserirNovoProduto(p);
            }
            else if(numeroAleatorio == 4)
            {
                Produto p = new Produto("camiseta", numeroAleatorio1, 4, 30);
                estoque.inserirNovoProduto(p);
            }
            else
            {
                Produto p = new Produto("tenis", numeroAleatorio1, 2, 50);
                estoque.inserirNovoProduto(p);
            }
        }
        menuInicial();
    }
}