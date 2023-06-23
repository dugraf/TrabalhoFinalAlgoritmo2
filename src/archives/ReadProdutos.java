package archives;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import estoque.Produto;

public class ReadProdutos
{
    private ArrayList<Produto> estoque = new ArrayList<Produto>();
    Produto produto = new Produto();

    public ArrayList<Produto> arquivo()
    {
        criaArquivo();
        return estoque;
    }

    public void criaArquivo()
    {
        String path = "C:\\temp\\ReadProdutos";
        File pasta = new File(path);
        verificaDiretorio(pasta);
        File file = new File(path + "\\produtos.csv");
        try
        {
            file.createNewFile();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        arquivoLeitura(file);
    }

    public void verificaDiretorio(File pasta)
    {
        if(!pasta.exists())
            if(pasta.mkdirs())
                System.out.println("Verificado que o arquivo nao estava no ambiente! Criado com sucesso! Favor, insira os dados necessarios neste.");
            else
                System.out.println("Falha ao criar a pasta.");
    }
    
    public void arquivoLeitura(File file)
    {
        try(BufferedReader leitura = new BufferedReader(new FileReader(file)))
        {
            String linha = leitura.readLine();
            while(linha != null)
            {
                String ln = linha;
                linha = leitura.readLine();
                passaParaLista(ln);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void passaParaLista(String linha)
    {
        if(linha != null)
        {
            String arrayObjectString[] = new String[4];
            arrayObjectString = linha.split(";");

            try
            {
                String nome = arrayObjectString[0];
                int qnt = Integer.valueOf(arrayObjectString[1]);
                int qntMinima = Integer.valueOf(arrayObjectString[2]);
                double preco = Double.valueOf(arrayObjectString[3]);

                produto = new Produto(nome, qnt, qntMinima, preco);
                estoque.add(produto);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println(e+ " CONFERIR O REGISTRO " +arrayObjectString+ " POIS ESTA COM DADOS INCONSISTENTES");
            }
            catch(NumberFormatException e)
            {
                System.out.println(e+ " CONFERIR O REGISTRO " +arrayObjectString+ " POIS ESTA COM DADOS INCONSISTENTES");
            }
        }
    }
}
