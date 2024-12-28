package Classes.Pessoas;

public class Arbitro extends Pessoa {
    private String certificacoes;

    public Arbitro(String nome, int idade, char genero, String certificacoes) {
        super(nome, idade, genero);
        this.certificacoes = certificacoes;
    }
    
    public String getCertificacoes() {
        return this.certificacoes;
    }
    public void setCertificacoes(String certificacoes) {
        this.certificacoes = certificacoes;
    }
    @Override
    public void exibirInformacoes() {
        System.out.println("Nome" + getNome() + ", Idade: " + getIdade() + ", Gênero: " + getGenero());
        System.out.println("Certificações: " + this.certificacoes);
    }

    
}
