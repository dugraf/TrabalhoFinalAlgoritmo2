package estoque;

public class Produto
{
    private int codigo;
    private String nome;
    private int qnt, qntMinima;
    private double preco;

    public Produto(){}

    public Produto(int codigo, String nome, int qnt, int qntMinima, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.qnt = qnt;
        this.qntMinima = qntMinima;
        this.preco = preco;
    }

    public Produto(String nome, int qnt, int qntMinima, double preco) {
        this.nome = nome;
        this.qnt = qnt;
        this.qntMinima = qntMinima;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQnt() {
        return qnt;
    }
    public void setQnt(int qnt) {
        this.qnt = qnt;
    }
    public int getQntMinima() {
        return qntMinima;
    }
    public void setQntMinima(int qntMinima) {
        this.qntMinima = qntMinima;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return getCodigo()+ ". "+
            getNome()+
            "\tQUANTIDADE:" +getQnt()+
            "\tMINIMO:" +getQntMinima()+
            "\tPRECO:" +getPreco();
    }
}
