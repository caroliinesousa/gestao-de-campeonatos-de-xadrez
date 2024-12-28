package Classes.Pessoas;

public abstract class Pessoa {
    private String nome;
    private int idade;
    private char genero;

    public Pessoa(String nome, int idade, char genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public char getGenero() {
        return this.genero;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public abstract void exibirInformacoes();
}
