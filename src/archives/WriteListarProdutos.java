package archives;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import estoque.Produto;

public class WriteListarProdutos
{
    public void criaArquivo(ArrayList<Produto> lista, Produto produto)
    {
        String path = "C:\\temp\\ReadProdutos";
        File pasta = new File(path);
        verificaDiretorio(pasta);
        String file = path + "\\listaDeProdutos.txt";
        arquivoEscrita(lista, file, produto);
    }

    public void verificaDiretorio(File pasta)
    {
        if(!pasta.exists())
            if(pasta.mkdirs())
                System.out.println("Verificado que o arquivo nao estava no ambiente! Criado com sucesso! Favor, insira os dados necessarios neste.");
            else
                System.out.println("Falha ao criar a pasta.");
    }

    public void arquivoEscrita(ArrayList<Produto> lista, String file, Produto produto)
    {
        try(BufferedWriter escrita = new BufferedWriter(new FileWriter(file)))
        {
            for (int i = 0; i < lista.size(); i++)
            {
                escrita.write(lista.get(i).toString());
                escrita.newLine();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
