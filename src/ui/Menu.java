package ui;

import estoque.Estoque;
import estoque.Produto;
import input.Input;
import java.util.ArrayList;

import archives.ReadProdutos;

public class Menu {
    Estoque estoque = new Estoque();

    public void menuInicial() {
        while(true) {
            System.out.println("****************\nESTOQUE DUS GURI\n****************");
            System.out.println("\n\n1. INSERIR PRODUTO\n2. ADICIONAR QUANTIDADES DE PRODUTOS NO ESTOQUE\n3. RETIRAR QUANTIDADE DE PRODUTOS NO ESTOQUE\n4. LISTAR TODOS OS PRODUTOS\n5. LISTAR PRODUTOS QUE ESTAO ABAIXO DO ESTOQUE\n6. LER ARQUIVO (O ARQUIVO SE ENCONTRA EM: 'C:\\temp\\ReadProdutos\\') \n7. SAIR");

            escolhas();
        }
    }

    public void escolhas() {
        int var = Input.inputIntSemTexto();
        if(var < 1 || var > 7) {
            System.out.println("Digite um número válido!");
        } else {
            switch (var) {
                case 1:
                    adicionaNovoProduto();
                    break;
                case 2:
                    if(estoque.temProdutos()) {
                        Produto produtoQntAdicionada = manipulacaoDeQuantidades();
                        adicionarQuantidade(produtoQntAdicionada);
                    } else {
                        System.out.println("Não há produtos na loja.");
                    }
                    break;
                case 3:
                    if(estoque.temProdutos()) {
                        Produto produtoQntRemovida = manipulacaoDeQuantidades();
                        retirarQuantidade(produtoQntRemovida);
                    } else
                        System.out.println("Não há produtos na loja.");
                    break;
                case 4: 
                    estoque.listarProdutos();
                    break;
                case 5:
                    estoque.produtosAbaixo();
                    System.out.println("Produtos registrados no arquivo 'C:\\temp\\ReadProdutos\\listaAbaixo.txt'");
                    break;
                case 6:
                    ReadProdutos lerArquivo = new ReadProdutos();
                    ArrayList<Produto> produtosArquivo = lerArquivo.arquivo();
                    estoque.inserirNovoProdutoArray(produtosArquivo);
                    System.out.println("ARQUIVO LIDO E IMPORTADO PARA O SISTEMA, COM SUCESSO!");
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }


    public void adicionaNovoProduto() {
        String nome = Input.inputString("Inserir nome do Produto");
        int qnt = Input.inputInt("Inserir quantidade do Produto");
        int qntMinima = Input.inputInt("Inserir quantidade mínima do Produto");
        double preco = Input.inputDouble("Preço do Produto");

        Produto produto = new Produto(nome, qnt, qntMinima, preco);
        estoque.inserirNovoProduto(produto);
        menuInicial();
    }

    public Produto manipulacaoDeQuantidades() {
        estoque.listarProdutos();
        int var = Input.inputInt("Qual produto voce gostaria de selecionar? (SELECIONE PELO CODIGO)");
        if(estoque.temCodigo(var)) {
            return estoque.selecionarProduto(var);
        } else {
            System.out.println("Digite um código onde exista produto");
        }
        return manipulacaoDeQuantidades();
    }

    public void adicionarQuantidade(Produto produtoSelecionado) {
        int quantidade = Input.inputInt("Quantidade do produto " +produtoSelecionado.getNome()+ " a ser adionada: ");
        estoque.inserirQuantidadeEstoque(produtoSelecionado, quantidade);
        System.out.println("ADICIONADO(A) " +quantidade+ " UN PARA " +produtoSelecionado.getNome().toUpperCase() +"\nTOTAL: " +produtoSelecionado.getQnt());
    }

    public void retirarQuantidade(Produto produtoSelecionado) {
        int quantidade = Input.inputInt("Quantidade do produto " +produtoSelecionado.getNome()+ " a ser removida: ");
        estoque.retirarQuantidadeEstoque(produtoSelecionado, quantidade);
        if(quantidade <= produtoSelecionado.getQnt())
            System.out.println("RETIRADO(A) " + quantidade + " UN PARA " + produtoSelecionado.getNome().toUpperCase() + "\nTOTAL: " + produtoSelecionado.getQnt());
        else {
            System.out.println("Não há produtos suficientes que você solicitou");
        }
    }
}